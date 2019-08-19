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
    public void deleteBook(long Id) {
        LibraryRepository.deleteById(Id);
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
        Book newBook = new Book();
        newBook.setId(oldBookId);
        newBook.setRate(book.getRate());
        newBook.setGenre(book.getGenre());
        newBook.setDescription(book.getDescription());
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(book.getAuthor());
        LibraryRepository.deleteById(oldBookId);
        LibraryRepository.save(newBook);
    }

    @Override
    public void updateAuthor(long oldAuthorId, Author author) {
        Author newAuthor = new Author();
        newAuthor.setAuthorId(oldAuthorId);
        newAuthor.setFName(author.getFName());
        newAuthor.setLName(author.getLName());
        newAuthor.setBooks(author.getBooks());
        authorRepo.deleteById(oldAuthorId);
        authorRepo.save(newAuthor);
    }

}
