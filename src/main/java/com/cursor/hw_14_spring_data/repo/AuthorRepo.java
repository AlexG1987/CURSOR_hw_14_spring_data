package com.cursor.hw_14_spring_data.repo;

import com.cursor.hw_14_spring_data.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long> {
}
