package com.greenfoxacademy.annie.pallidaexam.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "licence_plates")
public class LicencePlate {
    @Id
    @Column(name = "plate")
    private String plate;
    @Column(name = "carBrand")
    private String carBrand;
    @Column(name = "car_model")
    private String car_model;
    @Column(name = "color")
    private String color;
    @Column(name = "year")
    private int year;

    public LicencePlate() {

    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
