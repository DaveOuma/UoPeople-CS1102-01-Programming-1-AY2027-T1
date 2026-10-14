Unit 6 Reading Assignment

As you read through the learning resource consider the following:

    How does JavaFX make it easier to build interactive and user-friendly programs than using the console?
    How does event handling let a program respond to user actions like button clicks or text input?
    Why is try-with-resources important for file handling, and how does it prevent errors or data loss?
    How can multithreading make a program faster, and what must you do to update the JavaFX interface safely from background tasks?
    How do user-centered design and accessibility features (like high-contrast colors, tooltips, or larger text/icons) make software clearer and more inclusive for all users? 

Read

    Burd, B. (2022). Java for dummies (8th ed.). John Wiley & Sons. ProQuest Ebook Central.  

    Read the following chapter:  
    Chapter 16: Java’s Juggling Act    
        This chapter covers three major sub-sections: Juggling Two or More Calls, Some Events Aren’t Button Clicks, and The Inner Sanctum. It explains how Java applications handle multiple tasks and events simultaneously. In the section “Juggling Two or More Calls”, the author shows how methods can call each other and how control passes between them, Java must manage nested method calls, recursion, and multiple threads of execution gracefully. The next section, “Some Events Aren’t Button Clicks”, expands the concept of event-handling beyond simple button clicks to other sources such as keyboard input, mouse movement, window events, and timers, emphasizing that GUI programs must listen and react to a wide variety of user- or system-triggered events. Finally, in “The Inner Sanctum”, the focus is on internal mechanics, how Java’s event-dispatch thread works (especially in GUI frameworks), how callbacks such as actionPerformed() are invoked behind the scenes, and what programmers must do to keep UIs responsive and safe (e.g., not blocking the event thread). In sum, the chapter underlines that building Java applications (especially with GUIs) involves juggling multiple execution paths and reacting to diverse events, and doing so safely and efficiently is key to responsive, robust programs.

    Eck, D. J. (2022). Introduction to programming using Java (Version 9, JavaFX Edition). Hobart and William Smith Colleges. https://math.hws.edu/javanotes/ Licensed under a Creative Commons Attribution–NonCommercial–ShareAlike 4.0 International License.

    Read the following chapter:  
    Chapter 6: Introduction to GUI Programming (Sections 6.1 – 6.4) 

        These sections introduce JavaFX framework and explains how to build modern, interactive graphical user interfaces. It shows how to create a Stage (window) and a Scene (content area), and how to add user interface components such as labels, buttons, text fields, and layout containers (VBox, HBox, BorderPane) to organize them neatly. The section also explains the event-driven programming model, where user actions, like button clicks or text input, trigger event handlers that define how the program responds. Examples demonstrate how to separate interface design from application logic, making code easier to manage and update. Finally, the chapter covers styling and usability basics, including how to adjust fonts, spacing, and alignment to make interfaces more readable and user-friendly. 
    Chapter 11: Input/Output Streams, Files, and Networking (Section 11.2 – 11.4) 
        These sections explain how to read from and write to files safely and efficiently using Java’s stream classes such as FileWriter, FileReader, and BufferedReader. The chapter highlights how try-with-resources automatically closes files after use, preventing resource leaks and data corruption. You’ll learn how to store, retrieve, and update data in text files (like tasks.csv) in a structured format, handle common I/O exceptions, and verify that file operations complete correctly. It also introduces concepts like character vs. byte streams, buffered I/O for faster processing, and best practices for maintaining data consistency and reliability in applications that save user tasks or settings. 

Additional Readings

    Vatsavayi, V. K., & Varma, K. P. (n.d.). Java programming. Pressbooks. https://pressbooks.pub/javaprogramming/chapter/classes-in-java-java-programming/Licensed under a Creative Commons Attribution–NonCommercial–ShareAlike 4.0 International License 

    Read the following chapter:  
    Chapter 13: Multithreading- Java Programming:   

    This chapter explains the concept of multithreading in Java, where multiple threads run concurrently within a single program to perform different tasks at the same time. It distinguishes between multiprocessing, which uses separate processes, and multithreading, which allows threads to share the same memory space for faster communication and lower overhead. The chapter introduces the Thread class and the Runnable interface, showing how to create, start, and manage threads. A key focus is on synchronization, which prevents conflicts when multiple threads access shared resources simultaneously by using the synchronized keyword or blocks. The chapter also discusses the benefits and challenges of multithreading: improved responsiveness and resource utilization versus potential risks like race conditions and deadlocks. In GUI applications such as JavaFX, these concepts are essential for keeping the interface responsive while performing background tasks safely. 

Watch

    Coding with John. (2021, Apr 26). Java file input/output - It's way easier than you think [Video]. YouTube. 

    This video introduces basic file input and output in Java using FileWriter, BufferedWriter, FileReader, and BufferedReader. It shows how to open files, write lines of text, and read them back efficiently. The instructor clearly explains the use of try-with-resources, which automatically closes file streams after use and prevents memory leaks or file corruption. He also demonstrates simple exception handling with IOException and stresses writing clean, readable file-handling code.

    Coding with John. (2021, Jun 28). Multithreading in Java explained in 10 minutes [Video]. YouTube. 

    The video introduces the concept of multithreading in Java, explaining how it enables a program to run multiple tasks concurrently. It covers two main ways to create threads in Java: extending the Thread class and implementing the Runnable interface. It explains that you must call start() to begin a thread (which internally calls run()), and highlights that exceptions in one thread don’t necessarily stop others. The tutorial shows how using threads can keep applications responsive (for example a GUI or background task) and warns that thread scheduling is managed by the JVM and cannot be precisely controlled by code.

    Bro Code. (2020, November 19). JavaFX install & setup (IntelliJ)  [Video]. YouTube. 

    In this tutorial, Bro Code walks you through installing and configuring JavaFX for use with IntelliJ IDEA on Windows: first downloading the JavaFX SDK, then creating a new project in IntelliJ and adding the JavaFX library (via the lib folder) to the project setup. Next he shows how to set the necessary VM options (such as --module-path <path> and --add-modules javafx.controls,javafx.fxml) so that your application runs correctly since JavaFX is not bundled with newer JDKs. After the setup, he demonstrates running a simple JavaFX application to verify everything works. 


Instructions

This assignment will assess your knowledge and skills about: 

    Constructing simple interactive user interfaces using JavaFX  
    Implementing file handling and multithreading for responsive applications  
    Applying user-centered design principles to improve GUI usability  
    Examining Java code to determine the correct application of inheritance, polymorphism, and interface design for solving programming problems. 

Assignment: Student Task Manager Application

Scenario Overview:

You are part of a development team working for your university’s Learning Support Department. The department has noticed that many students struggle to track their coursework deadlines, exams, and project milestones, especially when juggling multiple subjects. To address this, you have been asked to prototype a Student Task Manager Application that helps students organize, visualize, and manage their academic workload more effectively.

The application will start as a simple JavaFX interface for entering tasks and evolve through multiple development stages to include interactivity, persistence, accessibility, and object-oriented structure.

    Construct a JavaFX-based Student Task Manager Interface that allows users to:

    Add tasks 
    Set deadlines 
    Mark them as completed

Use layout managers such as VBox, HBox, or BorderPane to organize the task list, input fields, and control buttons neatly.

Upload a screenshot of your interface showing successful display of the task input area and buttons.

    Implement interactive and persistent features to extend the interface you constructed in Q1. It should:

    Implement event logic so that when a student adds or completes a task, the task list updates dynamically on the user interface in real time.
    Implement file handling functionality that automatically writes all tasks to a file named tasks.csv whenever a task is added or marked as complete. Use try-with-resources to ensure safe and efficient file writing in the format: Task Name, Deadline, Status.
    Implement a simple multithreading feature that simulates a background activity using a separate thread or timer that prints or displays short messages such as  “Loading saved tasks…” or “Checking upcoming deadlines…” every few seconds while the student continues interacting with the interface. 

Upload a screenshot showing the output for each feature (task update, file saving, background message).

    Apply user-centered design principles by implementing two improvements such as high-contrast colors, tooltips, or larger text and icons, to make your Task Manager interface from Q2 clearer, more inclusive and accessible to students with color blindness or visual impairments. 

Upload a screenshot of the updated interface showing the applied design improvements.

    Examine how to improve your Student Task Manager application’s maintainability by applying object-oriented programming principles. For that create an interface named Task with one method displayTaskDetails() and two  classes i.e. AssignmentTask and ExamTask, that implement Task interface. 

    AssignmentTask might include attributes like title and due date.
    ExamTask might include subject and exam date. 

In each class, override displayTaskDetails() to show the task type and its information in a clear format.

Upload a screenshot of your code execution showing how each class displays its own task details differently when the program runs.  
