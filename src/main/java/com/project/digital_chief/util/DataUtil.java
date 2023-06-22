package com.project.digital_chief.util;

import com.project.digital_chief.exception.ResourceNotFoundException;
import com.project.digital_chief.model.*;
import com.project.digital_chief.repository.*;
import org.springframework.stereotype.Component;

@Component
public class DataUtil {
    public Author findAuthorOrThrowNotFound(Long id, AuthorRepository repository) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author Not Found"));
    }

    public Book findBookOrThrowNotFound(Long id, BookRepository repository) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book Not Found"));
    }
}
