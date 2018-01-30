package com.greenfoxacademy.annie.pallidaexam.Repository;

import com.greenfoxacademy.annie.pallidaexam.Model.LicencePlate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicencePlateRepository extends CrudRepository<LicencePlate, String>{
    List<LicencePlate> findAllByPlateContaining(String licenceinput);
    List<LicencePlate> findAllByPlateStartingWith(String str);
    List<LicencePlate> findAllByCarBrand(String car_brand);
}
