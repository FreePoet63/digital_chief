package com.project.digital_chief.repository;

import com.project.digital_chief.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
