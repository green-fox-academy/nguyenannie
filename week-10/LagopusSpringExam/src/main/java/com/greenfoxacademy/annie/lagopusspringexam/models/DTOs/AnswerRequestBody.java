package com.greenfoxacademy.annie.lagopusspringexam.models.DTOs;

import java.util.ArrayList;
import java.util.List;

public class AnswerRequestBody {

    private long id;
    private List<AnswerDto> answers;

    public AnswerRequestBody() {
        this.answers = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }

}
