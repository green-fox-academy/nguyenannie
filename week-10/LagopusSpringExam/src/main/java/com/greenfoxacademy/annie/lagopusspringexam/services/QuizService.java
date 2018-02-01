package com.greenfoxacademy.annie.lagopusspringexam.services;

import com.greenfoxacademy.annie.lagopusspringexam.models.entities.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {

    List<Quiz> findAll();
    Quiz findOne(long id);
    List<Quiz> find5RandomQuestions();
    Quiz findByQuestion(String question);

}
