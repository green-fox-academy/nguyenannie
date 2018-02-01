package com.greenfoxacademy.annie.lagopusspringexam.Controller;

import com.greenfoxacademy.annie.lagopusspringexam.DTO.*;
import com.greenfoxacademy.annie.lagopusspringexam.Model.Quiz;
import com.greenfoxacademy.annie.lagopusspringexam.Service.QuizService;
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

    @Autowired
    public QuizRestController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/questions")
    public ResponseEntity<?> getQuestions() {
        List<QuestionDTO> questionDTOs = new ArrayList<>();
        List<Quiz> quizzes = quizService.find5RandomQuestions();
        for (Quiz quizze : quizzes) {
            questionDTOs.add(new QuestionDTO(quizze.getId(), quizze.getQuestion()));
        }

        questionRequestResponse.setId(1);
        questionRequestResponse.setQuestions(questionDTOs);
        return new ResponseEntity<>(questionRequestResponse, HttpStatus.OK);
    }

    @PostMapping("/answers")
    public ResponseEntity<Response> postAnswers(@RequestBody AnswerRequestBody answerRequestBody) {
        if (answerRequestBody.getId() != questionRequestResponse.getId()) {
            return new ResponseEntity<>(new Response("You answer to the wrong set of questions"),
                    HttpStatus.BAD_REQUEST);
        }

        List<QuestionDTO> questionDTOS = questionRequestResponse.getQuestions();
        boolean isAccepted = false;
        for (int i = 0; i < 5; i++) {
            long id = questionDTOS.get(i).getId();
            isAccepted = id == answerRequestBody.getAnswers().get(i).getId() &&
                    quizService.findOne(id).getAnswer().equals(answerRequestBody.getAnswers().get(i).getAnswer());
        }

        if (isAccepted) {
            return new ResponseEntity<>(new Response("Your answers are correct"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Response("Your answer is not correct"), HttpStatus.BAD_REQUEST);
        }
    }
}
