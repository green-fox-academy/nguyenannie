package com.greenfoxacademy.restexercise.Model.SithEndPoint;

import com.greenfoxacademy.restexercise.Model.RestResponse;
import org.springframework.stereotype.Component;

@Component
public class SithRequestBody extends RestResponse{
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
