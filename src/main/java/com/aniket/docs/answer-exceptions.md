

## Exception

1. **Difference between Error and Exception?**

    - **Error**: Errors in Java represent serious, unrecoverable problems that typically occur at runtime and are beyond the control of the application. Examples include `OutOfMemoryError`, `StackOverflowError`, and `VirtualMachineError`. Errors are not meant to be caught or handled by application code but are instead typically dealt with at a higher level, such as by administrators or the runtime environment.

    - **Exception**: Exceptions, on the other hand, represent exceptional conditions that occur during the execution of a program. They are typically recoverable and can be handled by application code using try-catch blocks or by declaring them in method signatures. Exceptions in Java are further divided into checked and unchecked exceptions.

2. **Checked vs Unchecked Exception?**

    - **Checked Exception**: Checked exceptions are the exceptions that are checked at compile-time. These are the exceptions that must be either caught or declared in the method signature using the `throws` keyword. Examples include `IOException`, `SQLException`, etc.

    - **Unchecked Exception**: Unchecked exceptions, also known as runtime exceptions, are not checked at compile-time. They typically occur due to programming errors or unexpected conditions during runtime. Examples include `NullPointerException`, `ArrayIndexOutOfBoundsException`, `ArithmeticException`, etc.

3. **Create custom Exception?**

   To create a custom exception in Java, you need to extend the `Exception` class or one of its subclasses. Here's an example:
   ```java
   public class CustomException extends Exception {
       public CustomException(String message) {
           super(message);
       }
   }
   ```
   You can then throw and catch instances of this custom exception in your code.

4. **What is Runtime exception?**

   A runtime exception is a subclass of `RuntimeException` and represents exceptions that can occur during the execution of a program. These exceptions are unchecked, meaning they are not checked at compile time. Runtime exceptions typically result from programming errors, such as attempting to access an array element beyond its bounds or invoking a method on a null object reference.

5. **How does JVM handle Exception?**

   When an exception occurs in a Java program, the JVM searches the call stack for an exception handler, starting from the method where the exception occurred and moving up the call stack. If a matching exception handler is found (in a try-catch block), the control is transferred to the catch block to handle the exception. If no matching exception handler is found, the program terminates, and an error message is printed.

6. **Difference between `final`, `finalize`, and `finally`?**

    - `final`: `final` is a keyword in Java used to restrict the user. It can be used in various contexts such as variables, methods, and classes. When applied to a variable, it means the variable cannot be reassigned. When applied to a method, it means the method cannot be overridden. When applied to a class, it means the class cannot be subclassed.

    - `finalize()`: `finalize()` is a method in the `Object` class that is called by the garbage collector before an object is garbage collected. It can be overridden to perform cleanup operations before an object is destroyed.

    - `finally`: `finally` is a block in Java used to ensure that a section of code is always executed, whether an exception is thrown or not. It is typically used in conjunction with `try-catch` blocks to perform cleanup operations or resource releasing.

7. **Superclass of all exceptions?**

   The superclass of all exceptions in Java is the `Throwable` class.

8. **Is `Throwable` an interface?**

   No, `Throwable` is a class in Java, not an interface. It is the superclass of all exceptions and errors in Java.

9. **When does the `finally` block not get executed?**

   The `finally` block may not get executed in the following scenarios:
    - If the JVM exits during the execution of the `try` or `catch` block.
    - If the thread executing the `try` or `catch` block is interrupted or killed.
    - If there is a `System.exit()` call in the `try` or `catch` block.

10. **Can a subclass throw a higher checked exception than the base class?**

    No, a subclass cannot throw a higher checked exception than the base class. The overridden method in the subclass cannot throw a checked exception that is broader (higher in the exception hierarchy) than the exception thrown by the superclass's method.

11. **Can we throw an unchecked exception in a child class if the parent class doesn’t throw any exception?**

    Yes, a subclass can throw unchecked exceptions, even if the parent class doesn't throw any exception. Unchecked exceptions, being subclasses of `RuntimeException`, are not subject to the same restrictions as checked exceptions.

12. **Difference between `throw` and `throws()`?**

    - `throw`: `throw` is a keyword in Java used to explicitly throw an exception. It is followed by an instance of `Throwable` (usually an exception object) that represents the exception being thrown. For example: `throw new CustomException("Something went wrong")`.

    - `throws`: `throws` is a keyword used in method signatures to declare the exceptions that the method may throw. It indicates that the method can potentially throw one or more exceptions of the declared types. It does not actually throw an exception but rather specifies the types of exceptions that the method may propagate to its caller.