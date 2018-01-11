package com.greenfox.programmerfoxclub.Model;

import java.util.List;

public class Fox {
    enum trickList{};
    enum nameList{};
    enum foodList{};
    enum drinkList{};

    private String name;
    private List<String> tricks;
    private String food;
    private String drink;
    private int trickNum;

    public Fox() {

    }

    public Fox(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFood() {
        return food;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getDrink() {
        return drink;
    }

    public void setTricks(List<String> tricks) {
        this.tricks = tricks;
    }

    public List<String> getTricks() {
        return tricks;
    }

    public int getTrickNum() {
        trickNum = getTricks().size();
        return trickNum;
    }
}
