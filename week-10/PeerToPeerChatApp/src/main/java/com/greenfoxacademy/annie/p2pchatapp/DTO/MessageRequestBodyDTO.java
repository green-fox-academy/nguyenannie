package com.greenfoxacademy.annie.p2pchatapp.DTO;

import com.greenfoxacademy.annie.p2pchatapp.Model.Appmessage;

import java.util.ArrayList;
import java.util.List;

public class MessageRequestBodyDTO {
    private AppmessageDTO message;
    private ClientDTO client;

    public MessageRequestBodyDTO() {

    }

    public AppmessageDTO getMessage() {
        return message;
    }

    public void setMessage(AppmessageDTO message) {
        this.message = message;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public boolean isNotValid() {
        return message.isNotValid() || client.isNotValid();
    }

    public String listOfMissingFields() {

        return message.listOfMissingFields() + client.listOfMissingFields();

    }

}
