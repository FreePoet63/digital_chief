package com.project.digital_chief.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    @Column(name = "died_date", nullable = false)
    private LocalDate diedDate;
    @Column(name = "birth_city", nullable = false)
    private String birthCity;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Book> books;
}
