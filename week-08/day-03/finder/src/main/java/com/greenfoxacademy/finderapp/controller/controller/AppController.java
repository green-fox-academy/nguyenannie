package com.greenfoxacademy.finderapp.controller.controller;

import com.greenfoxacademy.finderapp.controller.service.UserService;
import com.greenfoxacademy.finderapp.controller.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AppController {
    private final
    UserService service;

    @Autowired
    public AppController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model, HttpServletRequest req) {
        model.addAttribute("yolo", service.getAll());
        return "todos";
    }

    @PostMapping("/app")
    public String create(Model model, HttpServletRequest req) {
        User newUser = new User();
        newUser.setFirstName(req.getParameter("setfirstname"));
        newUser.setLastName(req.getParameter("setlastname"));
        service.save(newUser);
        model.addAttribute("new_user", newUser);
        model.addAttribute("yolo", service.getAll());
        return "redirect:/";
    }
}