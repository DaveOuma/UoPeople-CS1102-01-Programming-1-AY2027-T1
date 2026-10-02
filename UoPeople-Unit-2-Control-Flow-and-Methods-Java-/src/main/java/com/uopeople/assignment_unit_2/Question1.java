package com.uopeople.assignment_unit_2;

import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)){

            double[] marks = new double[5];

            // Read and validate the five marks
            for (int i = 0; i < marks.length; i++) {

                System.out.print("Enter mark for subject " + (i + 1) + ": ");
                marks[i] = input.nextDouble();

                if (marks[i] < 0 || marks[i] > 100) {
                    System.out.println("Invalid input - Marks must be between 0 and 100 (inclusive)");
                    return;
                }
            }

            // Calculate the total
            double total = 0;

            for (int i=0; i < marks.length; i++) {
                total += marks[i];
            }

            // Calculate the average
            double average = total / marks.length;

            // Display the results
            System.out.println();
            System.out.println("..... Student Marks .....");
            System.out.println("Total Marks: " + total);
            System.out.printf("Average Marks: %.2f%n", average);
            System.out.println("------------------------");

        }


    }
}
