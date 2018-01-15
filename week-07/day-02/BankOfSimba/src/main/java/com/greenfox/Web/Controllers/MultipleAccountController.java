package com.greenfox.Web.Controllers;

import com.greenfox.Service.AccountService;
import com.greenfox.Model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MultipleAccountController {

    private final AccountService accountService;

    @Autowired
    MultipleAccountController(AccountService accountContainerService) {
        super();
        this.accountService = accountContainerService;
    }

    @ModelAttribute("allBankAccounts")
    public List<BankAccount> populateBankAccounts() {
        return this.accountService.findAll();
    }

    @RequestMapping({"/multipleAccounts"})
    public String displayAccInfo(final BankAccount bankAccount) {
        return "bankofsimba2";
    }

    @RequestMapping(value = "/multipleAccounts", params = {"add"})
    public String addAccount(final BankAccount bankAccount, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().get(0).getDefaultMessage();
            return "error";
        }
        this.accountService.add(bankAccount);
        return "bankofsimba2";
    }

    @RequestMapping(value = "/multipleAccounts", params = {"raise"})
    public String submitAccount(final BankAccount bankAccount, final BindingResult bindingResult,
            final HttpServletRequest req) {
        final Integer accountIndex = Integer.valueOf(req.getParameter("raise"));
        accountService.raiseBalance(accountIndex);
        return "bankofsimba2";
    }

}

