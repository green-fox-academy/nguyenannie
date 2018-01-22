package com.greenfoxacademy.restexercise.Model.DoUntilEndPoint;

import org.springframework.stereotype.Component;

@Component
public class DoUntilGet {
    private int until;

    public DoUntilGet() {

    }

    public DoUntilGet(int until) {
        this.until = until;
    }

    public int getUntil() {
        return until;
    }

    public void setUntil(int until) {
        this.until = until;
    }
}
