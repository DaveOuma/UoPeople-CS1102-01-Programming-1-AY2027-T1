Unit 1: Java Fundamentals

Reading Assignment

As you go through the readings and watch the video, consider the following: 

    Why is Java considered platform-independent, and how do the JVM, JDK, and JRE work together to support this?
    How do variables, typecasting, and input handling contribute to the accuracy and flexibility of a Java program? 
    What common setup or syntax errors occur in beginner programs, and how can understanding program execution flow help you debug them? 

Read

    Burd, B. (2022). Java for dummies (8th ed.). John Wiley & Sons. ProQuest Ebook Central. (Access through LIRN)  

    Read the following chapters:  

        Chapter 2: All About Software builds the previous chapter by explaining the software development lifecycle, including writing code, compiling, testing, and running programs. It introduces the Java Virtual Machine (JVM), Java Runtime Environment (JRE), and Java Development Kit (JDK), showing how Java code is compiled into bytecode and executed on any platform. The chapter also touches on the Java API and built-in libraries, which allow developers to leverage pre-written code for common tasks. This chapter clarifies Java’s architecture and explains the full process of program execution, from writing source code to running a functional application, which helps students describe how Java works internally. 

        Chapter 4: Making the Most of Variables and Their Values explains primitive data types, including int, double, char, and boolean, and how to declare, initialize, assign, and update variables. It introduces constants using the final keyword and explains typecasting, which allows the conversion of one data type to another. The chapter also differentiates between primitive and reference types, showing how memory is allocated and accessed for different types of data. This chapter directly teaches how to apply variables effectively, perform typecasting when necessary, and manage data in programs, all of which are essential skills for programming tasks such as calculations and input handling. 

        Chapter 5: Controlling Program Flow with Decision-Making Statements introduces keyboard input as a way to make programs interactive. In Listing 5-1, the program shows how to read an integer entered by the user using the Scanner class, where the number typed on the keyboard is stored in a variable called InputNumber. The process involves importing the Scanner class, creating a Scanner object named keyboard, and using the nextInt() method to read the user’s input. Although these lines may seem complicated at first, they can be reused almost exactly whenever keyboard input is needed. The import and Scanner creation lines are written only once in a program, while nextInt() is used each time an integer value is required. Among all the names used, only inputNumber and keyboard are user-defined, while the rest are part of Java’s standard library. 

    Eck, D. J. (2022). Introduction to programming using Java (Version 9, JavaFX Edition). Hobart and William Smith Colleges. https://math.hws.edu/javanotes/ Licensed under a Creative Commons Attribution–NonCommercial–ShareAlike 4.0 International License. 

        Read the following chapters:  

            Chapter 1: The Mental Landscape introduces the foundational concepts of programming, emphasizing that programming allows us to solve problems, automate tasks, and communicate instructions to computers. it explains the evolution of programming languages and highlights java as a high-level, object-oriented language that can run on multiple platforms through the java virtual machine (jvm). Section 1.1   explains how computers execute instructions and why high-level programming languages like Java are necessary Section 1.3 introduces the role of the JVM and how it makes Java portable across different systems. Section 1.4 discusses the structure of Java programs, including statements, loops, and subroutines. This chapter explains the purpose of programming and java’s architecture, as it gives students an understanding of why java is used and how its architecture enables portability and reliability.  

            Chapter 2: Names and Things focus on the basics of java programming. it covers the structure of a simple java program, including the main method, and introduces variables, data types, and expressions, explaining how data is stored and manipulated. Naming conventions and the use of comments for code clarity are also discussed. Section 2.2 explains the use of variables and data types in Java; section 2.6.6 provides a simple way to experiment with Java syntax interactively, and section 2.4.6 introduces reading input from the console, an essential part of interactive programming. This chapter explains applying variables, typecasting, and input handling, as students learn to declare and initialize variables, work with data types, and handle user input effectively. 

Additional Readings

    Burd, B. (2022). Java for dummies (8th ed.). John Wiley & Sons. ProQuest Ebook Central. (Access through LIRN)  

        Read the following chapters: 

            Chapter 1: All About Java introduces Java as a high-level, object-oriented programming language and provides the student with an understanding of why Java is widely used. The chapter highlights key features such as platform independence, security, and simplicity, explaining why Java programs can run across multiple platforms without modification. It describes the fundamental building blocks of Java, including classes, objects, and methods, and introduces variables as storage units for data. The chapter also explains Java features such as automatic memory management (garbage collection) and cross-platform compatibility, emphasizing how Java’s design supports reliable, reusable code. This chapter focuses on explaining the purpose of programming and Java’s architecture, because it provides the conceptual foundation for understanding the rationale behind using Java, its core components, and its execution model. 

            Chapter 3: Using the Basic Building Blocks focuses on the structure of a Java program. It explains the elements of a Java class, the purpose of the main() method, and the proper use of statements. Syntax rules, including the importance of semicolons, braces, indentation, and comments, are discussed in detail. The chapter demonstrates how to output data using System.out.println() and highlights common syntax mistakes that beginners make, explaining how to identify and correct them. This chapter provides the foundational skills for writing functional Java programs, including using variables and statements correctly. It also focuses on syntax and structure as being critical for identifying errors and ensuring proper execution of code. 

Watch

    Telusko. (2023, January 16). #3 first code in Java [Video]. YouTube. 

        In this video, students will learn how to use VSCode for Java programming, including starting the IDE, creating a project, and writing their first Java code. VSCode offers features such as Explorer, Search, Run and Debug, and the ability to add extensions like the Extension Pack for Java. A project is created by making a folder to store all related files and libraries. Students will create their first Java file, such as Hello.java, and learn how to print output using System.out.print(). The lecture also introduces JShell, a tool introduced in Java 9, which allows running small snippets of code for experimentation and learning, though it’s not suitable for full projects. Finally, students will cover the two-step process to compile and run Java programs using the terminal: first compile the code with javac filename and then run it with java classname. Commands like java --version and javac --version help verify the installed versions of Java and the Java compiler. 

Watch on YouTube




Description (Work to do)

This assignment will assess your knowledge and skills about:

    Explaining the purpose of programming and Java’s architecture. 
    Applying variables, typecasting, and input handling in Java programs 
    Identifying setup or syntax errors and describing the execution flow of Java programs. 

Assignment

Based on the readings of this unit and your own understanding, answer the following discussion questions:

Scenario:

A startup is preparing to launch a mobile app for expense tracking. The application will be built in Java to ensure it can run on multiple platforms such as Windows, Mac, and Linux. As part of the onboarding process, a junior developer is asked to explain Java’s fundamentals and contribute to writing the first console-based version of the app.

Questions:

    Explain the roles of the Java Virtual Machine (JVM), Java Development Kit (JDK), and Java Runtime Environment (JRE), and describe how these components work together to achieve platform independence for the startup application.  
    Imagine you’re part of the development team designing the first version of the expense tracker. 
        How would you apply suitable data types in Java to represent details such as the expense amount, category, and   number of items?
        How would you handle user input to prevent invalid entries (like text instead of numbers), and in what real life situations might typecasting (implicit or explicit) be needed to ensure accurate and error-free expense calculations in the app?  

    Identify common syntax and runtime errors that could occur in a basic Java program (for example, a missing semicolon or integer division). Explain the causes of these errors and describe how the corrected program executes step by step, from compilation to output.  
