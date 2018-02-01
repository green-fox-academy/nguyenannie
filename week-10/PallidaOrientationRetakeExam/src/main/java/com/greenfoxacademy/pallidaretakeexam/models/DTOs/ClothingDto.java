package com.greenfoxacademy.pallidaretakeexam.DTO;

import com.greenfoxacademy.pallidaretakeexam.Model.Clothing;

import java.util.List;

public class ClothingDTO {
    private String result;
    private List<Clothing> clothes;

    public ClothingDTO() {

    }

    public ClothingDTO(String result, List<Clothing> clothes) {
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
