package com.uopeople.unit1javafundamentals;

import java.util.Scanner;

/**
 * Basic Console Prototype for Startup Expense Tracker.
 * Demonstrates variable selection, user input validation, typecasting,
 * and error-handling concepts.
 */
public class ExpenseTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("  Welcome to Startup Expense Tracker  ");
        System.out.println("======================================\n");

        // 1. Variable Declarations with appropriate data types
        String category = "";
        int numberOfItems = 0;
        double pricePerItem = 0.0;

        // 2. Input Handling with Type Validation (Preventing InputMismatchException)
        System.out.print("Enter expense category (e.g., Office, Travel, Supplies): ");
        category = scanner.nextLine();

        // Validating Integer Input for Number of Items
        while (true) {
            System.out.print("Enter number of items purchased: ");
            if (scanner.hasNextInt()) {
                numberOfItems = scanner.nextInt();
                if (numberOfItems > 0) {
                    break;
                } else {
                    System.out.println("Error: Number of items must be greater than 0.");
                }
            } else {
                System.out.println("Error: Invalid entry! Please enter a whole number.");
                scanner.next(); // Clear invalid token from buffer
            }
        }

        // Validating Floating-Point Input for Price Per Item
        while (true) {
            System.out.print("Enter price per item ($): ");
            if (scanner.hasNextDouble()) {
                pricePerItem = scanner.nextDouble();
                if (pricePerItem >= 0) {
                    break;
                } else {
                    System.out.println("Error: Price cannot be negative.");
                }
            } else {
                System.out.println("Error: Invalid entry! Please enter a numeric amount.");
                scanner.next(); // Clear invalid token from buffer
            }
        }

        // 3. Calculation and Typecasting
        // Implicit Typecasting: numberOfItems (int) automatically widened to double during multiplication
        double subtotal = numberOfItems * pricePerItem;

        // Applying a 10% tax rate
        double taxRate = 0.10;
        double rawTotal = subtotal + (subtotal * taxRate);

        // Explicit Typecasting: Floating-point precision conversion for display rounding/cents
        // Converting total to cents (int) to drop fractional precision, then back to double
        int totalCents = (int) (rawTotal * 100);
        double finalTotalFormatted = totalCents / 100.0; // Avoiding integer division using 100.0

        // 4. Summary Display
        System.out.println("\n--------------------------------------");
        System.out.println("           EXPENSE RECEIPT            ");
        System.out.println("--------------------------------------");
        System.out.println("Category:         " + category);
        System.out.println("Items Count:      " + numberOfItems);
        System.out.println("Unit Price:       $" + pricePerItem);
        System.out.println("Subtotal:         $" + subtotal);
        System.out.println("Raw Total (+10%): $" + rawTotal);
        System.out.println("Final Display:    $" + finalTotalFormatted);
        System.out.println("--------------------------------------");

        scanner.close();
    }
}
