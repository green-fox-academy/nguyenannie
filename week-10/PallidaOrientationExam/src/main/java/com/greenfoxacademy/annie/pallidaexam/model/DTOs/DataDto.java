package com.greenfoxacademy.annie.pallidaexam.model.DTOs;

public class DataDto {

    private String plate;
    private boolean wanted;

    public DataDto() {

    }

    public DataDto(String plate, boolean wanted) {
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
