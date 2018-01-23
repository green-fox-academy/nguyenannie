package com.greenfoxacademy.restexercise.Model;

import org.springframework.stereotype.Component;

@Component
public class Greeter extends RestResponse{
    private String welcome_Message;

    public Greeter() {

    }
    public Greeter(String name, String title) {
        this.welcome_Message = "Oh, hi there " + name + ", my dear " +  title +"!";
    }

    public String getWelcome_Message() {
        return welcome_Message;
    }

    public void setWelcome_Message(String welcome_Message) {
        this.welcome_Message = welcome_Message;
    }
}
