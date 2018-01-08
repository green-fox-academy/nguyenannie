package com.greenfox.controllers;

import com.greenfox.Model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MultipleAccountController {

    @RequestMapping(value = "/multipleAccounts")
    public String displayAccInfo(Model model) {

        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(new BankAccount("Mufasa", 2500, "lion"));
        bankAccounts.add(new BankAccount("Pumbaa", 1700, "pig"));
        bankAccounts.add(new BankAccount("Rafiki", 1000, "monkey"));
        bankAccounts.add(new BankAccount("Zazu", 2300, "bird"));
        bankAccounts.add(new BankAccount("Nala", 2700, "lion"));

        model.addAttribute("accounts", bankAccounts);
        return "bankofsimba2";
    }
}
