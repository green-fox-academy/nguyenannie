package com.greenfoxacademy.annie.pallidaexam.Controller;

import com.greenfoxacademy.annie.pallidaexam.Model.Form;
import com.greenfoxacademy.annie.pallidaexam.Model.LicencePlate;
import com.greenfoxacademy.annie.pallidaexam.Service.LicencePlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
                         @RequestParam(value = "police", required = false) String police,
                         @RequestParam(value = "diplomat", required = false) String diplomat,
                         @Valid Form form,
                         BindingResult bindingResult,
                         Model model) {

        List<LicencePlate> searches = null;

        if(bindingResult.hasErrors()) {
            return "form";
        }

        if(form.getQ() != null) {
            searches = licencePlateService.findByPlateContaining(q);
        }

        if(police != null) {
            searches = licencePlateService.findPoliceCars();
        }

        if(diplomat != null) {
            searches = licencePlateService.findDiplomatCars();
        }

        model.addAttribute("searches", searches);
        return "form";
    }

    @GetMapping("/{brand}")
    public String searchByBrand(@PathVariable(value = "brand") String brand, Model model,
                                @Valid Form form, BindingResult bindingResult) {
        List<LicencePlate> searches = licencePlateService.findAllByCarBrand(brand);
        model.addAttribute("searches", searches);
        return "form";
    }
}
