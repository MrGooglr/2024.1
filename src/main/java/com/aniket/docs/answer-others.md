

## Other

1. **Difference between JDK, JRE, and JVM?**

    - **JDK (Java Development Kit)**: JDK is a software development kit that includes tools for developing Java applications, such as the Java compiler (`javac`), Java runtime environment (`java`), debugger, documentation generator, and other development tools. It also includes the Java API libraries and header files needed for Java development.

    - **JRE (Java Runtime Environment)**: JRE is a runtime environment that allows Java applications to be executed. It includes the Java Virtual Machine (JVM), class libraries, and other supporting files required to run Java applications. JRE does not include development tools like JDK.

    - **JVM (Java Virtual Machine)**: JVM is a virtual machine that provides an execution environment for Java bytecode. It interprets and executes Java bytecode instructions, manages memory allocation and garbage collection, and provides other runtime services like exception handling and security. JVM implementations are platform-specific, but they all follow the Java Virtual Machine Specification.

2. **What is Immutable class?**

   An immutable class is a class whose instances cannot be modified after they are created. Immutable objects have fixed state and are thread-safe, meaning they can be safely shared among multiple threads without the need for synchronization. Immutable classes in Java are typically created by ensuring that their fields are final and do not have any setter methods. Examples of immutable classes in Java include `String`, `Integer`, and `LocalDate`.

3. **What are SOLID principles?**

   SOLID is an acronym for five object-oriented design principles that help create well-structured, maintainable, and scalable software:

    - **Single Responsibility Principle (SRP)**: A class should have only one reason to change, meaning it should have only one responsibility or concern.

    - **Open/Closed Principle (OCP)**: Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that the behavior of a module can be extended without modifying its source code.

    - **Liskov Substitution Principle (LSP)**: Subtypes should be substitutable for their base types without altering the correctness of the program. In other words, derived classes should be able to replace their base classes without affecting the behavior of the program.

    - **Interface Segregation Principle (ISP)**: Clients should not be forced to depend on interfaces they do not use. Instead of creating large, monolithic interfaces, interfaces should be segregated into smaller, more specific ones.

    - **Dependency Inversion Principle (DIP)**: High-level modules should not depend on low-level modules; both should depend on abstractions. Abstractions should not depend on details; details should depend on abstractions. This principle encourages the use of interfaces and dependency injection to decouple classes and modules.

4. **Difference between ClassNotFoundException vs NoClassDefError?**

    - **ClassNotFoundException**: `ClassNotFoundException` is a checked exception that occurs when the JVM tries to load a class at runtime using the `Class.forName()` method or when attempting to load a class by name using the `loadClass()` method of the `ClassLoader`, but the specified class cannot be found in the classpath.

    - **NoClassDefFoundError**: `NoClassDefFoundError` is an error that occurs when the JVM tries to load a class at runtime and the class definition is found, but the class cannot be initialized. This can happen if the class file exists, but one of its dependent classes or resources is missing or inaccessible.

5. **What is Singleton Design pattern? Explain ThreadSafe Singleton and Bill Pugh Singleton?**

   Singleton pattern is a creational design pattern that ensures a class has only one instance and provides a global point of access to that instance.

    - **ThreadSafe Singleton**: In a multithreaded environment, a typical implementation of the Singleton pattern may not be thread-safe and could lead to the creation of multiple instances. To make it thread-safe, we can use synchronization or double-checked locking to ensure that only one instance is created even in a concurrent environment. However, this approach can impact performance due to synchronization overhead.

    - **Bill Pugh Singleton**: Bill Pugh Singleton is an improvement over the traditional singleton pattern that uses a static inner helper class to lazily initialize the Singleton instance. This approach leverages the classloader's lazy loading behavior to ensure thread safety without the need for synchronization. It is considered more efficient and thread-safe than traditional synchronization-based approaches.

6. **How to break Singleton?**

   Singleton pattern can be broken in several ways:

    - **Reflection**: Using reflection, it's possible to access the private constructor of a singleton class and create multiple instances.

    - **Serialization and Deserialization**: If a singleton class is Serializable, multiple instances can be created during deserialization.

    - **Cloning**: Cloning a singleton object can create a copy, breaking the uniqueness of the singleton instance.

    - **Multithreading**: Improper implementation of lazy initialization in a multithreaded environment can lead to the creation of multiple instances.

    - **Classloaders**: If multiple class loaders are used and each loads a singleton class independently, multiple instances can be created.

7. **Explain a few features in each Java version starting from Java8?**

    - **Java 8**: Introduced lambda expressions, functional interfaces, streams API, default methods in interfaces, `java.time` package for date and time, and the `Optional` class.

    - **Java 9**: Introduced modularization with the Java Platform Module System (JPMS), JShell for interactive Java programming, improvements to the Process API, and enhancements to the HTTP/2 and TLS protocols.

    - **Java 10**: Introduced local variable type inference (var keyword), improvements to the garbage collector, enhancements to the Optional class, and support for parallel full GC.

    - **Java 11**: Introduced the `HttpClient` API for sending HTTP requests and receiving responses, improvements to the garbage collector (Epsilon GC), and support for running Java applications as native executables with GraalVM.

    - **Java 12**: Introduced switch expressions as a preview feature, improvements to the garbage collector (Shenandoah GC), and enhancements to the `String` class.

    - **Java 13**: Introduced text blocks (preview feature), enhancements to the switch statement, improvements to the `String` class, and updates to the `Socket` API.

    - **Java 14**: Introduced records as a preview feature, pattern matching for `instanceof`, enhancements to the `NullPointerException`, and improvements to the `Garbage Collector`.

    - **Java 15**: Introduced sealed classes and interfaces as a preview feature, hidden classes, enhancements to the `Pattern` class, and updates to the `Garbage Collector`.

    - **Java 16**: Introduced records, sealed classes, and pattern matching as standard features, enhancements to the `Garbage Collector`, improvements to the `Vector API`, and updates to the `Pattern` class.
   
   - **Java 17**: Introduced `Sealed Classes`, `Pattern Matching for Switch`, `Strong Encapsulation of JDK Internals`, `JEP 356: Enhanced Pseudo-Random Number Generators`, `JEP 382: New macOS Rendering Pipeline`, and various other enhancements and updates.