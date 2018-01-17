package com.greenfox.programmerfoxclub.Service;

import com.greenfox.programmerfoxclub.Entity.Drink;
import com.greenfox.programmerfoxclub.Entity.Food;
import com.greenfox.programmerfoxclub.Entity.Fox;
import com.greenfox.programmerfoxclub.Entity.Trick;
import com.greenfox.programmerfoxclub.Repository.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoxService {

    private final FoxRepository foxRepository;

    @Autowired
    public FoxService(FoxRepository foxRepository) {
        super();
        this.foxRepository = foxRepository;
    }

    public List<Fox> findAll() {
        return this.foxRepository.findAll();
    }

    public Fox findOne(String name) {
        return this.foxRepository.findOne(name);
    }

    public void add(final Fox fox) {
        this.foxRepository.add(fox);
    }

    public boolean IsExisted(String name) {
        return foxRepository.IsExisted(name);
    }

    public List<Food> getFoodValues() {
        return foxRepository.getFoodValues();
    }

    public List<Drink> getDrinkValues() {
        return foxRepository.getDrinkValues();
    }

    public List<Trick> getTrickValues() {
        return foxRepository.getTrickValues();
    }
}
