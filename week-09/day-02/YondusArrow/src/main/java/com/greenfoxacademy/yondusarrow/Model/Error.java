package com.greenfoxacademy.yondusarrow.Model;

import org.springframework.stereotype.Component;

@Component
public class Error extends RestResponse{
    private String error;

    public Error(String error) {
        this.error = error;
    }

    public Error() {

    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
