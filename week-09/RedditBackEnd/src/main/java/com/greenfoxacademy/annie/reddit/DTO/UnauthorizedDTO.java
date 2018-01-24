package com.greenfoxacademy.annie.reddit.DTO;

public class UnauthorizedDTO extends ResponseDTO{
    private String error;

    public UnauthorizedDTO() {

    }

    public UnauthorizedDTO(String errorMessage) {
        this.error = errorMessage;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
