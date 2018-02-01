package com.greenfoxacademy.annie.pallidaexam.controllers;

import com.greenfoxacademy.annie.pallidaexam.model.entities.LicencePlate;
import com.greenfoxacademy.annie.pallidaexam.services.LicencePlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/search")
public class WebController {

    private final LicencePlateService licencePlateService;

    @Autowired
    public WebController(LicencePlateService licencePlateService) {
        this.licencePlateService = licencePlateService;
    }

    @GetMapping("")
    public String search(@RequestParam(value = "q", required = false) String q,
                         @RequestParam(value = "police", required = false) Integer police,
                         @RequestParam(value = "diplomat", required = false) Integer diplomat,
//                         @Valid Form form,
//                         BindingResult bindingResult,
                         Model model) {

        List<LicencePlate> searches = null;

//        if(bindingResult.hasErrors()) {
//            return "form";
//        }
        if(q != null) {
            Pattern p = Pattern.compile("[A-Z0-9-]{1,7}");
            Matcher m = p.matcher(q);
            boolean b = m.matches();
            if(b) {
                searches = licencePlateService.findByPlateContaining(q);
                model.addAttribute("error", "");
            } else {
                model.addAttribute("error", "Sorry, the submitted licence plate is not valid");
            }
        }

        if(police != null && police == 1) {
            searches = licencePlateService.findPoliceCars();
        }

        if(diplomat != null && diplomat == 1) {
            searches = licencePlateService.findDiplomatCars();
        }

        model.addAttribute("searches", searches);
        return "form";
    }

    @GetMapping("/{brand}")
    public String searchByBrand(@PathVariable(value = "brand") String brand, Model model) {
        List<LicencePlate> searches = licencePlateService.findAllByCarBrand(brand);
        model.addAttribute("searches", searches);
        return "form";
    }

}
