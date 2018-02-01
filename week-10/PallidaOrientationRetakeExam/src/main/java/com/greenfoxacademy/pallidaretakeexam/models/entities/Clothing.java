package com.greenfoxacademy.pallidaretakeexam.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "warehouse")
public class Clothing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "item_name")
    private String itemName;
    private String manufacturer;
    private String category;
    private String size;
    @Column(name = "unit_price")
    private float unitPrice;
    @Column(name = "in_store")
    @JsonIgnore
    private Integer inStore;

    public Clothing(String itemName, String size) {
        this.itemName = itemName;
        this.size = size;
    }

    public Clothing(long id, String itemName, String manufacturer, String category, String size, float unitPrice) {
        this.id = id;
        this.itemName = itemName;
        this.manufacturer = manufacturer;
        this.category = category;
        this.size = size;
        this.unitPrice = unitPrice;
    }

    public Clothing() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Integer getInStore() {
        return inStore;
    }

    public void setInStore(Integer inStore) {
        this.inStore = inStore;
    }

}
