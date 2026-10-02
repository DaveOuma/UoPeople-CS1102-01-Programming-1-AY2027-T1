Unit 4 Reading Assignment

As you read through the learning resource consider the following:

    How do classes and objects help model real-world entities in Java, and why is this important for writing organized and reusable programs?
    In what ways do encapsulation, access modifiers, and constructors work together to ensure proper data protection and object initialization?
    How does Java’s memory management, including instance variables, methods, and garbage collection, influence the lifecycle and performance of objects in an application? 

Read

    Burd, B. (2022). Java for dummies (8th ed.). John Wiley & Sons. ProQuest Ebook Central.  

    Read the following chapter:  
    Chapter 9: Why Object-Oriented Programming Is Like Selling Cheese. Students are introduced to the core principles of Object-Oriented Programming (OOP) through a relatable example that illustrates how real-world entities can be modeled using classes and objects. The chapter explains that a class serves as a blueprint defining an object’s characteristics and behaviors, while objects are specific instances created from these blueprints. In the section “More About Classes and Objects (Adding Methods to the Mix)”, students learn how methods give objects functionality, allowing them to perform actions and interact with one another. The chapter also covers Java’s modifiers such as public, private, and static, emphasizing how they control data accessibility and support encapsulation for secure and organized code. Overall, the chapter highlights how OOP makes programming more modular, reusable, and aligned with real-world problem solving, setting the stage for further learning on constructors, initialization, and memory management.

    Eck, D. J. (2022). Introduction to programming using Java (Version 9, JavaFX Edition). Hobart and William Smith Colleges. https://math.hws.edu/javanotes/ Licensed under a Creative Commons Attribution–NonCommercial–ShareAlike 4.0 International License. 

    Read the following chapter:  
    Chapter 5: Programming in the Large II — Objects and Classes provides a comprehensive introduction to object-oriented programming in Java, focusing on how to design and implement programs using classes and objects. It explains that a class serves as a blueprint that defines the structure and behavior of objects through instance variables and methods, while an object represents an individual instance of that class. The chapter emphasizes the importance of encapsulation, which restricts direct access to an object’s data using access modifiers like private and public, ensuring data integrity and modularity. Students also learn about constructors, which are special methods used to initialize new objects, and the concept of object lifecycle, including how Java’s garbage collector automatically manages memory by reclaiming unused objects. Through clear explanations and practical examples, the chapter builds a strong understanding of how classes and objects work together to create structured, reusable, and maintainable Java programs.

Additional Readings

    Vatsavayi, V. K., & Varma, K. P. (n.d.). Java programming. Pressbooks. https://pressbooks.pub/javaprogramming/chapter/classes-in-java-java-programming/Licensed under a Creative Commons Attribution–NonCommercial–ShareAlike 4.0 International License 

    Read the following chapter:  
    Chapter 6: Classes in Java: In this chapter, students are introduced to the concept of classes and objects in Java, where a class serves as a blueprint that defines the state (instance variables) and behavior (methods) of objects, and an object is an instance of that class. The chapter explains how to define a basic class and create objects using the new operator, how constructors are used to initialize new objects (including the default constructor supplied by Java when none is explicitly defined), and how methods enable objects to perform actions. It also covers Java’s modifiers (public, protected, private, static, final) that govern access and behavior of class members, explains the use of the this keyword to reference the current object, and introduces the concept of automatic garbage collection (with the finalize() method) that manages memory for objects no longer in use. Altogether, the chapter lays a foundational understanding of how Java’s object-oriented features enable structured, modular, and maintainable programs.  

Watch

    Coding with John. (2021, Sep 27). Java constructors – full tutorial [YouTube]. YouTube.

    This video tutorial provides a clear and practical explanation of constructors in Java, focusing on their role in object creation and initialization. The video begins by defining what a constructor is and how it differs from regular methods, emphasizing that constructors are automatically called when a new object is created using the new keyword. The instructor explains the syntax and naming rules for constructors, including default, parameterized, and copy constructors, with simple code examples to illustrate each concept. Students learn how constructors help set initial values for instance variables and how constructor overloading allows multiple ways to initialize an object with different sets of data. Overall, the video effectively reinforces how constructors contribute to clean, organized, and efficient object-oriented programming in Java. 

Watch on YouTube


Instructions

This assignment will assess your knowledge and skills about:  

     Developing classes and objects to model real-world entities.
    Analyzing object behavior and lifecycle in Java applications 

Assignment 
Online Shopping Cart System 

Scenario: You are working as a junior Java developer for an e-commerce company that wants to develop a basic Online Shopping Cart System. The goal is to model products and their behavior using classes and objects, ensure data security using encapsulation, and manage memory efficiently as users add and remove items from their carts.

    To develop a Java program that models an online shopping cart using classes and objects, you will: 

        Create a class named Product with three private instance variables: productName, price, and quantity. These variables should store the product’s name, price, and available units respectively. Add a constructor to initialize all three variables when a new Product object is created.
        Include methods such as addToCart(), removeFromCart(), and displayProductInfo() to perform actions for adding products, removing products, and displaying product details respectively.
        In your main() method, create at least 3 product objects, simulate adding and removing them from a cart, and display the final cart summary (product’s name, quantity, price, and grand total). 

Once you run the program, provide labeled screenshots along with code showing correct program execution with valid input for: 

        Adding products to the cart
        Removing a product
        Displaying the final cart summary 

    Analyze what happens after testing your program code created in Q1, when a product object is no longer needed (for example, when an item is removed from the cart and no longer referenced). How does Java’s garbage collection mechanism reclaim its memory, and why is this process beneficial for system performance? 

