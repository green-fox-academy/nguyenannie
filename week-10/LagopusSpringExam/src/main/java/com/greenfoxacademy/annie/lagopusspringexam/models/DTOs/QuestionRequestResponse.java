package com.greenfoxacademy.annie.lagopusspringexam.models.DTOs;

import java.util.ArrayList;
import java.util.List;

public class QuestionRequestResponse {

    private long id;
    private List<QuestionDto> questions;

    public QuestionRequestResponse() {
        questions = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }

}
