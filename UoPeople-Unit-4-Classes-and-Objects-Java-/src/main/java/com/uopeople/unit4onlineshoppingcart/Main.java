package com.uopeople.unit4onlineshoppingcart;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Create three Product objects with initial inventory
        Product laptop = new Product("Laptop", 750.00, 5);
        Product headphones = new Product("Headphones", 80.00, 10);
        Product mouse = new Product("Wireless Mouse", 25.00, 8);

        // Store products in the cart
        ArrayList<Product> products = new ArrayList<>();

        // Store quantities currently in the cart
        ArrayList<Integer> cartQuantities = new ArrayList<>();

        products.add(laptop);
        products.add(headphones);
        products.add(mouse);

        cartQuantities.add(0);
        cartQuantities.add(0);
        cartQuantities.add(0);

        System.out.println("==========================================");
        System.out.println("       ONLINE SHOPPING CART SYSTEM");
        System.out.println("==========================================");
        System.out.println();

        // Display initial inventory
        System.out.println("INITIAL INVENTORY");
        System.out.println("------------------------------------------");
        System.out.printf(
                "%-20s %-12s %-12s%n",
                "Product", "Price", "Stock"
        );
        System.out.println("------------------------------------------");

        laptop.displayProductInfo();
        headphones.displayProductInfo();
        mouse.displayProductInfo();

        System.out.println();

        // Add one laptop
        int amount = 1;

        if (laptop.addToCart(amount)) {
            cartQuantities.set(0, cartQuantities.get(0) + amount);

            System.out.println(
                    amount + " Laptop added to the cart."
            );
        } else {
            System.out.println(
                    "Unable to add Laptop. Not enough stock."
            );
        }

        // Add two headphones
        amount = 2;

        if (headphones.addToCart(amount)) {
            cartQuantities.set(1, cartQuantities.get(1) + amount);

            System.out.println(
                    amount + " Headphones added to the cart."
            );
        } else {
            System.out.println(
                    "Unable to add Headphones. Not enough stock."
            );
        }

        // Add three wireless mice
        amount = 3;

        if (mouse.addToCart(amount)) {
            cartQuantities.set(2, cartQuantities.get(2) + amount);

            System.out.println(
                    amount + " Wireless Mouse(s) added to the cart."
            );
        } else {
            System.out.println(
                    "Unable to add Wireless Mouse. Not enough stock."
            );
        }

        System.out.println();

        // Remove one headphone from the cart
        amount = 1;

        if (cartQuantities.get(1) >= amount) {

            if (headphones.removeFromCart(amount)) {
                cartQuantities.set(
                        1,
                        cartQuantities.get(1) - amount
                );

                System.out.println(
                        amount + " Headphone removed from the cart."
                );
            }

        } else {
            System.out.println(
                    "Unable to remove Headphone. "
                            + "The cart does not contain enough units."
            );
        }

        System.out.println();

        // Display final cart summary
        System.out.println("==========================================");
        System.out.println("          FINAL CART SUMMARY");
        System.out.println("==========================================");

        System.out.printf(
                "%-20s %-12s %-12s %-12s%n",
                "Product",
                "Price",
                "Cart Qty",
                "Subtotal"
        );

        System.out.println(
                "------------------------------------------------------"
        );

        double grandTotal = 0.00;

        for (int i = 0; i < products.size(); i++) {

            Product product = products.get(i);
            int cartQuantity = cartQuantities.get(i);

            double subtotal =
                    product.getPrice() * cartQuantity;

            grandTotal += subtotal;

            System.out.printf(
                    "%-20s %-12.2f %-12d %-12.2f%n",
                    product.getProductName(),
                    product.getPrice(),
                    cartQuantity,
                    subtotal
            );
        }

        System.out.println(
                "------------------------------------------------------"
        );

        System.out.printf(
                "Grand Total: %.2f%n",
                grandTotal
        );

        System.out.println();

        // Display remaining inventory
        System.out.println("REMAINING INVENTORY");
        System.out.println("------------------------------------------");
        System.out.printf(
                "%-20s %-12s%n",
                "Product",
                "Available Stock"
        );
        System.out.println("------------------------------------------");

        System.out.printf(
                "%-20s %-12d%n",
                laptop.getProductName(),
                laptop.getQuantity()
        );

        System.out.printf(
                "%-20s %-12d%n",
                headphones.getProductName(),
                headphones.getQuantity()
        );

        System.out.printf(
                "%-20s %-12d%n",
                mouse.getProductName(),
                mouse.getQuantity()
        );

        System.out.println("------------------------------------------");
    }
}