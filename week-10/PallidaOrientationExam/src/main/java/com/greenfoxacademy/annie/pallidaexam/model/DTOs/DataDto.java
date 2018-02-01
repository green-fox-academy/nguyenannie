package com.greenfoxacademy.annie.pallidaexam.DTOs;

public class DataDTO {
    private String plate;
    private boolean wanted;

    public DataDTO() {

    }

    public DataDTO(String plate, boolean wanted) {
        this.plate = plate;
        this.wanted = wanted;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public boolean isWanted() {
        return wanted;
    }

    public void setWanted(boolean wanted) {
        this.wanted = wanted;
    }
}
