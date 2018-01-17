package com.greenfox.tamagochi.Service;

import com.greenfox.tamagochi.Model.Drink;
import com.greenfox.tamagochi.Model.Food;
import com.greenfox.tamagochi.Model.Fox;
import com.greenfox.tamagochi.Repository.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FoxServiceDBImpl implements FoxService {
    private final FoxRepository foxRepository;
    private List<Food> foodValues = Arrays.asList(Food.values());
    private List<Drink> drinkValues = Arrays.asList(Drink.values());

    @Autowired
    public FoxServiceDBImpl(FoxRepository foxRepository) {
        this.foxRepository = foxRepository;
    }

    @Override
    public void addNewFox(Fox fox) {
        foxRepository.save(fox);
    }

    @Override
    public void updateFox(Fox fox) {
        foxRepository.save(fox);
    }

    @Override
    public Fox searchOneByName(String name) {
        return foxRepository.findByName(name);
    }

    @Override
    public Fox searchOneById(long id) {
        return foxRepository.findOne(id);
    }

    @Override
    public void save(Fox fox) {
        foxRepository.save(fox);
    }

    public List<Drink> getDrinkValues() {
        return drinkValues;
    }

    public List<Food> getFoodValues() {
        return foodValues;
    }
}
