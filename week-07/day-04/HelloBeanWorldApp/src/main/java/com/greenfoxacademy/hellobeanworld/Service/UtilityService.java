package com.greenfoxacademy.hellobeanworld.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class UtilityService {
    private ArrayList<String> colors;
    Random random;
    private String emailMessage;
    private boolean goodEmail;
    private String text;
    private int number;

    public UtilityService() {
        colors = new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("lime");
        colors.add("orange");
        colors.add("magenta");
        random = new Random();
    }

    public String randomColor() {
        return colors.get(random.nextInt(colors.size()));
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public boolean validateEmail(String email) {
        if(email.contains("@") && email.contains(".")) {
            setEmailMessage(email + " is a valid email address");
            setGoodEmail(true);
            return true;
        } else {
            setEmailMessage(email + " is not a valid email address");
            setGoodEmail(false);
            return false;
        }
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    public boolean isGoodEmail() {
        return goodEmail;
    }

    public void setGoodEmail(boolean goodEmail) {
        this.goodEmail = goodEmail;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String caesar(String text, int number) {
        String result = "";
        for(int i = 0; i < text.length(); i++) {
            result += (char)((int)text.charAt(i) + number);
        }
        return result;
    }
}
