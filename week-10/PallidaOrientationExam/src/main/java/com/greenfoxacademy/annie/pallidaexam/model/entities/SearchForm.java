package com.greenfoxacademy.annie.pallidaexam.model.entities;

public class SearchForm {

    private String brand;
    private String color;

    public SearchForm() {

    }

    public SearchForm(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
