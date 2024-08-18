package exercise.controller;

import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }


    // BEGIN
    @Test
    public void testShow() throws Exception {
        Task testTask = new Task();
        testTask.setTitle(faker.lorem().word());
        testTask.setDescription(faker.lorem().paragraph());
        taskRepository.save(testTask);

        var request = get("/tasks/" + testTask.getId())
                        .contentType(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
        var body = result.getResponse().getContentAsString();
        assertThatJson(body).and(
                a -> a.node("title").isEqualTo(testTask.getTitle()),
                a -> a.node("description").isEqualTo(testTask.getDescription())
        );
    }

    @Test
    public void testCreate() throws Exception {

        var data = new HashMap<String, String>();
        data.put("title", faker.lorem().word());
        data.put("description", faker.lorem().paragraph());

        var request = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));

        mockMvc.perform(request).andExpect(status().isCreated());
        var testTask = taskRepository.findByTitle(data.get("title"));
        assertThat(testTask.isPresent());
    }

    @Test
    public void testUpdate() throws Exception {
        Task testTask = new Task();
        testTask.setTitle(faker.lorem().word());
        testTask.setDescription(faker.lorem().paragraph());
        taskRepository.save(testTask);

        var data = new HashMap<>();
        data.put("title", "Title for test task");

        var request = put("/tasks/" + testTask.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));

        mockMvc.perform(request).andExpect(status().isOk());

        testTask = taskRepository.findById(testTask.getId()).get();
        assertThat(testTask.getTitle().equals(data.get("title")));
    }

    @Test
    public void testDelete() throws Exception {

        Task testTask = new Task();
        testTask.setTitle(faker.lorem().word());
        testTask.setDescription(faker.lorem().paragraph());
        taskRepository.save(testTask);

        var task = taskRepository.findById(testTask.getId());
        assertTrue(task.isPresent());

        var request = delete("/tasks/" + testTask.getId())
                        .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andExpect(status().isOk());

        task = taskRepository.findById(testTask.getId());
        assertFalse(task.isPresent());
    }
    // END
}
