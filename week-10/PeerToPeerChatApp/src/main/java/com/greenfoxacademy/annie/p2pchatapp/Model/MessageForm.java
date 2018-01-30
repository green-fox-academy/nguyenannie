package com.greenfoxacademy.annie.p2pchatapp.Model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class MessageForm {
    @NotNull
    @Pattern(regexp = ".+", message = "Field must not be empty")
    private String message;

    public MessageForm() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
