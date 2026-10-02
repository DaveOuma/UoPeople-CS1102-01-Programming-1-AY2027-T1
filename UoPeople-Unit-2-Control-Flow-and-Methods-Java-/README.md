Unit 2 Reading Assignment

As you read through the learning resource consider the following:

    How do conditional statements and looping structures affect the control flow of a Java program?
    Why are static methods, parameters, and method overloading important for creating modular and reusable code?
    How does understanding variable scope help in managing data effectively in Java applications

Read 

    Burd, B. (2022). Java for dummies (8th ed.). John Wiley & Sons. ProQuest Ebook Central. (Access through LIRN)  

    Read the following chapters:  

        Chapter 5: Controlling Program Flow with Decision-Making Statements introduces how Java makes choices through conditional statements such as if, if-else, and switch. You’ll learn how these constructs allow programs to respond dynamically to user input or changing conditions. Burd uses practical examples, such as comparing numerical values and validating user entries, to show how branching logic can control what code executes. The chapter also explains nested conditions and the importance of writing clean, readable decision logic. 

        Chapter 6: Controlling Program Flow with Loops focuses on repetition and iteration in Java using looping constructs i.e. for, while, and do-while. Burd clearly differentiates between entry-controlled and exit-controlled loops and demonstrates when to use each type. You’ll also explore loop control statements like break and continue to manage how loops behave. Through examples such as summing a list of numbers or iterating through arrays, you’ll understand how loops make programs efficient and flexible. 

    Eck, D. J. (2022). Introduction to programming using Java (Version 9, JavaFX Edition). Hobart and William Smith Colleges. https://math.hws.edu/javanotes/ Licensed under a Creative Commons Attribution–NonCommercial–ShareAlike 4.0 International License. 

    Read the following chapters:  
        Chapter 3 Under Section 3.1: Blocks, Loops, and Branches, Eck explains Java’s decision-making logic, covering simple if statements, if-else chains, nested conditions, and the switch structure. He emphasizes how control flow is determined by Boolean expressions and compares the readability and efficiency of different conditional approaches. The examples show practical applications such as grade calculation and menu-driven programs. Section 3.3: The while and do..while Statements, provides a deep understanding of iteration and repetition in Java. Students will learn how while, do-while, and for loops operate, including initialization, condition checking, and updating expressions. Eck discusses infinite loops, nested loops, and using loops for data processing tasks such as summing sequences or validating input. The examples demonstrate how loops simplify repetitive programming tasks. Additionally, Section 3.4: The for statement, Eck explains how loops allow programs to repeat instructions until a condition is met, reducing redundancy and improving efficiency. The section highlights common pitfalls such as infinite loops and shows how to use control statements like break and continue to manage loop behavior effectively. Section 3.6: The switch Statement discusses the second branching statement in Java which is the switch statement. The switch statement is used much less often than the if statement, but it is sometimes useful for expressing a certain type of multiway branch. 
        Chapter 4 Under Section 4.2: Static Subroutines and Static Variables, Eck explains how to structure reusable blocks of code using methods. Students will explore defining static methods, passing arguments, and returning values to the calling function. This section shows how methods can reduce redundancy, improve program organization, and support top-down program design. Eck also includes guidance on writing methods that perform computations and return results, enhancing modular design. Additionally, Section 4.3: Parameters, introduces method overloading, allowing multiple methods with the same name but different parameters to coexist in a program. Eck uses clear examples to show how overloading improves readability and usability. Eck has explained variable scope, showing how local, instance, and class variables differ in visibility and lifetime. Understanding scope helps prevent logical errors and ensures cleaner, safer code. 

Additional Readings 

    Ochem, Q. (2025, September 30). Statements, declarations, and control structures. In Ada for the C++ and Java developer (Release 2025-09). AdaCore. https://learn.adacore.com/courses/Ada_For_The_CPP_Java_Developer/chapters/04_Statements_Declarations_and_Control_Structures.html Licensed under Creative Commons Attribution–ShareAlike 4.0 International License International   

Watch

    Coding with John. (2020, November 4). Java main method explained - what does all that stuff mean? [Video]. YouTube. 
        This video demystifies the structure of the Java main method (public static void main(String[] args)), which serves as the entry point for every Java program. Each keyword has a specific role to allow the Java Runtime Environment (JRE) to execute the program: public ensures the method is callable from outside the class; static allows the method to be called directly on the class without needing an object instance; void indicates the method does not return a value when finished; main is the exact, mandatory name the JRE looks for; and String[] args is an array of strings used to pass command-line arguments to the program upon startup. The video demonstrates how to pass and utilize these arguments to influence the program's initial behavior. 

    Watch on YouTube
    Bro Code. (2020, October 19). Java overloaded methods [Video]. YouTube. 
            This video explains overloaded methods in Java, which are methods that share the same name (e.g., add) but must have different parameters to maintain a unique method signature. The method signature, consisting of the method's name plus its parameters, is what the Java compiler uses to distinguish between multiple methods with identical names. A method can be overloaded by varying the number of parameters (e.g., one version accepting two integers, another accepting three) or by changing the data type of the parameters (e.g., one version accepting integers and another accepting doubles), ensuring that each version has a distinct signature for the compiler to select the correct one at runtime. 

    Watch on YouTube

    Instructions

This assignment will assess your knowledge and skills about:  

    Applying conditional and looping constructs to solve problems.
    Implementing static methods and overloading method for modular code.
    Implementing scope rules and control flow structures in Java programs.

Assignment

Scenario: A university wants a Java application that records marks for five subjects and determines each student’s total, average, and grade using this scale: 

Marks Range 

	

Grade 

	

Description 

90 – 100 (Inclusive) 

	

A 

	

Excellent performance 

80 – 89 (Inclusive) 

	

B 

	

Very good performance 

70 – 79 (Inclusive) 

	

C 

	

Satisfactory performance 

Below 70 

	

F 

	

Unsatisfactory performance 

Q1. Write a Java program that applies conditional statements and looping constructs to process user input, validate it, and display the results correctly. Your program should: 

(a) Use suitable conditional and looping constructs to read marks for 

 (mark_subject_1, mark_subject_2, mark_subject_3, mark_subject_4, and mark_subject_5) from the user. 

(b) Implement input validation, total and average calculation, and output display as follows: 

        First validate that each entered mark is between 0 and 100 (inclusive). 
        If any entered mark falls outside this range, display the message: 

"Invalid input - Marks must be between 0 and 100 (inclusive)" and terminate the program immediately. 

        Once all inputs are validated, the program should then use appropriate loop structure to calculate and display the total and average marks with clear and meaningful output messages. 

Q2.  Enhance the Java program developed in Question 1 by applying the principles of modular design and code reusability. To achieve this, 

(a) Implement a static method named calculateGrade(double average) that returns the student’s grade (A, B, C, or F) based on the specified grading scale.  

(b) Further, demonstrate method overloading by creating another version of the calculateGrade method that accepts the total marks and the number of subjects as parameters, calculates the average internally, and then returns the corresponding grade. 

Q3.  Improve the Java program you created in Question 2 by adding conditions to check and display the student’s performance in a clear and easy-to-read way. The program should calculate the total and average marks of a student, and then decide the grade based on the average using if–else or switch statements, as shown below: 

    90–100 → Grade A 
    80–89 → Grade B 
    70–79 → Grade C 
    Below 70 → Grade F

Make sure to declare variables like total, average, and grade in the right places so they can be used only where needed. Finally, show the total marks, average, and grade together in one neat and easy-to-understand output message. 
