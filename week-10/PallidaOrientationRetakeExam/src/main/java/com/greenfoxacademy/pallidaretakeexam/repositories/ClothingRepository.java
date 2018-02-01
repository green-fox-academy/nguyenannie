package com.greenfoxacademy.pallidaretakeexam.Repository;

import com.greenfoxacademy.pallidaretakeexam.Model.Clothing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothingRepository extends CrudRepository<Clothing, Long>{
    List<Clothing> findByItemNameAndSize(String itemName, String size);
    List<Clothing> findAllByUnitPriceLessThan(float price);
    List<Clothing> findAllByUnitPriceGreaterThan(float price);
    List<Clothing> findAllByUnitPriceEquals(float price);
}
