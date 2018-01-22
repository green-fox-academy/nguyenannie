package com.greenfoxacademy.restexercise.Model;

import org.springframework.stereotype.Component;

@Component
public class Greeter extends RestResponse{
    private String welcomeMessage;

    public Greeter() {

    }
    public Greeter(String name, String title) {
        this.welcomeMessage = "Oh, hi there " + name + ", my dear " +  title +"!";
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }
}
