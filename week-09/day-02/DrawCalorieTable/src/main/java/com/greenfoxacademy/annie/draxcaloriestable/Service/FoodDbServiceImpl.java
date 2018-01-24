package com.greenfoxacademy.annie.draxcaloriestable.Service;

import com.greenfoxacademy.annie.draxcaloriestable.Entity.Food;
import com.greenfoxacademy.annie.draxcaloriestable.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodDbServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    @Autowired
    public FoodDbServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public List<Food> findAll() {
        List<Food> foods = new ArrayList<>();
        foodRepository.findAll().forEach(foods::add);
        return foods;
    }

    @Override
    public Food findOne(long id) {
        return foodRepository.findOne(id);
    }

    @Override
    public void save(Food food) {
        foodRepository.save(food);
    }

    @Override
    public void delete(long id) {
        foodRepository.delete(id);
    }

    @Override
    public Food findByName(String name) {
        return foodRepository.findByName(name);
    }
}
