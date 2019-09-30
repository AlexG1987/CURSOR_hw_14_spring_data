package com.cursor.hw_14_spring_data.service;

import com.cursor.hw_14_spring_data.model.Author;

public interface AuthorService {

    void addAuthor(Author author);

    void deleteAuthor(long authorId);

    Author updateAuthor(long oldAuthorId, Author author);

}
