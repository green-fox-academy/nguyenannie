package com.greenfoxacademy.annie.p2pchatapp.DTO;

public class Error {
    private String status;
    private String message;

    public Error() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}