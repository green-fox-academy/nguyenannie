package com.greenfoxacademy.annie.p2pchatapp.DTO;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.greenfoxacademy.annie.p2pchatapp.Model.Appuser;
import com.greenfoxacademy.annie.p2pchatapp.Model.UniqueRandomNumber;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class AppmessageDTO {
    private Integer id;
    private String username;
    private String text;
    private Instant timestamp;

    public AppmessageDTO(String username, String text) {
        this.username = username;
        this.text = text;
        this.timestamp = Instant.now();
        this.id = UniqueRandomNumber.generate();
    }

    public AppmessageDTO(String username, String text, Integer id, Instant timestamp) {
        this.username = username;
        this.text = text;
        this.timestamp = timestamp;
        this.id = id;
    }

    public AppmessageDTO() {
        //this.timestamp = Instant.now();
        //this.id = UniqueRandomNumber.generate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //@JsonGetter
    public Long getTimestamp() {
        return this.timestamp.toEpochMilli();
    }

    //@JsonSetter
    public void setTimestamp(Long time) {
        this.timestamp = Instant.ofEpochMilli(time);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public boolean isNotValid() {
        return this.username == null || this.id == null || this.text == null || this.timestamp == null;
    }

    public String listOfMissingFields() {
        List<String> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        if(this.username == null) {
            list.add("message.user");
        }

        if(this.text == null) {
            list.add("message.text");
        }

        if(this.timestamp == null) {
            list.add("message.timestamp");
        }

        if(this.id == null) {
            list.add("message.id");
        }

        for(String missingField : list) {
            result.append(missingField);
            result.append(" ");
        }

        return result.toString();

    }
}
