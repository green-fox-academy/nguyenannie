package com.greenfoxacademy.annie.pallidaexam.model.DTOs;

public class WantedPlateDto {

    private String result;
    private DataDto data;

    public WantedPlateDto() {

    }

    public WantedPlateDto(String result) {
        this.result = result;
    }

    public WantedPlateDto(String result, DataDto data) {
        this.result = result;
        this.data = data;
    }

    public DataDto getData() {
        return data;
    }

    public String getResult() {
        return result;
    }

    public void setData(DataDto data) {
        this.data = data;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
