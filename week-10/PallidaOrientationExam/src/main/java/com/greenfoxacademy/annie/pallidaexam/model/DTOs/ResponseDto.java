package com.greenfoxacademy.annie.pallidaexam.model.DTOs;

import java.util.List;

public class ResponseDto {

    private String result;
    private List<ClothingDto> clothes;

    public ResponseDto() {

    }

    public ResponseDto(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ClothingDto> getClothes() {
        return clothes;
    }

    public void setClothes(List<ClothingDto> clothes) {
        this.clothes = clothes;
    }

}
