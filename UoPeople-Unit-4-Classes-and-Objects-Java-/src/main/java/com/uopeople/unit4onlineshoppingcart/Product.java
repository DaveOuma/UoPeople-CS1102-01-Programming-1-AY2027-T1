package com.uopeople.unit4onlineshoppingcart;

public class Product {
    private String productName;
    private double price;
    private int quantity;

    //Constructor initializing all three instance variables.
    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    //Add product to cart by reducing available inventory
    public boolean addToCart(int amount) {
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
            return true;
        }
        return false;
    }
    //Remove product from cart by returning it to inventory
    public boolean removeFromCart(int amount) {
        if (amount > 0) {
            quantity += amount;
            return true;
        }
        return false;
    }

    //Display product information
    public void displayProductInfo() {
        System.out.printf(
                "%-20s %-12.2f %-12d%n",
                productName,
                price,
                quantity
        );
    }

    //Getter for product name
    public String getProductName() {
        return productName;
    }

    //Getter for price
    public double getPrice() {
        return price;
    }

    //Getter for available inventory
    public int getQuantity() {
        return quantity;
    }
}
