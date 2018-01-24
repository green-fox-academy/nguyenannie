package com.greenfoxacademy.restexercise.DTO;

import com.greenfoxacademy.restexercise.Model.RestResponse;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class DoUntilDTO extends RestResponse {
    @NotNull
    private int until;

    public DoUntilDTO() {

    }

    public DoUntilDTO(int until) {
        this.until = until;
    }

    public int getUntil() {
        return until;
    }

    public void setUntil(int until) {
        this.until = until;
    }
}
