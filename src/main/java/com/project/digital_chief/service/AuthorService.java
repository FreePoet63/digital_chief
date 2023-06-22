package com.project.digital_chief.service;

import com.project.digital_chief.exception.ResourceNotFoundException;

import com.project.digital_chief.model.Author;
import com.project.digital_chief.repository.AuthorRepository;
import com.project.digital_chief.util.DataUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final DataUtil dataUtil;

    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return dataUtil.findAuthorOrThrowNotFound(id, authorRepository);
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author author) {
        if (!authorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found: " + id);
        }
        author.setId(id);
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.delete(dataUtil.findAuthorOrThrowNotFound(id, authorRepository));
    }
}
