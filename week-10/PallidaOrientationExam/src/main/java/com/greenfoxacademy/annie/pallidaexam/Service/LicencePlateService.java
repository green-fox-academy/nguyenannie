package com.greenfoxacademy.annie.pallidaexam.Service;

import com.greenfoxacademy.annie.pallidaexam.Model.LicencePlate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LicencePlateService {
    LicencePlate findOne(String plate);
    List<LicencePlate> findAll();
    void save(LicencePlate licencePlate);
    List<LicencePlate> findByPlateContaining(String licenceinput);
    List<LicencePlate> findPoliceCars();
    List<LicencePlate> findDiplomatCars();
    List<LicencePlate> findAllByCarBrand(String car_brand);
}
