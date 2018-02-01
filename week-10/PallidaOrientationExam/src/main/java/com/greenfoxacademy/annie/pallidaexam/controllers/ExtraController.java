package com.greenfoxacademy.annie.pallidaexam.Controller;

import com.greenfoxacademy.annie.pallidaexam.Model.LicencePlate;
import com.greenfoxacademy.annie.pallidaexam.Model.SearchForm;
import com.greenfoxacademy.annie.pallidaexam.Service.LicencePlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ExtraController {
    private final LicencePlateService licencePlateService;
    List<String> wantedLicense = new ArrayList<>(Arrays.asList("CBI-960", "CXX-648", "MIND-01", "RB12-05", "TIBI-01"));

    @Autowired
    public ExtraController(LicencePlateService licencePlateService) {
        this.licencePlateService = licencePlateService;
    }

    @GetMapping("/licensesearch")
    public String getInfo(Model model, @ModelAttribute("searchform") SearchForm searchForm) {
        model.addAttribute("searchplates", new ArrayList<LicencePlate>());
        return "extraform";
    }

    @PostMapping("/licensesearch")
    public String searchLicense(@ModelAttribute("searchform") SearchForm searchForm, Model model) {
        List<LicencePlate> licencePlates;

        if(searchForm.getBrand() == null || searchForm.getBrand().equals("")
                || searchForm.getColor() == null || searchForm.getColor().equals("")) {
            licencePlates = null;
        } else {
            licencePlates = licencePlateService.findAllByCarBrandAndColor(searchForm.getBrand(), searchForm.getColor());
            System.out.println("color " + searchForm.getColor() + " brand " + searchForm.getBrand());
            System.out.println(licencePlates);
        }

        model.addAttribute("searchplates",licencePlates);
        return "extraform";
    }
}
