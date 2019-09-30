package com.cursor.hw_14_spring_data.service.impl;

import com.cursor.hw_14_spring_data.model.Book;
import com.cursor.hw_14_spring_data.repo.BookRepo;
import com.cursor.hw_14_spring_data.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookRepo bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    @Override
    public List<Book> getBooksByAuthor(long authorId) {
        return bookRepository.findByAuthor(authorId);
    }

    @Override
    public Book updateBook(long oldBookId, Book newBook) {
        if (bookRepository.existsById(oldBookId)) {
            bookRepository.deleteById(oldBookId);
            Book book = new Book();
            book.setId(oldBookId);
            book.setAuthor(newBook.getAuthor());
            book.setTitle(newBook.getTitle());
            book.setDescription(newBook.getDescription());
            book.setGenre(newBook.getGenre());
            book.setRate(newBook.getRate());
            return bookRepository.save(book);
        } else {
            return bookRepository.save(newBook);
        }
    }

}
