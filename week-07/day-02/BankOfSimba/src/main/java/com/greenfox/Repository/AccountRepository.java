package com.greenfox.Repository;

import com.greenfox.Model.BankAccount;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepository {

    private final List<BankAccount> bankAccounts = new ArrayList<>();

    public AccountRepository() {
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

    public void raiseBalance(int index) {
        if(bankAccounts.get(index).getKing().equals("King")) {
            bankAccounts.get(index).setBalance(bankAccounts.get(index).getBalance() + 100);
        } else {
            bankAccounts.get(index).setBalance(bankAccounts.get(index).getBalance() + 10);
        }
    }

}