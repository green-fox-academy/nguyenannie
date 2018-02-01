package com.greenfoxacademy.annie.lagopusspringexam.repositories;

import com.greenfoxacademy.annie.lagopusspringexam.models.entities.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {

    Quiz findByQuestion(String question);

}
