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

    public BankAccount(String name, double balance, String animalType, String king) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        this.king = king;
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

    public void setAccountList(List<BankAccount> accountList) {
        this.accountList = accountList;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getGuyType() {
        return this.guyType;
    }

    public void setGuyType(String guyType) {
        this.guyType = guyType;
    }

    public String getKing() {
        return king;
    }

    public void setKing(String king) {
        this.king = king;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
}
