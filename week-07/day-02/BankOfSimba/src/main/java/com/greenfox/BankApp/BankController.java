package com.greenfox.BankApp;

import Model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankController {
    @RequestMapping(value = "/Exercise1")
    public String showBankAcc(Model model) {
        BankAccount bankAccount = new BankAccount("Simba", 2000, "lion");
        model.addAttribute("account",bankAccount);
        return "bankofsimba";
    }
}
