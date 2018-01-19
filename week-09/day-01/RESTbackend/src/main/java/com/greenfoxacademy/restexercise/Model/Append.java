package com.greenfoxacademy.restexercise.Model;

import org.springframework.stereotype.Component;

@Component
public class Append {
    private String appended;

    public Append() {

    }

    public Append(String appended) {
        this.appended = appended + "a";
    }

    public String getAppended() {
        return appended;
    }

    public void setAppended(String appended) {
        this.appended = appended;
    }
}
