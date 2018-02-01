package com.greenfoxacademy.annie.pallidaexam.DTOs;

public class WantedPlateDTO {
    private String result;
    private DataDTO data;

    public WantedPlateDTO() {

    }

    public WantedPlateDTO(String result) {
        this.result = result;
    }

    public WantedPlateDTO(String result, DataDTO data) {
        this.result = result;
        this.data = data;
    }

    public DataDTO getData() {
        return data;
    }

    public String getResult() {
        return result;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
