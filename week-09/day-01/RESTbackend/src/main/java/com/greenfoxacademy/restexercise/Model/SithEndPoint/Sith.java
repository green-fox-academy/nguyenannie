package com.greenfoxacademy.restexercise.Model.SithEndPoint;

import com.greenfoxacademy.restexercise.Model.RestResponse;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Sith extends RestResponse{
    private String sith_text;

    public Sith() {

    }

    public Sith(String text) {
        this.sith_text = sithReverser(text);
    }

    public String getSith_text() {
        return sith_text;
    }

    public void setSith_text(String sith_text) {
        this.sith_text = sith_text;
    }

    private String sithReverser(String message) {
        String[] randomDummy = {"Arrgh. Uhm.", "Arrghh.", "Uhm...", "Err..err.err"};
        Random r = new Random();
        String output = "";
        for (String sentence : message.split("[.]")) {
            output += scrambleSentence(sentence.trim()).trim() + ". " + randomDummy[r.nextInt(randomDummy.length)];
        }
        return output;
    }

    private String scrambleSentence(String sentence) {
        String[] words = sentence.toLowerCase().split(" ");
        String scrambled = "";
        for(int i = 0; i < words.length - (words.length % 2); i+=2) {
            scrambled += words[i + 1] + " " + words[i] + " ";
        }
        if(words.length % 2 == 1) {
            scrambled += words[words.length - 1];
        }
        return scrambled.substring(0,1).toUpperCase() + scrambled.substring(1);
    }
}
