package com.greenfox.Web.Controllers;

import com.greenfox.Service.AccountContainerService;
import com.greenfox.Model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MultipleAccountController {

    @Autowired
    private AccountContainerService accountContainerService;

    MultipleAccountController() {
        super();
    }

    @ModelAttribute("allBankAccounts")
    public List<BankAccount> populateBankAccounts() {
        return this.accountContainerService.findAll();
    }

    @RequestMapping({"/multipleAccounts"})
    public String displayAccInfo(final BankAccount bankAccount) {
        return "bankofsimba2";
    }

    @RequestMapping(value = "/multipleAccounts", params = {"add"})
    public String addAccount(final BankAccount bankAccount, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "bankofsimba2";
        }
        this.accountContainerService.add(bankAccount);
        return "bankofsimba2";
    }

    @RequestMapping(value = "/multipleAccounts", params = {"raise"})
    public String submitAccount(final BankAccount bankAccount, final BindingResult bindingResult,
            final HttpServletRequest req) {
        final Integer accountIndex = Integer.valueOf(req.getParameter("raise"));

        BankAccount account = accountContainerService.findAll().get(accountIndex);
        double t = account.getBalance();

        if (account.getKing().equals("King")) {
            t += 100;
        } else {
            t += 10;
        }
        account.setBalance(t);

        return "bankofsimba2";
    }

}

