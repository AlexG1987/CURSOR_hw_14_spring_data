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
    private long id;
    @Column(name = "title", nullable = false, unique = true, length = 100)
    private String title;
    @Column(name = "genre", nullable = false, unique = true, length = 50)
    private String genre;
    @Column(name = "description", nullable = false, unique = true, length = 250)
    private String description;
    @Column(name = "rate", nullable = false)
    private double rate;
    //@ManyToOne(fetch = FetchType.LAZY,optional=true)
    //@JoinTable(name = "authors", joinColumns = @JoinColumn(name = "author_id", referencedColumnName="id", insertable = false, updatable = false))
    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

}

