package com.greenfoxacademy.hellobeanworld.Controller;

import com.greenfoxacademy.hellobeanworld.Service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtilitiesController {

    @Autowired
    UtilityService utilityService;

    @RequestMapping(value = "/useful")
    public String container(Model model) {
        model.addAttribute("utils", utilityService.getColors());
        return "utility";
    }

    @RequestMapping(value = "/useful/{color}")
    public String displayMainPage(Model model, @PathVariable("color") String color) {
        int index = 0;
        for(int i = 0; i < utilityService.getColors().size(); i++) {
            if(color.equals(utilityService.getColors().get(i))) {
                index = i;
                break;
            }
        }
        model.addAttribute("utils", utilityService.getColors());
        model.addAttribute("util1", utilityService.getColors().get(index));
        return "utility";
    }

    @RequestMapping(value = "/useful/colored")
    public String displayColoredPage(Model model) {
        model.addAttribute("utils", utilityService.getColors());
        model.addAttribute("util1", utilityService.randomColor());
        return "utility";
    }

    @RequestMapping(value = "useful/email")
    public String takeEmail(@RequestParam(value = "email") String email, Model model) {
        if(utilityService.validateEmail(email)) {
            model.addAttribute("umail", utilityService);
        } else {
            model.addAttribute("umail", utilityService);
        }
        return "emailpage";
    }

    @RequestMapping(value = "/useful/encoding")
    public String caesarEncode(@RequestParam(value = "text") String text, @RequestParam(value = "number") int number, Model model) {
        model.addAttribute("uceasar", utilityService.caesar(text,number));
        return "de-encodingpage";
    }

    @RequestMapping(value = "/useful/decoding")
    public String caesarDecode(@RequestParam(value = "text") String text, @RequestParam(value = "number") int number, Model model) {
        model.addAttribute("uceasar", utilityService.caesar(text,-number));
        return "de-encodingpage";
    }
}
