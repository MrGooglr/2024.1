### Understanding Java Functional Interfaces

In Java 8, the concept of functional programming was introduced, bringing along functional interfaces. Let's dive into the details of Java functional interfaces, including their definition, usage, and some built-in functional interfaces in Java.

#### Definition of Functional Interface

A functional interface in Java is an interface that contains exactly one abstract method. While it can also have default and static methods with implementations, it must have only one unimplemented method.

##### Example:
```java
public interface MyFunctionalInterface {
    void execute();
}
```

#### Functional Interface Implementation

Functional interfaces can be implemented using regular classes or lambda expressions.

##### Example with a Regular Class:
```java
public class MyFunctionalInterfaceImpl implements MyFunctionalInterface {
    @Override
    public void execute() {
        System.out.println("Executing...");
    }
}
```

##### Example with a Lambda Expression:
```java
MyFunctionalInterface lambda = () -> {
    System.out.println("Executing...");
};
```

#### Built-in Functional Interfaces in Java

Java provides a set of built-in functional interfaces to cover common use cases in functional programming. Let's explore some of them:

##### Function
The `Function` interface represents a function that takes a single parameter and returns a single value.

##### Predicate
The `Predicate` interface represents a function that takes a single value as a parameter and returns `true` or `false`.

##### UnaryOperator
The `UnaryOperator` interface represents an operation that takes a single parameter and returns a parameter of the same type.

##### BinaryOperator
The `BinaryOperator` interface represents an operation that takes two parameters of the same type and returns a single value of the same type.

##### Supplier
The `Supplier` interface represents a function that supplies a value.

##### Consumer
The `Consumer` interface represents a function that consumes a value without returning any value.

#### Example Implementations

Let's see some examples of implementing these built-in functional interfaces:

##### Predicate Example:
```java
Predicate<String> predicate = (str) -> str != null && !str.isEmpty();
```

##### UnaryOperator Example:
```java
UnaryOperator<Integer> unaryOperator = (num) -> num * num;
```

##### BinaryOperator Example:
```java
BinaryOperator<Integer> binaryOperator = (num1, num2) -> num1 + num2;
```

##### Supplier Example:
```java
Supplier<Integer> supplier = () -> (int) (Math.random() * 100);
```

##### Consumer Example:
```java
Consumer<String> consumer = (str) -> System.out.println(str);
```

These built-in functional interfaces provide a convenient way to work with functional programming constructs in Java, promoting cleaner and more concise code.

https://jenkov.com/tutorials/java-functional-programming/functional-interfaces.html