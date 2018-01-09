package com.greenfox.controllers;

import com.greenfox.Model.AccountContainer;
import com.greenfox.Model.AccountContainerService;
import com.greenfox.Model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MultipleAccountController {
    @Autowired
    private AccountContainerService accountContainerService;

    @ModelAttribute("allBankAccounts")
    public List<AccountContainer> populateBankAccounts() {
        return this.accountContainerService.findAll();
    }

    MultipleAccountController() {
        super();
    }

    @GetMapping({"/multipleAccounts"})
    public String displayAccInfo(final AccountContainer accountContainer) {
        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(new BankAccount("Mufasa", 2500, "lion", "King", "Good One"));
        bankAccounts.add(new BankAccount("Pumbaa", 1700, "pig", "not King", "Good One"));
        bankAccounts.add(new BankAccount("Rafiki", 1000, "monkey", "not King", "Bad Guy"));
        bankAccounts.add(new BankAccount("Zazu", 2300, "bird", "not King", "Good One"));
        bankAccounts.add(new BankAccount("Nala", 2700, "lion", "not King", "Bad Guy"));
        accountContainer.setBankAccounts(bankAccounts);
        return "bankofsimba2";
    }

    @PostMapping(value="/multipleAccounts", params={"addAccount"})
    public String addAccount(final AccountContainer accountContainer, final BindingResult bindingResult) {
        accountContainer.getBankAccounts().add(new BankAccount());
        return "bankofsimba2";
    }

    @PostMapping(value="/multipleAccounts", params={"accountSubmit"})
    public String submitAccount(
            final AccountContainer accountContainer, final BindingResult bindingResult,
            final HttpServletRequest req) {
        final Integer accountIndex = Integer.valueOf(req.getParameter("accountSubmit"));

        BankAccount account = accountContainer.getBankAccounts().get(accountIndex);
        double t = account.getBalance();

        if (account.getKing().equals("King")) {
            t += 100;
        } else {
            t += 10;
        }
        account.setBalance(t);

        return "bankofsimba2";
    }

    /*
    @PostMapping(value = "/multipleAccounts")
    public String accountSubmit(Model model, final HttpServletRequest req) {
        String accountSubmitParam = req.getParameter("accountSubmit");
        String addAccountParam = req.getParameter("addAccount");

        if(accountSubmitParam != null) {
            final Integer accountIndex = Integer.valueOf(accountSubmitParam);

            BankAccount account = accountContainer.getBankAccounts().get(accountIndex);
            double t = account.getBalance();
            if (account.getKing().equals("King")) {
                t += 100;
            } else {
                t += 10;
            }
            account.setBalance(t);
        } else if (addAccountParam != null) {
            accountContainer.getBankAccounts().add(new BankAccount());
        }

        model.addAttribute("accContainer", accountContainer);
        return "bankofsimba2";
    }
     */
}
