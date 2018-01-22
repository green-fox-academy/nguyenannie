package com.greenfoxacademy.restexercise.Model.DoUntilEndPoint;

import com.greenfoxacademy.restexercise.Model.RestResponse;
import org.springframework.stereotype.Component;

@Component
public class DoUntilGet extends RestResponse {
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
