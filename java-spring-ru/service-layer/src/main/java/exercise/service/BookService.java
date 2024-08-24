package exercise.service;

import exercise.dto.*;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.mapper.BookMapper;
import exercise.repository.BookRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAll() {
        var books = bookRepository.findAll();
        return books.stream()
                .map(b -> bookMapper.map(b))
                .toList();
    }

    public BookDTO findById(@Min(0) Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return bookMapper.map(book);
    }

    public BookDTO create(@Valid BookCreateDTO bookData) {
        var book = bookMapper.map(bookData);
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    public BookDTO update(@Valid BookUpdateDTO bookData, @Min(0) Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        bookMapper.update(bookData, book);
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    public void delete(@Min(0) Long id) {
        bookRepository.deleteById(id);
    }
    // END
}
