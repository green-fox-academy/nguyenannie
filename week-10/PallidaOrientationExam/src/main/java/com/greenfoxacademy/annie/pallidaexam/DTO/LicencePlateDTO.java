package com.greenfoxacademy.annie.pallidaexam.DTO;

import com.greenfoxacademy.annie.pallidaexam.Model.LicencePlate;

import java.util.List;

public class LicencePlateDTO {
    private String result;
    private List<LicencePlate> data;

    public LicencePlateDTO() {

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
