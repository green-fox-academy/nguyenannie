package com.greenfoxacademy.restexercise.Model.TranslateEndPoint;

import com.greenfoxacademy.restexercise.Model.RestResponse;
import org.springframework.stereotype.Component;

@Component
public class TranslateRequestBody extends RestResponse{
    private String text;
    private String lang;

    public TranslateRequestBody() {

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
