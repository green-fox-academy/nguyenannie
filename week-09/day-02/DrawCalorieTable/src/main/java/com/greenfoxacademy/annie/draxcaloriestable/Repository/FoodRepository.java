package com.greenfoxacademy.annie.draxcaloriestable.Repository;

import com.greenfoxacademy.annie.draxcaloriestable.Entity.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long>{
    Food findByName(String name);
}
