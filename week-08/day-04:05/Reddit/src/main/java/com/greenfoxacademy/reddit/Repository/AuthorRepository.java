package com.greenfoxacademy.reddit.Repository;

import com.greenfoxacademy.reddit.Model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
