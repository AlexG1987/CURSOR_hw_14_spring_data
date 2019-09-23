package com.cursor.hw_14_spring_data.controller;

import com.cursor.hw_14_spring_data.model.Book;
import com.cursor.hw_14_spring_data.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("book")
public class BookController {

    @Autowired
    private final BookServiceImpl LibraryServiceImpl;

    @PostMapping("/")
    public ResponseEntity addBook(@RequestBody Book book) {
        LibraryServiceImpl.addBook(book);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Book>> sortedBooksByAuthor(@PathVariable("id") long id) {
        LibraryServiceImpl.getBooksByAuthor(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @ResponseBody
    @GetMapping("/{genre}")
    public ResponseEntity<List<Book>> sortedBooksByGenre(@PathVariable("genre") String genre) {
        LibraryServiceImpl.getBooksByGenre(genre);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable("id") long bookId) {
        LibraryServiceImpl.deleteBook(bookId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateBook(@PathVariable("id") int oldBookId, @RequestBody Book book) {
        LibraryServiceImpl.updateBook(oldBookId, book);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
