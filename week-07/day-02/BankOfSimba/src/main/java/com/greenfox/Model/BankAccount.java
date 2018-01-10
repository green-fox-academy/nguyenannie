package com.greenfox.Model;

import java.util.List;

public class BankAccount {

    private String name;
    private double balance;
    private String animalType;
    private String king;
    private String guyType;
    private List<BankAccount> accountList;

    public BankAccount() {

    }

    public BankAccount(String name, double balance, String animalType,String king, String guyType) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        this.guyType = guyType;
        this.king = king;
    }

    public List<BankAccount> getAccountList() {
        return accountList;
    }

    public String getGuyType() {
        return this.guyType;
    }

    public String getKing() {
        return king;
    }

    public String getName() {
        return name;
    }

    public void setGuyType(String guyType) {
        this.guyType = guyType;
    }

    public double getBalance() {
        return balance;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAccountList(List<BankAccount> accountList) {
        this.accountList = accountList;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setKing(String king) {
        this.king = king;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

}
