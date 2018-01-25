package com.greenfoxacademy.annie.reddit.DTO;

public class Error {
    private String error;

    public Error() {

    }

    public Error(String errorMessage) {
        this.error = errorMessage;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
