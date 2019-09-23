package com.cursor.hw_14_spring_data.controller;

import com.cursor.hw_14_spring_data.model.Author;
import com.cursor.hw_14_spring_data.service.impl.AuthorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("author")
public class AuthorController {

    @Autowired
    private final AuthorServiceImpl authorService;

    @PostMapping("/")
    public ResponseEntity addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthor(@PathVariable("id") long authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateAuthor(@PathVariable("id") int oldAuthorId, @RequestBody Author author) {
        authorService.updateAuthor(oldAuthorId, author);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
