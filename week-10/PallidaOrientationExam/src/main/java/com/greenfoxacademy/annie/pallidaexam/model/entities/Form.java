package com.greenfoxacademy.annie.pallidaexam.model.entities;

import javax.validation.constraints.Pattern;

public class Form {

    @Pattern(regexp = "[A-Z0-9-]{1,7}", message = "Sorry, the submitted licence plate is not valid")
    private String q;

    public Form() {

    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

}
