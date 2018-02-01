package com.greenfoxacademy.pallidaretakeexam.controllers;

import com.greenfoxacademy.pallidaretakeexam.models.entities.Clothing;
import com.greenfoxacademy.pallidaretakeexam.models.entities.ClothingOrder;
import com.greenfoxacademy.pallidaretakeexam.models.entities.OrderForm;
import com.greenfoxacademy.pallidaretakeexam.services.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    private final ClothingService clothingService;
    private List<ClothingOrder> summaries = new ArrayList<>();

    @Autowired
    public WebController(ClothingService clothingService) {
        this.clothingService = clothingService;
    }

    @GetMapping("/warehouse")
    public String getWareHouse(Model model) {
        model.addAttribute("itemnames", clothingService.uniqueItemNames());
        model.addAttribute("sizes", clothingService.uniqueSizes());
        model.addAttribute("clothes", clothingService.findAll());
        model.addAttribute("clothing", new Clothing("", ""));
        return "mainpage";
    }

    @PostMapping("/warehouse")
    public String postWareHouse(Model model, @ModelAttribute(value = "clothing") OrderForm orderForm) {

        model.addAttribute("itemnames", clothingService.uniqueItemNames());
        model.addAttribute("sizes", clothingService.uniqueSizes());
        model.addAttribute("clothes", clothingService.findAll());
        model.addAttribute("clothing", orderForm);

        List<Clothing> clothesWithSameNameandSize = clothingService.findByItemNameAndSize(orderForm.getItemName(), orderForm.getSize());
        for(Clothing clothing : clothesWithSameNameandSize) {
            summaries.add(new ClothingOrder(clothing.getItemName(), clothing.getSize(), orderForm.getQuantity(), clothing.getUnitPrice()));
        }
        return "redirect:/warehouse/summary";
    }

    @GetMapping("/warehouse/summary")
    public String summary(Model model, @ModelAttribute(value = "clothing") OrderForm orderForm) {
        model.addAttribute("summaries", summaries);
        model.addAttribute("quantity", orderForm.getQuantity());
        return "summary";
    }

}