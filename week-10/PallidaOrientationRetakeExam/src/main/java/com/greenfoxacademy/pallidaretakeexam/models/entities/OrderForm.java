package com.greenfoxacademy.pallidaretakeexam.models.entities;

public class OrderForm {

    private String itemName;
    private String size;
    private int quantity;

    public OrderForm() {

    }

    public OrderForm(String itemName, String size, int quantity) {
        this.itemName = itemName;
        this.size = size;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
