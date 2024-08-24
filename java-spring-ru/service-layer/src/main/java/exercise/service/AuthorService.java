package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public List<AuthorDTO> getAll() {
        var authors = authorRepository.findAll();
        return authors.stream()
                .map(a -> authorMapper.map(a))
                .toList();
    }

    public AuthorDTO findById(@Min(0) Long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return authorMapper.map(author);
    }

    public AuthorDTO create(@Valid AuthorCreateDTO authorData) {
        var author = authorMapper.map(authorData);
        authorRepository.save(author);
        return authorMapper.map(author);
    }

    public AuthorDTO update(@Valid AuthorUpdateDTO authorData, @Min(0) Long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        authorMapper.update(authorData, author);
        authorRepository.save(author);
        return authorMapper.map(author);
    }

    public void delete(@Min(0) Long id) {
        authorRepository.deleteById(id);
    }
    // END
}
