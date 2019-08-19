package com.cursor.hw_14_spring_data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "genre", nullable = false)
    private String genre;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "rate", nullable = false)
    private double rate;
    @ManyToOne(fetch = FetchType.LAZY,optional=true)
    @JoinTable(name = "authors", joinColumns = @JoinColumn(name = "authorId"))
    private Author author;

}

