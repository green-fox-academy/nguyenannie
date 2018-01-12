package com.greenfox.programmerfoxclub.Controllers;

import com.greenfox.programmerfoxclub.Entity.Food;
import com.greenfox.programmerfoxclub.Entity.Fox;
import com.greenfox.programmerfoxclub.Service.FoxService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    private final FoxService foxService;

    @Autowired
    MainController(FoxService foxService){
        this.foxService = foxService;
    }

    @RequestMapping(value = "/foxclub/{foxname}")
    public String mainPage(Model model, @PathVariable String foxname) {
        model.addAttribute("fox", foxService.findOne(foxname));
        return "index";
    }

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String postLoginPage(@RequestParam(value = "foxname") String foxname, Model model) {
        String result;
        if(foxService.IsExisted(foxname)) {
            result = "redirect:/foxclub/" + foxname;
            model.addAttribute("fox", foxService.findOne(foxname));
        } else {
            result = "wannasignup";
        }
        return result;
    }

    @GetMapping(value = "/register")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping(value = "/register")
    public String postRegisterPage(Model model, HttpServletRequest req) {
        String name = req.getParameter("setname");
        String food = req.getParameter("setfood");
        String drink = req.getParameter("setdrink");
        String trick = req.getParameter("settrick");
        Fox newFox = new Fox(name, food, drink, new ArrayList<>(Arrays.asList(trick)));
        foxService.add(newFox);
        model.addAttribute("fox", newFox);
        return "redirect:/foxclub/" + newFox.getName();
    }


    @GetMapping("foxclub/{foxname}/nutritionStore")
    public String getNutrition(Model model, @PathVariable String foxname){
        model.addAttribute("fox",foxService.findOne(foxname));
        model.addAttribute("foods", foxService.getFoodValues());
        model.addAttribute("drinks", foxService.getDrinkValues());
        return "nutritionStore";
    }

    @PostMapping(value = "foxclub/{foxname}/nutritionStore")
    public String nutrition(Model model, @PathVariable String foxname, HttpServletRequest req) {
        foxService.findOne(foxname).setDrink(req.getParameter("adddrinkhere"));
        foxService.findOne(foxname).setFood(req.getParameter("addfoodhere"));
        model.addAttribute("fox", foxService.findOne(foxname));
        return "redirect:/foxclub/" + foxname;
    }
}
