package com.greenfoxacademy.annie.lagopusspringexam.Service;

import com.greenfoxacademy.annie.lagopusspringexam.Model.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {
    List<Quiz> findAll();
    Quiz findOne(long id);
}
