package com.greenfoxacademy.pallidaretakeexam.Controller;

import com.greenfoxacademy.pallidaretakeexam.Model.Clothing;
import com.greenfoxacademy.pallidaretakeexam.Service.ClothingService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
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
    private int quantity;
    private List<Clothing> summaries = new ArrayList<>();

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
    public String postWareHouse(Model model, @ModelAttribute(value = "clothing") Clothing clothing,
                                HttpServletRequest request) {

        model.addAttribute("itemnames", clothingService.uniqueItemNames());
        model.addAttribute("sizes", clothingService.uniqueSizes());
        model.addAttribute("clothes", clothingService.findAll());
        model.addAttribute("clothing", clothing);

        quantity = Integer.parseInt(request.getParameter("quantity"));
        summaries.addAll(clothingService.findByItemNameAndSize(clothing.getItemName(), clothing.getSize()));
        return "redirect:/summary";
    }

    @GetMapping("/summary")
    public String summary(Model model, @ModelAttribute(value = "clothing") Clothing clothing) {
        model.addAttribute("summaries", summaries);
        model.addAttribute("quantity", quantity);
        float total = 0;
        for(Clothing w : summaries) {
            total += w.getUnitPrice();
        }
        model.addAttribute("subtotalprice", total * quantity);
        return "summary";
    }
}
