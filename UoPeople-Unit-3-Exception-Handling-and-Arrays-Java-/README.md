
Unit 3 Reading Assignment

As you go through the readings and watch the video, consider the following:   

    How do conditional statements and looping structures affect the control flow of a Java program? 
    Why are static methods, parameters, and method overloading important for creating modular and reusable code? 
    How does understanding variable scope help in managing data effectively in Java applications


Read

    Burd, B. (2022). Java for dummies (8th ed.). John Wiley & Sons. ProQuest Ebook Central. (Access through LIRN)

    Read the following chapters:
        Chapter 11: Using Arrays to Juggle Values: This chapter introduces arrays in Java as a way to manage many values at once rather than many separate variables. It begins with simple arrays of primitives, explaining how to declare, instantiate, and use them. It then moves on to show how to traverse arrays using loops (classic for loops and the enhanced for loop), and how to perform operations such as searching through an array to find a value. Next, the chapter touches on arrays of objects (for example, storing instances of a Room class in an array) and discusses command-line arguments (the String[] args array). The intent is to give students both the mechanics of arrays and practical uses: reading data into arrays, processing arrays, and outputting results.
        Chapter 13: Looking Good When Things Take Unexpected Turn
        This chapter explains how to manage "things that go wrong" in a Java program using the exception-handling mechanism. It introduces the try block in which you place code that might throw an exception, and the catch block(s) to handle those exceptions. It describes how you can either handle an exception right there or "pass the buck" (declare that your method throws the exception). Overall, the chapter helps students learn how to write more robust Java code by anticipating error conditions, preventing program crashes, and ensuring proper cleanup of resources.

    Eck, D. J. (2022). Introduction to programming using Java (Version 9, JavaFX Edition). Hobart and William Smith Colleges. https://math.hws.edu/javanotes/. Licensed under a Creative Commons Attribution–NonCommercial–ShareAlike 4.0 International License.

    Read the following chapters:
        Chapter 3 and Chapter 8 Sections 3.7 (Introduction to Exceptions and try..catch) and 8.3 (Exceptions and try..catch): Students learn how Java handles unexpected events and program errors using the exception mechanism. They explore what exceptions are, why they occur, and how to use the try and catch blocks to prevent a program from crashing when errors arise. Section 3.7 introduces the foundational concept, explaining how to identify and handle runtime errors such as invalid input or illegal arguments using simple try–catch structures. Later, Section 8.3 expands this understanding by showing how exceptions contribute to writing robust and maintainable programs. Students learn the difference between checked and unchecked exceptions, how to throw and declare exceptions in their own methods, and how to use finally blocks for clean-up operations. By the end of these sections, students will be able to write programs that anticipate and gracefully handle errors, improving both the correctness and reliability of their code.
        Chapter 7: Arrays, ArrayLists, and Records: This chapter teaches students how to create, store, and manipulate collections of data using arrays. The section on array manipulation explains how to access, update, and process elements efficiently through loops, introducing common operations such as copying, searching, sorting, and reversing arrays. Within this chapter, Section 7.5: Searching and Sorting covers the fundamental algorithms of linear search and bubble sort. Linear search teaches how to find a target value by examining each element sequentially, while bubble sort demonstrates arranging array elements in ascending or descending order by repeatedly comparing and swapping adjacent values. These topics help students build a strong foundation in algorithmic logic, iteration, and efficiency, forming the basis for understanding more advanced data structures and sorting methods in Java programming.

Additional Readings

    Vatsavayi, V. K., & Varma, K. P. (n.d.). Java programming. Pressbooks. https://pressbooks.pub/javaprogramming/chapter/exception-and-error-handling-java-programming/ Licensed under a Creative Commons Attribution–NonCommercial–ShareAlike 4.0 International License.

        Read Chapter 9: Exception and Error Handling

        It explains how Java manages runtime anomalies through its structured exception-handling mechanism. It defines an exception as an abnormal event disrupting program execution and differentiates it from errors, which indicate serious system-level failures such as stack overflow or memory issues. The chapter details the Throwable class hierarchy, emphasizing subclasses like Exception and Error. It introduces the use of try, catch, throw, throws, and finally constructs, illustrating how Java detects, propagates, and handles exceptions effectively. Examples demonstrate handling built-in exceptions (ArithmeticException, NullPointerException, etc.) and creating user-defined ones. The importance of using the finally block for resource cleanup and maintaining program reliability is highlighted. Overall, Chapter 9 provides a comprehensive guide to writing robust, error-tolerant Java programs through systematic exception management.

Watch

    Coding with John. (2020, December 31). Exception handling in Java tutorial [Video]. YouTube.  

        The video explains the concept of exception handling in Java, focusing on how to write programs that can manage runtime errors gracefully. It introduces try, catch, finally, and throw keywords, demonstrating their use through simple code examples. The instructor explains the difference between checked and unchecked exceptions, shows how to handle multiple exception types, and emphasizes best practices for writing reliable Java programs. By the end, viewers understand how to prevent unexpected program termination and improve code robustness.

Watch on YouTube
2. Coding with John. (2021, Apr 3). Bubble sort algorithm tutorial in Java - how fast is it? [Video]. YouTube.  

        The video explains provides a clear explanation and demonstration of how the Bubble Sort algorithm works in Java. It shows how adjacent elements in an array are repeatedly compared and swapped until the entire list is sorted. The presenter explains the logic behind each loop and demonstrates how performance varies with different input sizes, also mentioning that an optimized version can detect when the array is already sorted to reduce unnecessary iterations. Overall, the video effectively introduces Bubble Sort’s concept, implementation, and limitations as a foundational learning tool for beginners in Java 

Watch on YouTube

Instructions

This assignment will assess your knowledge and skills about:  

    Implementing exception handling to ensure robust execution  
    Manipulating arrays to store and process data  
    Applying basic algorithms to search and sort data in arrays. 

Assignment 

Scenario: College Canteen Menu Tracker 

The canteen manager keeps a daily price list for popular items, but students often make input errors such as entering non-numeric values, duplicate items, or exceeding the required number of entries. To address these issues, you are required to develop a Menu Tracker program that should: 

    Implement exception handling to ensure robust execution when recording Day 1 prices — the first day of data collection, for canteen items. 
        Record the Day 1 price list for canteen items using an array by first asking the user for the number of items, n. Then, read n integer prices representing the Day 1 prices. 
        Use try–catch–finally blocks to handle invalid inputs such as non-integer inputs or out-of-range indices. If an error occurs, re-prompt the user only for the incorrect value without terminating the program. 
        The final block should print the message “Input attempt finished.” after each entry attempt. 

Once all Day 1 prices are successfully entered, print the complete list of Day 1 price list. 

Provide: 

        one screenshot showing a successful(errorfree) run   
        one screenshot showing a run where at least one invalid value is corrected and re-entered. 
    Manipulate arrays to store and process the price data efficiently. Continue using the Day 1 price list created in Q1.  
        Calculate and display the minimum, maximum, and average price of items for Day 1. 
        Create a two-dimensional array (2D) named pricesByDay with three rows (Day 1, Day 2, Day 3) and n columns (items).Copy the Day 1 prices into the first row of this 2D array. 
        Manipulate prices ByDay by entering or updating any cell in the table by specifying the day and item index, with bounds checking to prevent errors. 

After the update, print the complete table showing prices for all three days and the updated values. Copy the first row of the pricesByDay table into a separate 1D array named DayOne for focused analysis. Provide a screenshot showing the calculated statistics, the printed 2D table, and the successful update reflected in the output. 

    Apply basic searching and sorting algorithms to analyze the one- dimensional array (1D) named DayOne array from Q2.  

        Apply the linear search algorithm to find a specific price entered by the user. Display all indices where that price occurs, or display “not found” if it is absent. 
        Apply the bubble sort algorithm to the same DayOne array to arrange prices in ascending order. 

After sorting, print the sorted list and display the total number of swaps performed during the sort. Provide a screenshot showing both the search result and the sorted array with the swap count displayed.  
