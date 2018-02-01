package com.greenfoxacademy.annie.lagopusspringexam.Repository;

import com.greenfoxacademy.annie.lagopusspringexam.Model.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {
    Quiz findByQuestion(String question);
}
