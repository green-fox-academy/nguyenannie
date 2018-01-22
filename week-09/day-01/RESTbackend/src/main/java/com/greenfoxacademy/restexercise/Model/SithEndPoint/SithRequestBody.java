package com.greenfoxacademy.restexercise.Model.SithEndPoint;

import org.springframework.stereotype.Component;

@Component
public class SithRequestBody {
    private String text;

    public SithRequestBody() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
