package com.cursor.hw_14_spring_data.service;

import com.cursor.hw_14_spring_data.model.Author;
import com.cursor.hw_14_spring_data.model.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    void deleteBook(long id);

    Book updateBook(long oldBookId, Book book);

    List<Book> getBooksByGenre(String genre);

    List<Book> getBooksByAuthor(long authorId);

}
