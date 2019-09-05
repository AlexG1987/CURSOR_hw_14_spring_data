package com.cursor.hw_14_spring_data.repo;

import com.cursor.hw_14_spring_data.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LibraryRepo extends CrudRepository<Book, Long> {

    List<Book> findByGenre(String genre);
    List<Book> findByAuthor(long authorId);

}
