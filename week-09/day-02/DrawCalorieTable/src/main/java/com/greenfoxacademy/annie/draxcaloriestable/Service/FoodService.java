package com.greenfoxacademy.annie.draxcaloriestable.Service;

import com.greenfoxacademy.annie.draxcaloriestable.Entity.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodService {
    List<Food> findAll();
    Food findOne(long id);
    void save(Food food);
    void delete(long id);
    Food findByName(String name);
}
