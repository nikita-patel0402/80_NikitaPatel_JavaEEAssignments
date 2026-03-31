package com.mycompany.assignment2.model;

public class Product {

    private int productId;
    private String productName;
    private double price;
    private String unit;
    private double discount;
    private String image;
    private int categoryId;
    private int stock;

    // ================= GETTERS =================

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    public double getDiscount() {
        return discount;
    }

    public String getImage() {
        return image;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getStock() {
        return stock;
    }

    // ================= SETTERS =================

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}