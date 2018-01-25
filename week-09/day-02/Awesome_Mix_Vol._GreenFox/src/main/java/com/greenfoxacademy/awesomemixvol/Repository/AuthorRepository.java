package com.greenfoxacademy.awesomemixvol.Repository;

import com.greenfoxacademy.awesomemixvol.Model.Entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
