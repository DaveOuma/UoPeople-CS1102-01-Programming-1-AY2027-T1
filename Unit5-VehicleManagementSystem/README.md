Unit 5 Reading Assignment

As you go through the readings and watch the videos, consider the following:

    How does inheritance help reduce code duplication and in what ways does polymorphism improve flexibility and scalability in object-oriented systems? 
    What is method overriding, and how does dynamic method dispatch make overriding powerful in runtime behavior? 
    How do abstract classes differ from interfaces, and when should each be used in designing reusable code? 
    How can ArrayLists enhance data handling compared to traditional arrays, and what are some real-world examples of their use? 

Read

    Burd, B. (2022). Java for dummies (8th ed.). John Wiley & Sons. ProQuest Ebook Central.  

    Read the following chapter:  
    Chapter 8: Saving Time and Money: Reusing Existing Code  
        In this chapter, Burd emphasizes how software development becomes more efficient and cost-effective by reusing existing code rather than reinventing the wheel. He illustrates how extending pre-written classes (for example, creating subclasses of an “Employee” class like “FullTimeEmployee” or “PartTimeEmployee”), leveraging file-handling utilities, and adapting already tested modules can dramatically reduce development time and potential errors. The chapter covers key object-oriented practices such as subclass creation, method reuse, access modifiers (including protected) that allow safe class extension, and demonstrates how to decide when reuse makes sense. Ultimately, it shows that strategic reuse is not only a productivity booster but also a path toward more robust and maintainable Java programs.  

    Chapter 15: Fancy Reference Types  
        In this chapter, Burd shifts focus from primitive types to the more powerful world of reference types, exploring how interfaces, abstract classes, and more advanced object-oriented features allow Java programs to define flexible, extensible abstractions. He explains how an interface sets a contract for classes without providing full implementation, how abstract classes let you supply shared code while still forcing subclass specialisation, and how this trio of reference types supports polymorphism and code reuse in ways that primitive types cannot. By mastering these “fancy” reference types, you gain the ability to design cleaner architectures, define behaviours independent of specific classes, and build systems that can evolve as requirements change. 

    Eck, D. J. (2022). Introduction to programming using Java (Version 9, JavaFX Edition). Hobart and William Smith Colleges. https://math.hws.edu/javanotes/ Licensed under a Creative Commons Attribution–NonCommercial–ShareAlike 4.0 International License.

    Read the following chapter:  
    Chapter 5: Inheritance, Polymorphism, and Abstract Classes 
        The Section 5.5: explains how object-oriented programs capture shared structure and behavior through inheritance and polymorphism. It shows how to extend existing classes (e.g., adding getBlackjackValue() to a Hand) and clarifies access control, especially protected, for subclass use. It builds class hierarchies (e.g., Vehicle with Car/Truck/Motorcycle), covers upcasting to a superclass, safe downcasting with instanceof, and why not every superclass reference can be treated as a subclass without checks. Polymorphism is illustrated with a Shape superclass whose subclasses (Rectangle, Oval, RoundRect, etc.) each implement redraw(), so the same call dispatches to the right behavior at runtime. The section motivates abstract classes and abstract methods (e.g., Shape and redraw ()) as contracts you can reference but not instantiate, while noting Object as the ultimate superclass. Finally, it introduces final classes and methods, which prevent subclassing or overriding to guarantee fixed behavior.
        The Section 5.7 explains how interfaces in Java provide a flexible alternative to multiple inheritance, allowing classes to share behavior across different hierarchies. An interface defines method signatures (and constants) without implementations, and any class that implements an interface must define those methods. Unlike classes, a Java class can implement multiple interfaces while extending only one superclass, promoting modular and reusable code design. Starting with Java 8, default methods were introduced, enabling interfaces to include method implementations that classes can inherit or override, thereby offering limited multiple inheritance functionality. Interfaces can also serve as types, meaning variables, parameters, and arrays can be declared using an interface type, allowing polymorphic behavior, any object implementing that interface can be referenced and used interchangeably.

Additional Readings

    Vatsavayi, V. K., & Varma, K. P. (n.d.). Java programming. Pressbooks. https://pressbooks.pub/javaprogramming/chapter/classes-in-java-java-programming/Licensed under a Creative Commons Attribution–NonCommercial–ShareAlike 4.0 International License 

    Read the following chapter:  
    Chapter 8: Inheritance — Java Programming:   This chapter introduces inheritance, a core concept in object-oriented programming that promotes code reuse and extensibility. It explains how a subclass inherits attributes and methods from a superclass, enabling the addition of new functionalities without modifying existing code. The chapter covers the use of the super keyword to access superclass members, and demonstrates method overriding, where a subclass redefines a superclass method to change its behavior. It also discusses dynamic method dispatch, which allows Java to determine at runtime which version of an overridden method to execute, supporting runtime polymorphism. Further topics include abstract classes, which define incomplete implementations for subclasses to extend, and the use of the final keyword to prevent inheritance or overriding. The chapter concludes with an overview of the Object class, the root of Java’s class hierarchy, and the Class class, which provides runtime type information. 

Watch

    Coding with John. (2021, Feb 24). Array vs. ArrayList in Java tutorial - what's the difference? [Video]. YouTube. 

    In this tutorial, the presenter compares Java’s built-in arrays and the more flexible ArrayList class, outlining their key differences in size, capabilities, and typical use-cases. Arrays are described as fixed in length and efficient for situations where you know the number of elements ahead of time, while ArrayLists offer dynamic resizing and enriched operation methods (e.g., add, remove) suited for varying data quantities. The video also discusses performance trade-offs, type handling (including generics), and when one might favor arrays for simplicity or memory efficiency versus ArrayLists for flexibility and ease of use. 

 

    Coding with John. (2021, Apr 18). Java polymorphism fully explained in 7 minutes [Video]. YouTube. 

    This video introduces polymorphism in Java by showing how a reference of a superclass or interface type can point to objects of multiple subclasses, and how method calls on that reference will invoke the subclass’s implementation at runtime. The video explains the concept of dynamic method dispatch (i.e., runtime decision about which overridden method to call) and demonstrates how polymorphism promotes flexible code by letting you write to a general type and trust that the correct specific behavior will execute. It uses clear examples to illustrate how the same message (method call) can be handled differently depending on the actual object type. 

    Coding with John. (2021, Aug 20). Abstract classes and methods in Java explained in 7 minutes [Video]. YouTube. 

    In this video, the narrator explains the role of abstract classes and abstract methods in Java, emphasizing how they define a common template for subclasses while preventing direct instantiation of the abstract class itself. The video shows how an abstract class can contain both implemented (“concrete”) methods and unimplemented (“abstract”) methods, forcing subclasses to fill in the missing behavior. It highlights when to use an abstract class instead of a regular class or interface, and how this mechanism helps enforce consistent design, encourage reuse of shared functionality, and give structure to hierarchies of related types. 





Instructions

This assignment will assess your knowledge and skills about:

    Explaining inheritance, polymorphism, and interface design principles.
    Implementing abstract classes, overridden methods, array lists, and interfaces.
    Applying object-oriented principles to create simple, reusable code) 

Assignment: Vehicle Management System
Scenario:

You are helping a transport company develop a simple Vehicle Management System to store details about different types of vehicles and manage their maintenance schedules. The system should allow adding new vehicle types easily in the future.

    Explain how using inheritance, polymorphism, and interfaces can help design a Vehicle Management System that is easy to update and reuse. Use  an example of a ‘Vehicle’ base class that is  extended into ‘Car’ and ‘Motorbike’ subclasses to show how these object oriented features promote code reusability, flexibility, and simplified maintenance in such a system.
    Implement a Java program based on your explanation in Q1. The program should: 
        Create an abstract class Vehicle with variables brand, model, and year, and an abstract method showDetails().
        Then create two subclasses, Car and Motorbike, that override the showDetails() method to display specific details for each type.
        Store multiple vehicles in an ArrayList and use a loop to print all their details, demonstrating inheritance and polymorphism in practice.  

Note: (screenshot of program output showing polymorphism in action to be uploaded)

    Apply your program from Q2 to include a maintenance feature. It should: 

        Create an interface Serviceable with methods scheduleService() and completeService(). 
        Make both Car and Motorbike implement this interface.
        Use a Serviceable reference to call these methods for different vehicle objects, demonstrating upcasting and dynamic method dispatch to handle various vehicle types through a single interface.  

Note: (screenshot showing interface methods being called using upcasting to be uploaded)