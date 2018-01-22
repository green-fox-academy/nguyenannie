package com.greenfoxacademy.restexercise.Model.ArraysEndpoint;

import com.greenfoxacademy.restexercise.Model.RestResponse;
import org.springframework.stereotype.Component;

@Component
public class ArraysRequestBody extends RestResponse {
    private String what;
    private int[] numbers;

    public ArraysRequestBody() {

    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}
