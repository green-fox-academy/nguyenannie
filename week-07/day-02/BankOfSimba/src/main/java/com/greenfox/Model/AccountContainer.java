package com.greenfox.Model;

import java.util.List;

public class AccountContainer {
    private List<BankAccount> bankAccounts;
    private BankAccount bankAccount;

    public AccountContainer() {

    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
