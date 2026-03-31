package model;

    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *//**
 *
 * @author root
 */
public class CartItem {
    private int productId;
    private String productName;
    private double price;
    private int quantity;
    private double discount;

    public CartItem(int productId, String productName, double price, int quantity, double discount) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public double getDiscount() { return discount; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return (price * quantity) - discount;
    }
}