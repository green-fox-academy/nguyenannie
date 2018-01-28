package com.greenfoxacademy.annie.p2pchatapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }
}
