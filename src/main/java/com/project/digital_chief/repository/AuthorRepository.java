package com.project.digital_chief.repository;

import com.project.digital_chief.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
