package com.greenfoxacademy.annie.lagopusspringexam.DTO;

import java.util.ArrayList;
import java.util.List;

public class AnswerRequestBody {
    private long id;
    private List<AnswerDTO> answers;

    public AnswerRequestBody() {
        this.answers = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }
}
