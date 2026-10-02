package com.uopeople.assignment_unit_2;

import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            double[] marks = new double[5];

            // Read and validate the five marks
            for (int i = 0; i < marks.length; i++) {

                System.out.print("Enter mark for subject " + (i + 1) + ": ");
                marks[i] = input.nextDouble();

                if (marks[i] < 0 || marks[i] > 100) {
                    System.out.println(
                            "Invalid input - Marks must be between 0 and 100 (inclusive)"
                    );
                    return;
                }
            }

            // Calculate total and average
            double total = 0;

            for (double mark : marks) {
                total += mark;
            }

            double average = total / marks.length;

            // Determine grade and performance
            char grade;
            String performance;

            if (average >= 90) {
                grade = 'A';
                performance = "Excellent";
            } else if (average >= 80) {
                grade = 'B';
                performance = "Very good";
            } else if (average >= 70) {
                grade = 'C';
                performance = "Satisfactory";
            } else {
                grade = 'F';
                performance = "Unsatisfactory";
            }

            // Display the results
            System.out.println();
            System.out.println("..... Student Performance .....");
            System.out.println("Total Marks: " + total);
            System.out.printf("Average Marks: %.2f%n", average);
            System.out.println("Grade: " + grade);
            System.out.println("Performance: " + performance);
            System.out.println("-------------------------------");
        }
    }
}