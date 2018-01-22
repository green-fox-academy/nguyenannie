package com.greenfoxacademy.restexercise.Model.TranslateEndPoint;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TranslateResponse {
    private String translated;
    private String lang;

    public TranslateResponse() {

    }

    public TranslateResponse(String text) {
        this.translated = translate(text);
        this.lang = "teve";
    }

    public String getTranslated() {
        return translated;
    }

    public void setTranslated(String translated) {
        this.translated = translated;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    private String translate(String text) {
        List<String> texts = new ArrayList<>();
        List<String> vowels = new ArrayList<>(Arrays.asList("u", "e", "o", "a", "i", "U", "E", "O", "A", "I", "é",
                "Á", "É", "á", "í", "Í", "Ó", "ó", "ö", "Ö", "ü", "Ü", "ú", "ű", "Ű", "Ú"));

        for(int i = 0; i < text.length(); i++) {
            texts.add(String.valueOf(text.charAt(i)));
        }

        for(int i = 0; i < texts.size(); i++) {
            if(vowels.contains(texts.get(i))) {
                texts.set(i, texts.get(i) + "v" + texts.get(i).toLowerCase());
            }
        }

        StringBuilder translated = new StringBuilder();

        for (String text1 : texts) {
            translated.append(text1);
        }

        return String.valueOf(translated);
    }

}
