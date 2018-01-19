package com.greenfoxacademy.restexercise.Model;

import org.springframework.stereotype.Component;

@Component
public class ArraysDouble {
    private int[] result;

    public ArraysDouble() {

    }

    public ArraysDouble(int[] numbers) {
       result = doubleArrays(numbers);
    }

    public int[] getResult() {
        return result;
    }

    public void setResult(int[] result) {
        this.result = result;
    }

    public int[] doubleArrays(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * 2;
        }
        return numbers;
    }
}
