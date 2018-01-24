package com.greenfoxacademy.annie.draxcaloriestable.Entity;

import com.greenfoxacademy.annie.draxcaloriestable.DTO.FoodDTO;

import javax.persistence.*;

@Entity
@Table
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    private int amount;
    private int calorie;

    public Food() {

    }

    public Food(String name, int amount, int calorie) {
        this.name = name;
        this.amount = amount;
        this.calorie = calorie;

    }

    public FoodDTO clone() {
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setAmount(this.getAmount());
        foodDTO.setCalorie(this.getCalorie());
        foodDTO.setName(this.name);
        return foodDTO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
