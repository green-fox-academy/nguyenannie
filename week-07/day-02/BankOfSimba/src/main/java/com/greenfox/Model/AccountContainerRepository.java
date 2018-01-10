package com.greenfox.Model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountContainerRepository {

    private final List<BankAccount> bankAccounts = new ArrayList<>();

    public AccountContainerRepository() {
        super();
        bankAccounts.add(new BankAccount("Mufasa", 2500, "lion", "King", "Good One"));
        bankAccounts.add(new BankAccount("Pumbaa", 1700, "pig", "not King", "Good One"));
        bankAccounts.add(new BankAccount("Rafiki", 1000, "monkey", "not King", "Bad Guy"));
        bankAccounts.add(new BankAccount("Zazu", 2300, "bird", "not King", "Good One"));
        bankAccounts.add(new BankAccount("Nala", 2700, "lion", "not King", "Bad Guy"));
    }

    public List<BankAccount> findAll() {
        return this.bankAccounts;
    }

    public void add(final BankAccount bankAccount) {
        this.bankAccounts.add(bankAccount);
    }

}