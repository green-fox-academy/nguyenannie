package com.greenfoxacademy.restexercise.DTO;

import com.greenfoxacademy.restexercise.Model.RestResponse;
import org.springframework.stereotype.Component;

@Component
public class SithRequestDTO extends RestResponse{
    private String text;

    public SithRequestDTO() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
