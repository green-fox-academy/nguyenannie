package com.greenfoxacademy.restexercise.Model.ArraysEndpoint;

import com.greenfoxacademy.restexercise.Model.RestResponse;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.IntStream;

@Component
public class ArraySumandMultiple extends RestResponse {
    private int result;

    public ArraySumandMultiple() {

    }

    public ArraySumandMultiple(String what, int[] numbers) {
        if(what.equals("sum")) {
            result = sum(numbers);
        } else if(what.equals("multiple")) {
            result = mutiple(numbers);
        }
    }


    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    int sum(int[] numbers) {
        return IntStream.of(numbers).sum();
    }

    int mutiple(int[] numbers) {
        return Arrays.stream(numbers).reduce(1, (a ,b) -> (a * b));
    }
}
