package com.greenfoxacademy.annie.draxcaloriestable.DTO;

public class FoodDTO {

    private String name;
    private int amount;
    private int calorie;

    public FoodDTO() {

    }

    public FoodDTO(String name, int amount, int calorie) {
        this.name = name;
        this.amount = amount;
        this.calorie = calorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }
}
