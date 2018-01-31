package com.greenfoxacademy.annie.p2pchatapp.DTO;

import java.util.ArrayList;
import java.util.List;

public class ClientDTO {
    private String id;

    public ClientDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public boolean isNotValid() {
        return this.id == null;
    }


    public String listOfMissingFields() {
        List<String> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        if(this.id == null) {
            list.add("client.id");
        }

        for(String missingField : list) {
            result.append(missingField);
        }

        return result.toString();

    }
}
