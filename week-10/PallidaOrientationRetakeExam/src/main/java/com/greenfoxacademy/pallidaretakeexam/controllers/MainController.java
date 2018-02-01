package com.greenfoxacademy.pallidaretakeexam.controllers;

import com.greenfoxacademy.pallidaretakeexam.models.DTOs.ClothingDto;
import com.greenfoxacademy.pallidaretakeexam.models.entities.Clothing;
import com.greenfoxacademy.pallidaretakeexam.services.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final ClothingService clothingService;

    @Autowired
    public MainController(ClothingService clothingService) {
        this.clothingService = clothingService;
    }

    @GetMapping("/warehouse/query")
    public ResponseEntity<?> getQuery(@RequestParam(value = "price", required = false) String price,
                                      @RequestParam(value = "type", required = false) String type) {
        List<Clothing> clothes;
        switch (type) {
            case "lower":
                clothes = clothingService.findAllByUnitPriceLessThan(Float.parseFloat(price));
                return new ResponseEntity<>(new ClothingDto("ok", clothes), HttpStatus.OK);
            case "higher":
                clothes = clothingService.findAllByUnitPriceGreaterThan(Float.parseFloat(price));
                return new ResponseEntity<>(new ClothingDto("ok", clothes), HttpStatus.OK);
            case "equal":
                clothes = clothingService.findAllByUnitPriceEquals(Float.parseFloat(price));
                return new ResponseEntity<>(new ClothingDto("ok", clothes), HttpStatus.OK);
            default:
                return new ResponseEntity<>(new ClothingDto("ok", null), HttpStatus.BAD_REQUEST);
        }
    }

}
