package com.greenfox.Service;

import com.greenfox.Repository.AccountRepository;
import com.greenfox.Model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        super();
        this.accountRepository = accountRepository;
    }

    public List<BankAccount> findAll() {
        return this.accountRepository.findAll();
    }

    public void add(final BankAccount bankAccount) {
        this.accountRepository.add(bankAccount);
    }

    public void raiseBalance(int index) {
        accountRepository.raiseBalance(index);
    }

}
