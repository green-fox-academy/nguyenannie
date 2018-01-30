package com.greenfoxacademy.annie.p2pchatapp.Model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Form {
    @NotNull
    @Pattern(regexp = ".+", message = "Field must not be empty")
    private String name;

    public Form() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
