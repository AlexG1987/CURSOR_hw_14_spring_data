package com.cursor.hw_14_spring_data.controller;

import com.cursor.hw_14_spring_data.model.Author;
import com.cursor.hw_14_spring_data.service.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class AuthorController {

    private final LibraryServiceImpl LibraryServiceImpl;

    @Autowired
    public AuthorController(LibraryServiceImpl libraryServiceImpl) {
        LibraryServiceImpl = libraryServiceImpl;
    }

    @PostMapping("/addAuthor")
    public ResponseEntity addAuthor(@RequestBody Author author) {
        LibraryServiceImpl.addAuthor(author);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();

    }

    @DeleteMapping("/deleteAuthor/{id}")
    public ResponseEntity deleteAuthor(@PathVariable("id") long authorId) {
        LibraryServiceImpl.deleteAuthor(authorId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PatchMapping("/updateAuthor/{id}")
    public ResponseEntity updateAuthor(@PathVariable("id") int oldAuthorId, @RequestBody Author author) {
        LibraryServiceImpl.updateAuthor(oldAuthorId, author);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
