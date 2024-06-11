

## Object

1. **Why is a wrapper class required?**

   Wrapper classes are required in Java to provide a way to convert primitive data types into objects (and vice versa) because Java is an object-oriented programming language, and objects are required to leverage many of its features, such as collections (like `ArrayList` and `HashMap`) and generics. Wrapper classes also provide utility methods for primitive types, such as conversion to and from strings, comparison, and parsing.

2. **Methods of the `Object` class?**

   The `Object` class in Java is the root class for all other classes. It provides several methods, including:
    - `toString()`: Returns a string representation of the object.
    - `equals(Object obj)`: Indicates whether some other object is "equal to" this one.
    - `hashCode()`: Returns a hash code value for the object.
    - `getClass()`: Returns the runtime class of this object.
    - `clone()`: Creates and returns a copy of this object.
    - `finalize()`: Called by the garbage collector on an object when garbage collection determines that there are no more references to the object.

3. **Does Java give importance to primitive data types?**

   While Java primarily operates with objects, primitive data types are still fundamental to the language. They are efficient in terms of memory usage and processing speed compared to objects. Java does give importance to primitive data types, as they are essential for performance-critical operations and are widely used in the language's syntax and standard libraries.

4. **Is Java pass by value or pass by reference?**

   Java is strictly pass-by-value. When you pass a primitive type to a method, it passes a copy of the value. When you pass an object reference to a method, it passes a copy of the reference, not the actual object. Therefore, modifications to the parameters inside the method affect the copies, not the original variables or objects.

## OOPs

1. **Types of OOPs**

   There are several types of Object-Oriented Programming (OOP) concepts:
    - **Encapsulation**: Bundling data and methods that operate on the data into a single unit (class), and restricting access to some of the object's components.
    - **Inheritance**: A mechanism where a new class inherits properties and behavior (methods) of an existing class.
    - **Polymorphism**: The ability of an object to take on multiple forms. It occurs when there is a hierarchy of classes related through inheritance.
    - **Abstraction**: Hiding the complex implementation details and showing only the necessary features of an object.

2. **Composition vs Aggregation vs Association?**

    - **Composition**: Composition implies a relationship where the child cannot exist independently of the parent. If a parent object is destroyed, all its child objects are also destroyed.

    - **Aggregation**: Aggregation implies a relationship where the child can exist independently of the parent. It represents a "has-a" relationship. If a parent object is destroyed, the child objects can still exist.

    - **Association**: Association implies a relationship where all objects have their lifetimes and there is no ownership. It represents a "uses-a" relationship.

3. **Function overloading vs overriding?**

    - **Function Overloading**: In Java, function overloading refers to defining multiple methods in a class with the same name but different parameters. The methods must have different parameter lists (number or types of parameters). Overloading is resolved at compile time.

    - **Function Overriding**: Function overriding occurs when a subclass provides a specific implementation of a method that is already provided by its parent class. The signature of the method in the subclass must match the signature of the method in the superclass. Overriding is resolved at runtime.

4. **Difference between Abstract class and Interface?**

    - **Abstract Class**: An abstract class in Java is a class that cannot be instantiated. It may contain abstract methods (methods without a body) that must be implemented by its subclasses. It can also contain concrete methods. Abstract classes can have constructors.

    - **Interface**: An interface in Java is a reference type, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types. It cannot have constructors. Classes implement interfaces by providing implementations for the methods defined in the interface.

5. **Can private method or static methods be overridden in Java?**

   No, private methods cannot be overridden in Java. They are not accessible outside the class they are defined in, so they cannot be accessed by subclasses. Similarly, static methods also cannot be overridden because they belong to the class itself, not to instances of the class.

6. **Can the `main()` method be overloaded?**

   Yes, the `main()` method in Java can be overloaded like any other method. However, keep in mind that the JVM always looks for the `public static void main(String[] args)` method signature to start the execution of the program. Other overloaded `main()` methods can exist but won't be the entry point of the program.

7. **Can an Abstract class have a `main` method?**

   Yes, an abstract class can have a `main()` method like any other class. However, it won't be the entry point of the program unless it is the class provided to the JVM when running the program.