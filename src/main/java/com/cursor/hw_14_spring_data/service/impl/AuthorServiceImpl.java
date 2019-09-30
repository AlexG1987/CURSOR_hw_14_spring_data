package com.cursor.hw_14_spring_data.service.impl;

import com.cursor.hw_14_spring_data.model.Author;
import com.cursor.hw_14_spring_data.repo.AuthorRepo;
import com.cursor.hw_14_spring_data.repo.BookRepo;
import com.cursor.hw_14_spring_data.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private final BookRepo bookRepository;
    private final AuthorRepo authorRepo;

    @Override
    public void addAuthor(Author author) {
        authorRepo.save(author);
    }

    @Override
    public void deleteAuthor(long authorId) {
        authorRepo.deleteById(authorId);
    }

    @Override
    public Author updateAuthor(long oldAuthorId, Author newAuthor) {
        if (bookRepository.existsById(oldAuthorId)) {
            authorRepo.deleteById(oldAuthorId);
            Author author = new Author();
            author.setBooks(newAuthor.getBooks());
            author.setLName(newAuthor.getLName());
            author.setFName(newAuthor.getFName());
            author.setId(oldAuthorId);
            return authorRepo.save(author);
        } else {
            return authorRepo.save(newAuthor);
        }
    }

}
