package com.greenfox.programmerfoxclub.Repository;

import com.greenfox.programmerfoxclub.Entity.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

@Repository
public class FoxRepository {

    private final List<Fox> foxes = new ArrayList<>();
    private List<Food> foodValues = Arrays.asList(Food.values());
    private List<Drink> drinkValues = Arrays.asList(Drink.values());
    private List<Trick> trickValues = Arrays.asList(Trick.values());

    public FoxRepository() {
        super();

        foxes.add(new Fox());
        foxes.get(0).setName(Name.MsRed.toString());
        foxes.get(0).setTricks(new ArrayList<>(Arrays.asList("code in Haskell")));
        foxes.get(0).setDrink(Drink.apple_juice.toString());
        foxes.get(0).setFood(Food.apple.toString());

        foxes.add(new Fox());
        foxes.get(1).setName(Name.MrGreen.toString());
        foxes.get(1).setTricks(new ArrayList<>(Arrays.asList("code in Java", "play Overwatch")));
        foxes.get(1).setDrink(Drink.cola.toString());
        foxes.get(1).setFood(Food.chicken.toString());
    }

    public List<Fox> findAll() {
        return this.foxes;
    }

    public Fox findOne(String name) {
        int index = 0;
        for(int i = 0; i < foxes.size(); i++) {
            if(foxes.get(i).getName().equals(name)) {
                index = i;
                break;
            }
        }
        return foxes.get(index);
    }

    public void add(final Fox fox) {
        this.foxes.add(fox);
    }

    public boolean IsExisted(String name) {
        boolean result = false;
        for (Fox fox : foxes) {
            if (fox.getName().equals(name)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public List<Food> getFoodValues() {
        return foodValues;
    }

    public List<Drink> getDrinkValues() {
        return drinkValues;
    }

    public List<Trick> getTrickValues() {
        return trickValues;
    }
}
