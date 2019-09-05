package com.cursor.hw_14_spring_data.service;

import com.cursor.hw_14_spring_data.model.Author;
import com.cursor.hw_14_spring_data.model.Book;
import com.cursor.hw_14_spring_data.repo.AuthorRepo;
import com.cursor.hw_14_spring_data.repo.LibraryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepo LibraryRepository;

    private final AuthorRepo authorRepo;


    public LibraryServiceImpl(LibraryRepo libraryRepository, AuthorRepo authorRepo) {
        LibraryRepository = libraryRepository;
        this.authorRepo = authorRepo;
    }

    @Override
    public void addAuthor(Author author) {
        authorRepo.save(author);
    }

    @Override
    public void deleteAuthor(long authorId) {
        authorRepo.deleteById(authorId);
    }

    @Override
    public void addBook(Book book) {
        LibraryRepository.save(book);
    }

    @Override
    public void deleteBook(long id) {
        LibraryRepository.deleteById(id);
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return LibraryRepository.findByGenre(genre);
    }

    @Override
    public List<Book> getBooksByAuthor(long authorId) {
        return LibraryRepository.findByAuthor(authorId);
    }

    @Override
    public void updateBook(long oldBookId, Book book) {
        if (LibraryRepository.existsById(oldBookId)) {
            LibraryRepository.deleteById(oldBookId);
            LibraryRepository.save(book);
        } else {
            LibraryRepository.save(book);
        }
    }

    @Override
    public void updateAuthor(long oldAuthorId, Author author) {
        if (LibraryRepository.existsById(oldAuthorId)) {
            authorRepo.deleteById(oldAuthorId);
            authorRepo.save(author);
        } else {
            authorRepo.deleteById(oldAuthorId);
            authorRepo.save(author);
        }
    }

}
