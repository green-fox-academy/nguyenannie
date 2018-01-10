package com.greenfox.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountContainerService {

    @Autowired
    private AccountContainerRepository accountContainerRepository;


    public AccountContainerService() {
        super();
    }

    public List<BankAccount> findAll() {
        return this.accountContainerRepository.findAll();
    }

    public void add(final BankAccount bankAccount) {
        this.accountContainerRepository.add(bankAccount);
    }

}
