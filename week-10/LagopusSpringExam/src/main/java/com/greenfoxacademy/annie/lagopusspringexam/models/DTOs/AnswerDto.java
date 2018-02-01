package com.greenfoxacademy.annie.lagopusspringexam.models.DTOs;

public class AnswerDto {

    private long id;
    private String answer;

    public AnswerDto() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
