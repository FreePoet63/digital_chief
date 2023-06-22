package com.project.digital_chief.service;

import com.project.digital_chief.exception.ResourceNotFoundException;
import com.project.digital_chief.model.Book;
import com.project.digital_chief.repository.BookRepository;
import com.project.digital_chief.util.DataUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final DataUtil dataUtil;

    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return dataUtil.findBookOrThrowNotFound(id, bookRepository);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found: " + id);
        }
        book.setId(id);
        return bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.delete(dataUtil.findBookOrThrowNotFound(id, bookRepository));
    }
}
