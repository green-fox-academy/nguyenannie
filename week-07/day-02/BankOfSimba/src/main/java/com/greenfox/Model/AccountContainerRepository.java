package com.greenfox.Model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountContainerRepository {

    private final List<AccountContainer> accountContainers = new ArrayList<>();



    public AccountContainerRepository() {
        super();
    }



    public List<AccountContainer> findAll() {
        return new ArrayList<AccountContainer>(this.accountContainers);
    }


    public void add(final AccountContainer accountContainer) {
        this.accountContainers.add(accountContainer);
    }



}