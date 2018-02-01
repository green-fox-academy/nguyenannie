package com.greenfoxacademy.annie.lagopusspringexam.controllers;

import com.greenfoxacademy.annie.lagopusspringexam.models.DTOs.*;
import com.greenfoxacademy.annie.lagopusspringexam.models.entities.Quiz;
import com.greenfoxacademy.annie.lagopusspringexam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuizRestController {

    private final
    QuizService quizService;
    private QuestionRequestResponse questionRequestResponse = new QuestionRequestResponse();
    private long count;

    @Autowired
    public QuizRestController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/questions")
    public ResponseEntity<?> getQuestions() {
        List<QuestionDto> questionDTOs = new ArrayList<>();
        List<Quiz> quizzes = quizService.find5RandomQuestions();
        for (Quiz quizze : quizzes) {
            questionDTOs.add(new QuestionDto(quizze.getId(), quizze.getQuestion()));
        }
        count += 1;
        questionRequestResponse.setId(count);
        questionRequestResponse.setQuestions(questionDTOs);
        return new ResponseEntity<>(questionRequestResponse, HttpStatus.OK);
    }

    @PostMapping("/answers")
    public ResponseEntity<ResponseDto> postAnswers(@RequestBody AnswerRequestBody answerRequestBody) {
        String message = "default";
        List<QuestionDto> questionDTOS = questionRequestResponse.getQuestions();

        if (answerRequestBody.getId() != count || answerRequestBody.getAnswers().size() > questionDTOS.size()
                || answerRequestBody.getAnswers().size() < questionDTOS.size()) {
            message = "Your answer is not qualified!";
            return new ResponseEntity<>(new ResponseDto(message),
                    HttpStatus.BAD_REQUEST);
        }

        boolean isAccepted = false;

        List<Long> questionIds = new ArrayList<>();
        for(int i = 0; i < questionRequestResponse.getQuestions().size(); i++) {
            questionIds.add(questionRequestResponse.getQuestions().get(i).getId());
        }

        for(int i = 0; i < answerRequestBody.getAnswers().size(); i++ ) {
            long answerId = answerRequestBody.getAnswers().get(i).getId();
            if(!questionIds.contains(answerId)) {
                message = "Wrong set of questions";
                return new ResponseEntity<>(new ResponseDto(message), HttpStatus.BAD_REQUEST);
            }
        }

        for(int i = 0; i < answerRequestBody.getAnswers().size(); i++) {
            long answerId = answerRequestBody.getAnswers().get(i).getId();
            String correctAnswer = quizService.findOne(answerId).getAnswer();
            String receivedAnswer = answerRequestBody.getAnswers().get(i).getAnswer();
            if(!receivedAnswer.equals(correctAnswer)) {
                message = "Your answers are not correct";
                return new ResponseEntity<>(new ResponseDto(message), HttpStatus.BAD_REQUEST);
            } else {
                message = "Your answers are correct";
                isAccepted = true;
            }
        }

        if (isAccepted) {
            return new ResponseEntity<>(new ResponseDto(message), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseDto("Something went wrong"), HttpStatus.BAD_REQUEST);
        }
    }

}
