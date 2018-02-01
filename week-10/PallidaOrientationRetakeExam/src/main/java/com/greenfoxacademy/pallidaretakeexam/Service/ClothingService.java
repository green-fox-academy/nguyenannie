package com.greenfoxacademy.pallidaretakeexam.Service;

import com.greenfoxacademy.pallidaretakeexam.Model.Clothing;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClothingService {
    List<Clothing> findAll();
    List<String> uniqueItemNames();
    List<String> uniqueSizes();
    List<Clothing> findByItemNameAndSize(String itemName, String size);
    List<Clothing> findAllByUnitPriceLessThan(float price);
    List<Clothing> findAllByUnitPriceGreaterThan(float price);
    List<Clothing> findAllByUnitPriceEquals(float price);
    float findPrice(List<Clothing> clothes);
}
