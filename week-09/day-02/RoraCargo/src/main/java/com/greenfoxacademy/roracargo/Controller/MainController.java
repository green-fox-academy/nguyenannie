package com.greenfoxacademy.roracargo.Controller;

import com.greenfoxacademy.roracargo.Model.CargoFill;
import com.greenfoxacademy.roracargo.Model.CargoStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rocket")
public class MainController {
    private CargoStatus cargoStatus= new CargoStatus(0,0,0,"empty", false);
    private CargoFill cargoFill = new CargoFill();
    private int fill_amount = 0;

    @GetMapping("")
    public ResponseEntity<CargoStatus> getCargoStatus() {
        return new ResponseEntity<>(cargoStatus, HttpStatus.OK);
    }

    @GetMapping("/fill")
    public ResponseEntity<CargoFill> getCargoFill(@RequestParam("caliber") String caliber,
                                  @RequestParam("amount") Integer amount) {

        cargoFill.setAmount(amount);
        cargoFill.setReceived(caliber);
        fill_amount += amount;

        if(fill_amount/12500 * 100 == 100) {
            cargoFill.setShipstatus("full");
            cargoFill.setReady(true);
            cargoStatus.setShipstatus("full");
            cargoStatus.setReady(true);
        } else if(fill_amount/12500 * 100 > 100) {
            cargoFill.setShipstatus("overloaded");
            cargoFill.setReady(true);
            cargoStatus.setShipstatus("overloaded");
            cargoStatus.setReady(true);
        } else {
            cargoStatus.setShipstatus(String.valueOf(fill_amount * 100 /12500) + "%");
            cargoFill.setShipstatus(String.valueOf(fill_amount * 100 /12500) + "%");
            cargoFill.setReady(false);
            cargoStatus.setReady(false);
        }

        switch (caliber) {
            case ".25":
                cargoStatus.setCaliber25(cargoStatus.getCaliber25() + 1);
                break;
            case ".30":
                cargoStatus.setCaliber30(cargoStatus.getCaliber25() + 1);
                break;
            case ".50":
                cargoStatus.setCaliber50(cargoStatus.getCaliber50() + 1);
                break;
        }

        return new ResponseEntity<>(cargoFill, HttpStatus.OK);
    }
}
