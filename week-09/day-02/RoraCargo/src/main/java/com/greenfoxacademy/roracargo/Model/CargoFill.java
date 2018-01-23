package com.greenfoxacademy.roracargo.Model;

import org.springframework.stereotype.Component;

@Component
public class CargoFill {
    private String received;
    private int amount;
    private String shipstatus;
    private boolean ready;

    public CargoFill() {

    }

    public CargoFill(String received, int amount) {
        this.received  =received;
        this.amount = amount;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getShipstatus() {
        return shipstatus;
    }

    public void setShipstatus(String shipstatus) {
        this.shipstatus = shipstatus;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
}
