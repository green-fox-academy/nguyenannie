package com.greenfoxacademy.annie.lagopusspringexam.Service;

import com.greenfoxacademy.annie.lagopusspringexam.Model.Quiz;
import com.greenfoxacademy.annie.lagopusspringexam.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceDbImpl implements QuizService {
    private final QuizRepository quizRepository;

    @Autowired
    public QuizServiceDbImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public List<Quiz> findAll() {
        List<Quiz> quizzes = new ArrayList<>();
        quizRepository.findAll().forEach(quizzes::add);
        return quizzes;
    }

    @Override
    public Quiz findOne(long id) {
        return quizRepository.findOne(id);
    }
}
