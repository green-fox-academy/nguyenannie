package com.greenfox.programmerfoxclub.Repository;

import com.greenfox.programmerfoxclub.Model.Fox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class FoxRepository {

    private final List<Fox> foxes = new ArrayList<>();

    public FoxRepository() {
        super();

        foxes.add(new Fox());
        foxes.get(0).setName("Ms. Red");
        foxes.get(0).setTricks(new ArrayList<>(Arrays.asList("smile")));
        foxes.get(0).setDrink("smoothie");
        foxes.get(0).setFood("apple");
    }

    public List<Fox> findAll() {
        return this.foxes;
    }

    public void add(final Fox fox) {
        this.foxes.add(fox);
    }
}
