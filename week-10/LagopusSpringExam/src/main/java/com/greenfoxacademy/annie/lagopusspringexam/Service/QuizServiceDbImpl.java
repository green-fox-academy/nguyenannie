package com.greenfoxacademy.annie.lagopusspringexam.Service;

import com.greenfoxacademy.annie.lagopusspringexam.Model.Quiz;
import com.greenfoxacademy.annie.lagopusspringexam.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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

    @Override
    public List<Quiz> find5RandomQuestions() {
        List<Long> quizIds = new ArrayList<>();
        for(int i = 1; i < findAll().size() + 1; i++) {
            quizIds.add((long) i);
        }
        Collections.shuffle(quizIds);

        List<Long> randomIds = new ArrayList<>();
        for(int i = 1; i < 6; i++) {
            randomIds.add(quizIds.get(i));
        }

        List<Quiz> result = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            result.add(quizRepository.findOne(randomIds.get(i)));
        }

        return result;
    }

    @Override
    public Quiz findByQuestion(String question) {
        return quizRepository.findByQuestion(question);
    }
}
