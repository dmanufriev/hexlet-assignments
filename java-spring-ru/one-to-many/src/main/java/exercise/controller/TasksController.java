package exercise.controller;

import java.util.List;

import exercise.dto.*;
import exercise.mapper.TaskMapper;
import exercise.model.Task;
import exercise.model.User;
import exercise.repository.UserRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    // BEGIN

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskMapper taskMapper;

    @GetMapping(path = "")
    public List<TaskDTO> index() {
        var tasks = taskRepository.findAll();
        return tasks.stream()
                .map(t -> taskMapper.map(t))
                .toList();
    }

    @GetMapping(path = "/{id}")
    public TaskDTO show(@PathVariable Long id) {
        var task = taskRepository.findById(id)
                                    .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return taskMapper.map(task);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@Valid @RequestBody TaskCreateDTO taskData) {
        var task = taskMapper.map(taskData);
        var assignee = task.getAssignee();
        assignee.addTask(task);
        //
        taskRepository.save(task);
//        userRepository.save(assignee);
        var taskDto = taskMapper.map(task);
        return taskDto;
    }

    @PutMapping(path = "/{id}")
    public TaskDTO update(@Valid @RequestBody TaskUpdateDTO taskData, @PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        var assignee = task.getAssignee();
        assignee.removeTask(task);
        userRepository.save(assignee);
        taskMapper.update(taskData, task);
        task.getAssignee().addTask(task);
        taskRepository.save(task);
        return taskMapper.map(task);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        var assignee = task.getAssignee();
        assignee.removeTask(task);
        taskRepository.delete(task);
    }
    // END
}
