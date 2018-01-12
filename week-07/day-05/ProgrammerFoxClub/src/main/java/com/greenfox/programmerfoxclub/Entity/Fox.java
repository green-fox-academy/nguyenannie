package com.greenfox.programmerfoxclub.Entity;

import java.util.ArrayList;
import java.util.List;

public class Fox {

    private String name;
    private ArrayList<String> tricks;
    private ArrayList<String> learnedTricks = new ArrayList<>();
    private String food;
    private String drink;
    private int trickNum;
    private String trick;

    public Fox() {

    }

    public Fox(String name, String food, String drink, ArrayList<String> tricks) {
        this.name = name;
        this.food = food;
        this.drink = drink;
        this.tricks = tricks;
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

    public void setTrick(String trick) {
        this.trick = trick;
    }

    public String getTrick() {
        return trick;
    }

    public void setTricks(ArrayList<String> tricks) {
        this.tricks = tricks;
    }

    public List<String> getTricks() {
        return tricks;
    }

    public ArrayList<String> getLearnedTricks() {
        return learnedTricks;
    }

    public void setLearnedTricks(ArrayList<String> learnedTricks) {
        this.learnedTricks = learnedTricks;
    }

    public int getTrickNum() {
        trickNum = getTricks().size();
        return trickNum;
    }

    public void setTrickNum(int trickNum) {
        this.trickNum = trickNum;
    }

    public void addTrick(String newtrick) {
        getTricks().add(newtrick);
    }

    public boolean existed(String newtrick) {
        if(getTricks().contains(newtrick)) {
            return true;
        }
        return false;
    }

    public void removeTrick(String inputTrick) {
        for(String t : getTricks()) {
            if(t.equals(inputTrick)) {
                getTricks().remove(t);
                break;
            }
        }
    }

    public void addLearnedTrick(String learnedtrick) {
        getLearnedTricks().add(learnedtrick);
    }
}
