package com.greenfoxacademy.groot.Model;

import org.springframework.stereotype.Component;

@Component
public class Groot extends RestResponse{
    private String received;
    private String translated;

    public Groot() {

    }

    public Groot(String received, String translated) {
        this.received = received;
        this.translated = translated;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getTranslated() {
        return translated;
    }

    public void setTranslated(String translated) {
        this.translated = translated;
    }
}
