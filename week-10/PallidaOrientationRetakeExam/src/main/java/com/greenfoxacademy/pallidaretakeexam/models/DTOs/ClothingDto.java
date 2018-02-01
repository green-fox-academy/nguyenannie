package com.greenfoxacademy.pallidaretakeexam.models.DTOs;

import com.greenfoxacademy.pallidaretakeexam.models.entities.Clothing;

import java.util.List;

public class ClothingDto {

    private String result;
    private List<Clothing> clothes;

    public ClothingDto() {

    }

    public ClothingDto(String result, List<Clothing> clothes) {
        this.result = result;
        this.clothes = clothes;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Clothing> getClothes() {
        return clothes;
    }

    public void setClothes(List<Clothing> clothes) {
        this.clothes = clothes;
    }

}
