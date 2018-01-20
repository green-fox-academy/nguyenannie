package com.greenfoxacademy.restexercise.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String getMainPage() {
        return "index";
    }
}
