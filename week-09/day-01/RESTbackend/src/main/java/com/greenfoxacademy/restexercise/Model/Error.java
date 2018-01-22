package com.greenfoxacademy.restexercise.Model;

import org.springframework.stereotype.Component;

@Component
public class Error extends RestResponse {
    private String errorMessage;

    public Error() {

    }

    public Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
