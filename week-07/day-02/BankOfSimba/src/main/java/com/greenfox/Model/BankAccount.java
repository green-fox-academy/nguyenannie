package com.greenfox.Model;

public class BankAccount {
    private String name;
    private String balance;
    private String animalType;

    public BankAccount(String name, String balance, String animalType) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
    }

    public BankAccount(String name, double balance, String animalType) {
        this.name = name;
        this.balance = String.format("%.2f", balance);
        this.animalType = animalType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBalance() {
        return balance;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
