package com.greenfoxacademy.restexercise.Model.DoUntilEndPoint;

import com.greenfoxacademy.restexercise.Model.RestResponse;
import org.springframework.stereotype.Component;

@Component
public class DoUntilSum extends RestResponse{
    private int result;

    public DoUntilSum() {

    }

    public DoUntilSum(int result) {
        this.result = result * (result + 1) / 2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
