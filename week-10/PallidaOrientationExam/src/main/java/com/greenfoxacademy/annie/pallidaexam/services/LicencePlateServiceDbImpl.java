package com.greenfoxacademy.annie.pallidaexam.services;

import com.greenfoxacademy.annie.pallidaexam.model.entities.LicencePlate;
import com.greenfoxacademy.annie.pallidaexam.repositories.LicencePlateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LicencePlateServiceDbImpl implements LicencePlateService {

    private final LicencePlateRepository licencePlateRepository;

    @Autowired
    public LicencePlateServiceDbImpl(LicencePlateRepository licencePlateRepository) {
        this.licencePlateRepository = licencePlateRepository;
    }


    @Override
    public LicencePlate findOne(String plate) {
        return licencePlateRepository.findOne(plate);
    }

    @Override
    public List<LicencePlate> findAll() {
        List<LicencePlate> licencePlates = new ArrayList<>();
        licencePlateRepository.findAll().forEach(licencePlates::add);
        return licencePlates;
    }

    @Override
    public void save(LicencePlate licencePlate) {
        licencePlateRepository.save(licencePlate);
    }

    @Override
    public List<LicencePlate> findByPlateContaining(String licenceinput) {
        return licencePlateRepository.findAllByPlateContaining(licenceinput);
    }

    @Override
    public List<LicencePlate> findPoliceCars() {
        return licencePlateRepository.findAllByPlateStartingWith("RB");
    }

    @Override
    public List<LicencePlate> findDiplomatCars() {
        return licencePlateRepository.findAllByPlateStartingWith("DT");
    }

    @Override
    public List<LicencePlate> findAllByCarBrand(String car_brand) {
        return licencePlateRepository.findAllByCarBrand(car_brand);
    }

    @Override
    public List<LicencePlate> findAllByCarBrandAndColor(String brand, String color) {
        return licencePlateRepository.findAllByCarBrandAndColor(brand, color);
    }

}
