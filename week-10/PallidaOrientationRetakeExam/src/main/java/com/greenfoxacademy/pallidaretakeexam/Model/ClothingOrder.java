package com.greenfoxacademy.pallidaretakeexam.Model;

public class ClothingOrder {
    private String itemName;
    private String manufacturer;
    private String category;
    private String size;
    private float unitPrice;
    private int quantity;

    public ClothingOrder(String itemName, String size, int quantity, float unitPrice) {
        this.itemName = itemName;
        this.size = size;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public ClothingOrder() {

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubTotal() {
        return this.quantity * this.unitPrice;
    }
}
