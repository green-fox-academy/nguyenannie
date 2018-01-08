package com.greenfox.controllers;

import com.greenfox.Model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MultipleAccountController {

    private List<BankAccount> bankAccounts;

    MultipleAccountController() {
        bankAccounts = new ArrayList<>();
        bankAccounts.add(new BankAccount("Mufasa", 2500, "lion", "King", "Good One"));
        bankAccounts.add(new BankAccount("Pumbaa", 1700, "pig", "not King", "Good One"));
        bankAccounts.add(new BankAccount("Rafiki", 1000, "monkey", "not King", "Bad Guy"));
        bankAccounts.add(new BankAccount("Zazu", 2300, "bird", "not King", "Good One"));
        bankAccounts.add(new BankAccount("Nala", 2700, "lion", "not King", "Bad Guy"));
    }

    @GetMapping(value = "/multipleAccounts")
    public String displayAccInfo(Model model) {
        model.addAttribute("accounts", bankAccounts);
        System.out.println(bankAccounts.get(0).getName());
        System.out.println(bankAccounts.get(0).getBalance());
        return "bankofsimba2";
    }


    @PostMapping(value = "/multipleAccounts")
    public String accountSubmit(@ModelAttribute BankAccount accounts, Model model) {

        for(BankAccount acc : bankAccounts) {
            double t = acc.getBalance();
            if(acc.getKing().equals("King")) {
                t += 100;
                acc.setBalance(t);
            } else {
                t += 10;
                acc.setBalance(t);
            }
        }
        System.out.println(bankAccounts.get(0).getBalance());

        model.addAttribute("accounts", bankAccounts);
        return "bankofsimba2";
    }
}
