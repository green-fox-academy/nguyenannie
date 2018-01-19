package com.greenfoxacademy.restexercise.Model;

import org.springframework.stereotype.Component;

@Component
public class Doubling {
    private int input;
    private int result;

    public Doubling() {

    }

    public Doubling(int input) {
        this.input = input;
        this.result = input * 2;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
