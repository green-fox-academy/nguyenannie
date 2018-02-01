package com.greenfoxacademy.annie.lagopusspringexam.DTO;

import java.util.ArrayList;
import java.util.List;

public class QuestionRequestResponse {
    private long id;
    private List<QuestionDTO> questions;

    public QuestionRequestResponse() {
        questions = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}
