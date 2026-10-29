Unit 8 Reading Assignment

As you read through the learning resource consider the following:

    How do Java classes, fields, constructors, and encapsulation help maintain clarity and reusability in a GUI-based program? 
    How do lists, tables, and file-handling help manage and save dynamic data (like a book catalog) in real applications? 

Read

    Burd, B. (2022). Java for dummies (8th ed.). John Wiley & Sons. ProQuest Ebook Central.  

    Read the following chapter:  
    Chapter 16: Java’s Juggling Act   
        This chapter explains how Java programs respond to user actions through event-driven programming rather than following a fixed step-by-step flow. The chapter introduces event handlers, which are methods triggered by user actions such as button clicks, typing in a text field, or selecting items in a list. It shows how listener objects or handler methods are connected to UI controls, allowing programs to “wait and react” to input instead of running continuously. The chapter also highlights how handlers can be written using inner classes or simplified lambda expressions to keep code clear and maintainable. These ideas directly support tasks like adding, removing, or searching books in a JavaFX interface, where user actions must update the catalog dynamically and cleanly.

    Eck, D. J. (2022). Introduction to programming using Java (Version 9, JavaFX Edition). Hobart and William Smith Colleges. https://math.hws.edu/javanotes/ Licensed under a Creative Commons Attribution–NonCommercial–ShareAlike 4.0 International License.

    Read the following chapter:  
    Chapter 5: Programming in the Large II: Objects and Classes 

        The chapter explains how objects provide a more powerful way of organizing programs than individual subroutines, because objects bundle both data (instance variables) and behaviors (instance methods) into a single structure. The early sections introduce the essentials of defining and using objects and classes in Java, while later sections extend these concepts with more advanced topics such as inheritance and polymorphism. Although these advanced ideas allow classes to build on one another in complex hierarchies, the textbook focuses on simpler, practical uses of objects, creating independent classes with clear responsibilities, making programs easier to design, maintain, and reuse. 
    Chapter 11: Input/Output Streams, Files, and Networking 
        This chapter introduces Java’s input/output (I/O) mechanisms, explaining how programs communicate with sources other than the user, such as files and network connections. This communication is managed through I/O streams, objects like System.in and System.out, which allow data to be read from or written to many different destinations using a consistent set of commands. The chapter highlights that using streams for files and networking requires understanding exceptions, since many I/O operations can fail and therefore must be handled with try…catch. It also explains that network-based communication often relies on multithreading, a topic later expanded in Chapter 12. 

Additional Readings

    Eck, D. J. (2022). Introduction to programming using Java (Version 9, JavaFX Edition). 
    Hobart and William Smith Colleges. https://math.hws.edu/javanotes/ 
    Licensed under a Creative Commons Attribution–NonCommercial–ShareAlike 4.0 International License. 

    Read the following chapter:  
    Chapter 13: GUI Programming Continued   

    This chapter expands on GUI programming with JavaFX, moving beyond the basic components, layouts, and events introduced earlier to explore more features needed for building sophisticated applications. While the fundamentals from earlier chapters are enough for many programs, this chapter shows how JavaFX offers a much richer toolkit, enabling more complex and visually polished interfaces. It emphasizes that JavaFX is too extensive to be covered fully within the book, but aims to deepen the reader’s practical understanding by introducing additional GUI capabilities without attempting to cover advanced multimedia and 3D features.  

Watch

    CS Herol. (2022, Feb 1). Java tutorial: How to create a JavaFX project in IntelliJ [Video]. YouTube.   

    This video tutorial walks viewers through setting up a new JavaFX project in the IntelliJ IDEA environment. It begins with configuring the project , adding the necessary JavaFX libraries, and then shows how to compile and run a basic application with a simple graphical scene. It’s a clear and helpful guide for developers who want a straightforward way to get started with JavaFX inside IntelliJ.

Watch on YouTube

    Java Code Junkie. (2020, July 7).  Create TableView | JavaFX GUI tutorial for beginners [Video]. YouTube.

    The video explains how to build a simple read-only table using JavaFX, focusing on creating a data class to store information and displaying it in a TableView. It shows how to define a class with fields such as name or value, create table columns, and link each column to a specific field so the data appears correctly in the table. The tutorial also demonstrates how to load and display the data using an ObservableList, providing a clear step-by-step guide for beginners who want to show structured tabular data in a JavaFX application. 

Watch on YouTube




 Instructions

This assignment will assess your knowledge and skills about: 

     Creating a complete Java application integrating major course concepts.  
    Evaluating the design, functionality, and performance of the final project. 

A community library is seeking a simple digital tool to manage its book collection. The library staff needs an application that allows them to add new books, search by title or author, check books in and out, and maintain an up-to-date catalog. They also require the ability to save and reload the catalog for daily operations.

1. Create a JavaFX application BookCatalogApp that integrates the major course concepts by completing the following tasks:

a. Create a class named Book with the fields:

isbn (String)

title (String)

author (String)

available (boolean)

Use appropriate constructors, getters/setters, and encapsulation.

b. Construct a JavaFX interface that displays all books using an ObservableList<Book> in a TableView or ListView.

c. Implement a form that allows users to Add new books with proper input validation (e.g., non-empty title/author, non-empty/ unique ISBN, valid ISBN format if required).

d. Implement user actions for managing books, including:

        Removing the selected book. 
        Checking out or returning a book by toggling its available status. 
        Searching/filtering books by title or author using Java Streams or collection iteration for live updates. 

e. Implement saving and loading the book catalog using CSV file handling

2. Evaluate your final Book Catalog application by addressing the following points with verifiable evidence:

a. Describe how your class design, JavaFX layout, and event-handling structure support clarity and maintainability.

b. Provide two test examples that demonstrate correct behavior and user experience for the core features (Add, Search, and Check-Out/Return or Remove). For each test include:

        Input: what the user did 
        Expected output 
        Actual output: screenshot of the running application showing the result 
        A short comment (1–2 sentences) on usability and responsiveness observed during these tests (e.g., ease of interaction, clarity of UI, responsiveness when adding/searching/selecting/updating) 



# BookCatalogApp

## Requirements
- JDK 17 or newer
- Maven 3.9+ (or open this Maven project in IntelliJ IDEA and use the Maven wrapper if available)
- Internet access on the first build so Maven can download JavaFX dependencies

## Run
From this folder:
```bash
mvn clean javafx:run
```
In IntelliJ IDEA, open this folder as a Maven project, wait for dependency resolution, then run `BookCatalogApp.main()`.

## Features
- Encapsulated `Book` class with four private fields and constructors/getters/setters
- Four correctly bound TableView columns
- Add validation for non-empty title/author/ISBN, unique ISBN and ISBN-10/ISBN-13 checksum
- Remove selected book
- Check out / return selected book
- Live, case-insensitive title/author search using `FilteredList` and a Java Stream count
- CSV save/load with quoting for commas and quotation marks
- Load into a temporary list and validate before replacing the visible catalog

## Screenshot evidence
Run the application yourself and capture actual screenshots. Do not submit placeholder images as evidence. Suggested evidence:
1. `Test1`: add a book and show the filtered title/author result in the table.
2. `Test2`: show the selected book with Available set to false after checkout, then optionally capture it returned to true.
3. Optional: `Test3`: save, restart, load the CSV and show the restored records.

Use sample ISBNs that pass checksum validation, for example:
- 9780134685991 (ISBN-13)
- 0132350882 (ISBN-10)

