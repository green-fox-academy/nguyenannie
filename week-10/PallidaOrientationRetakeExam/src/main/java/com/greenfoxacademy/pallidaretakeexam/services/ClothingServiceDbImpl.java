package com.greenfoxacademy.pallidaretakeexam.Service;

import com.greenfoxacademy.pallidaretakeexam.Model.Clothing;
import com.greenfoxacademy.pallidaretakeexam.Repository.ClothingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothingServiceDbImpl implements ClothingService {
    private final ClothingRepository clothingRepository;

    @Autowired
    public ClothingServiceDbImpl(ClothingRepository wareHouseRepository) {
        this.clothingRepository = wareHouseRepository;
    }

    @Override
    public List<Clothing> findAll() {
        List<Clothing> warehouses = new ArrayList<>();
        clothingRepository.findAll().forEach(warehouses::add);
        return warehouses;
    }

    @Override
    public List<String> uniqueItemNames() {
        List<String> itemNames = new ArrayList<>();
        for(int i = 0; i < findAll().size(); i++) {
            itemNames.add(findAll().get(i).getItemName());
        }
        return itemNames.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<String> uniqueSizes() {
        List<String> sizes = new ArrayList<>();
        for(int i = 0; i < findAll().size(); i++) {
            sizes.add(findAll().get(i).getSize());
        }
        return sizes.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Clothing> findByItemNameAndSize(String itemName, String size) {
        return clothingRepository.findByItemNameAndSize(itemName, size);
    }

    @Override
    public List<Clothing> findAllByUnitPriceLessThan(float price) {
        return clothingRepository.findAllByUnitPriceLessThan(price);
    }

    @Override
    public List<Clothing> findAllByUnitPriceGreaterThan(float price) {
        return clothingRepository.findAllByUnitPriceGreaterThan(price);
    }

    @Override
    public List<Clothing> findAllByUnitPriceEquals(float price) {
        return clothingRepository.findAllByUnitPriceEquals(price);
    }

    @Override
    public float findPrice(List<Clothing> clothes) {
        float price = 0;
        for(Clothing clothing : clothes) {
            price += clothing.getUnitPrice();
        }
        return price/clothes.size();
    }

}
