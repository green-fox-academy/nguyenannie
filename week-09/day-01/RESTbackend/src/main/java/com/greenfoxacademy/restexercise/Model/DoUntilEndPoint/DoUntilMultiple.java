package com.greenfoxacademy.restexercise.Model.DoUntilEndPoint;

import com.greenfoxacademy.restexercise.Model.RestResponse;
import org.springframework.stereotype.Component;

@Component
public class DoUntilMultiple extends RestResponse {
    private int result;

    public DoUntilMultiple() {

    }

    public DoUntilMultiple(int result) {
        this.result = consecutiveProduct(result);

    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int consecutiveProduct(int t) {
        if(t == 1) {
            return 1;
        }

        return t * consecutiveProduct(t - 1);
    }
}
