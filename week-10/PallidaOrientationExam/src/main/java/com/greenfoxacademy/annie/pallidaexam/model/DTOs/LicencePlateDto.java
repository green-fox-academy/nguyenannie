package com.greenfoxacademy.annie.pallidaexam.model.DTOs;

import com.greenfoxacademy.annie.pallidaexam.model.entities.LicencePlate;

import java.util.List;

public class LicencePlateDto {

    private String result;
    private List<LicencePlate> data;

    public LicencePlateDto() {

    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<LicencePlate> getData() {
        return data;
    }

    public void setData(List<LicencePlate> data) {
        this.data = data;
    }

}
