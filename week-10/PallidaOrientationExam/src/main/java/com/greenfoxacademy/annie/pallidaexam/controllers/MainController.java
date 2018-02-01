package com.greenfoxacademy.annie.pallidaexam.Controller;

import com.greenfoxacademy.annie.pallidaexam.DTO.DataDTO;
import com.greenfoxacademy.annie.pallidaexam.DTO.LicencePlateDTO;
import com.greenfoxacademy.annie.pallidaexam.DTO.WantedPlateDTO;
import com.greenfoxacademy.annie.pallidaexam.Model.LicencePlate;
import com.greenfoxacademy.annie.pallidaexam.Service.LicencePlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class MainController {
    private final LicencePlateService licencePlateService;
    private List<String> wantedLicense = new ArrayList<>(Arrays.asList("CBI-960", "CXX-648", "MIND-01", "RB12-05", "TIBI-01"));

    @Autowired
    public MainController(LicencePlateService licencePlateService) {
        this.licencePlateService = licencePlateService;
    }

    @GetMapping("/{brand}")
    public ResponseEntity<LicencePlateDTO> findByBrand(@PathVariable(value = "brand") String brand) {
        LicencePlateDTO licencePlateDTO = new LicencePlateDTO();
        licencePlateDTO.setResult("ok");
        licencePlateDTO.setData(licencePlateService.findAllByCarBrand(brand));
        return new ResponseEntity<>(licencePlateDTO, HttpStatus.OK);
    }

    @GetMapping("/wanted/{plate}")
    public ResponseEntity<?> getWanted(@PathVariable(value = "plate") String plate) {
        if(!wantedLicense.contains(plate)) {
            return new ResponseEntity<Object>(new WantedPlateDTO("Not in the wanted list"), HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(new WantedPlateDTO("ok", new DataDTO(plate, true)), HttpStatus.OK);
        }
    }
}
