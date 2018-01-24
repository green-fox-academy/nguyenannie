package com.greenfoxacademy.annie.draxcaloriestable.Controller;

import com.greenfoxacademy.annie.draxcaloriestable.DTO.FoodDTO;
import com.greenfoxacademy.annie.draxcaloriestable.DTO.ModifyFoodDTO;
import com.greenfoxacademy.annie.draxcaloriestable.Entity.Food;
import com.greenfoxacademy.annie.draxcaloriestable.Service.FoodDbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drax")
public class Controller {
    private final FoodDbServiceImpl foodDbService;

    @Autowired
    public Controller(FoodDbServiceImpl foodDbService) {
        this.foodDbService = foodDbService;
    }

    @GetMapping("")
    public ResponseEntity<List<Food>> getCalorieTable() {
        return new ResponseEntity<>(foodDbService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Food> addFood(@RequestBody FoodDTO foodDTO) {
        Food food = new Food(foodDTO.getName(), foodDTO.getAmount(), foodDTO.getCalorie());
        foodDbService.save(food);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> modifyAmount(@RequestBody ModifyFoodDTO modifyFoodDTO,
                                             @RequestParam(value = "name") String name) {
        Food food = foodDbService.findByName(name);
        if(food != null) {
            food.setAmount(modifyFoodDTO.getAmount());
            foodDbService.save(food);
            return new ResponseEntity<>(food, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Error("Cannot find the food"), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestParam(value = "name") String name) {
        Food food = foodDbService.findByName(name);
        if(food != null) {
            FoodDTO foodDTO = food.clone();
            foodDbService.delete(foodDbService.findByName(name).getId());
            return new ResponseEntity<>(foodDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Error("Cannot find the food"), HttpStatus.BAD_REQUEST);
        }
    }
}
