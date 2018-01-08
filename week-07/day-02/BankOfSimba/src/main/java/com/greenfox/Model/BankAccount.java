package com.greenfox.Model;

public class BankAccount {
    private String name;
    private double balance;
    private String balanceDisplay;
    private String animalType;
    private String king;
    private String guyType;

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
        this.balanceDisplay = String.format("%.2f", balance);
        this.animalType = animalType;
        this.guyType = guyType;
        this.king = king;
    }

    public String getBalanceDisplay() {
        return balanceDisplay;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBalanceDisplay(String balanceDisplay) {
        this.balanceDisplay = balanceDisplay;
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
