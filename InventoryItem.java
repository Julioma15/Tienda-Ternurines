/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.administration;

/**
 *
 * @author Usuario
 */
public class InventoryItem {
    private int itemId;
    private String itemName;
    private String category;
    private int stock;
    private double price;
    private String description;
    private String supplier;

    // Constructor, getters y setters
    public InventoryItem(int itemId, String itemName, String category, int stock, double price, String description, String supplier) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.stock = stock;
        this.price = price;
        this.description = description;
        this.supplier = supplier;
    }

    // Getters y setters
    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
}
