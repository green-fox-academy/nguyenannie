package com.greenfoxacademy.restexercise.DTO;

import com.greenfoxacademy.restexercise.Model.RestResponse;
import org.springframework.stereotype.Component;

@Component
public class TranslationRequestDTO extends RestResponse{
    private String text;
    private String lang;

    public TranslationRequestDTO() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
