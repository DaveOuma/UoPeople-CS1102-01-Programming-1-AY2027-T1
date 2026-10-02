package com.uopeople.unit3menutrucker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuTracker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Get number of items
        int num = 0;

        while (true) {
            try {
                System.out.print("Enter number of canteen items: ");
                num = input.nextInt();

                if (num <= 0) {
                    System.out.println("Number of items must be greater than 0.");
                    continue;
                }

                break;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.nextLine();
            }
        }

        //Create Day 1 array
        int[] day1Prices = new int[num];

        //Enter prices
        for (int i = 0; i < num; i++) {

            while (true) {

                try {

                    System.out.print(
                            "Enter price for item " + i + ": "
                    );

                    day1Prices[i] = input.nextInt();

                    break;

                }catch (InputMismatchException e) {

                    System.out.println(
                            "Invalid input. Please enter an integer."
                    );

                    input.nextLine();

                }finally {

                    System.out.println(
                            "Input attempt finished."
                    );
                }
            }

        }

        // Print Day 1 prices
        System.out.println("\nDay 1 Price List: ");

        for (int price : day1Prices) {
            System.out.print(price + " ");
        }

        System.out.println();

        //Calculate minimum, maximum, and average
        int minimum = day1Prices[0];
        int maximum = day1Prices[0];
        int total = 0;

        for (int price : day1Prices) {

            if (price < minimum) {
                minimum = price;
            }

            if (price > maximum) {
                maximum = price;
            }

            total += price;

        }

        double average = (double) total / day1Prices.length;

        System.out.println("\nDay 1 Statistics:");
        System.out.println("Minimum price: " + minimum);
        System.out.println("Maximum price: " + maximum);
        System.out.println("Average price: " + average);


        //Create a 2D array for three days
        int[][] pricesByDay = new int[3][num];

        //Copy Day 1 prices into the first row
        for (int i= 0; i < num; i++) {
            pricesByDay[0][i] = day1Prices[i];
        }

        //Update a price in the 2D array
        while (true) {

            try {
                System.out.print("\nEnter day number to update (1-3): ");
                int day = input.nextInt();

                if (day < 1 || day > 3) {
                    throw new ArrayIndexOutOfBoundsException(
                            "Invalid day. Please enter a day from 1 to 3."
                    );
                }

                System.out.print("Enter item number to update (1-" + num + "): ");
                int item = input.nextInt();

                if (item < 1 || item > num) {
                    throw new ArrayIndexOutOfBoundsException(
                            "Invalid item. Please enter an item from 1 to " + num + "."
                    );
                }
                System.out.print("Enter new price");
                int newPrice = input.nextInt();
                pricesByDay[day - 1][item - 1] = newPrice;

                System.out.println("Price updated successfully.");

                break;

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input. Please enter an integer."
                );

                input.nextLine();

            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println(e.getMessage());

            }
        }

        // Copy the updated Day 1 row into a separate array
        int[] DayOne = new int[num];

        for (int i = 0; i < num; i++) {
            DayOne[i] = pricesByDay[0][i];
        }

        System.out.println("\nDayOne Array:");

        for (int price : DayOne) {
            System.out.print(price + " ");
        }

        System.out.println();

        // Linear search
        System.out.print("\nEnter a price to search for: ");
        int searchPrice = input.nextInt();

        boolean found = false;

        System.out.println("Search results:");

        for (int i = 0; i < DayOne.length; i++) {

            if (DayOne[i] == searchPrice) {
                System.out.println("Price " + searchPrice + " found at index " + i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Price " + searchPrice + " not found.");
        }


        // Bubble Sort DayOne in ascending order
        int swapCount = 0;

        for (int i = 0; i < DayOne.length - 1; i++) {

            for (int j = 0; j < DayOne.length - 1 - i; j++) {

                if (DayOne[j] > DayOne[j + 1]) {

                    int temp = DayOne[j];
                    DayOne[j] = DayOne[j + 1];
                    DayOne[j + 1] = temp;

                    swapCount++;
                }
            }
        }

// Display sorted array
        System.out.println("\nDayOne after Bubble Sort:");

        for (int price : DayOne) {
            System.out.print(price + " ");
        }

        System.out.println();

        System.out.println("Total number of swaps: " + swapCount);


        //Display the current 3-day table
        System.out.println("\nPrices by Day:");

        for (int day = 0; day < pricesByDay.length; day++){

            System.out.print("Day " + (day + 1) + ": ");

            for (int item = 0; item < pricesByDay[day].length; item++){
                System.out.print(pricesByDay[day][item] + " ");
            }

            System.out.println();
        }

        input.close();
    }
}
