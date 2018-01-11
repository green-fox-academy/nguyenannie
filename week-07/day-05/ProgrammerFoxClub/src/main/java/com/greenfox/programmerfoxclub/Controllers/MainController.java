package com.greenfox.programmerfoxclub.Controllers;

import com.greenfox.programmerfoxclub.Service.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private FoxService foxService;

    @RequestMapping(value = "/")
    public String mainPage() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String postLoginPage(@RequestParam(value = "name") String petname, Model model) {
        int index = 0;
        String result = "error";

        for(int i = 0; i < foxService.findAll().size(); i++) {
            if(foxService.findAll().get(i).getName().equals(petname)) {
                index = i;
                result = "index";
                break;
            }
        }

        model.addAttribute("fox", foxService.findAll().get(index));
        return result;
    }
}
