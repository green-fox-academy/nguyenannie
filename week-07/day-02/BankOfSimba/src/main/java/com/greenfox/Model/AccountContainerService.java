package com.greenfox.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountContainerService {

    @Autowired
    private AccountContainerRepository accountContainerRepository;


    public AccountContainerService() {
        super();
    }

    public List<AccountContainer> findAll() {
        return this.accountContainerRepository.findAll();
    }

    public void add(final AccountContainer accountContainer) {
        this.accountContainerRepository.add(accountContainer);
    }

}
