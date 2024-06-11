Which version of Springboot is compatible/work with Java 17?

In Spring from where you're reading properties?

What annotation is required to ??

Default server in Springboot?

Types of server there in springboot

Change port of server in Springboot how?

Diffrent type of feature and component of springboot?

How many design patterns you know and worked?

Give an example of Decorator in Java?

How to run two seperate threads after one another?

Explain the deadlock scenerio?

What can we do to stop the deadlock scenerio in our code without synchronisation?

How much memeory is assigned to your application?

What is MetaSpace?

New features of Java 8?


1. **Spring Boot Compatibility with Java 17**:
    - If you need to use Spring Boot with Java 17, then you need to upgrade it to 2.5. X or higher. 
    - Spring Boot 3 and Spring Framework 6 come with out-of-the-box support with Java 17.

2. **Reading Properties in Spring**:
    - In Spring, properties can be read from various sources such as property files (`application.properties` or `application.yml`), environment variables, system properties, YAML files, command-line arguments, etc. Spring Boot automatically loads properties from `application.properties` or `application.yml` files present in the classpath.

3. **Annotation for Default Server in Spring Boot**:
    - The `@SpringBootApplication` annotation is typically used to mark the main class of a Spring Boot application. Spring Boot automatically configures an embedded web server (like Tomcat, Jetty, or Undertow) based on the classpath dependencies and properties in `application.properties` or `application.yml`.

4. **Types of Servers in Spring Boot**:
    - Spring Boot supports various embedded servers like Tomcat, Jetty, and Undertow. You can choose the server by adding the appropriate dependency to your `pom.xml` or `build.gradle`.

5. **Changing Server Port in Spring Boot**:
    - You can change the server port by setting the `server.port` property in the `application.properties` file. For example:
      ```properties
      server.port=8081
      ```

6. **Different Features and Components of Spring Boot**:
    - Spring Boot provides features like auto-configuration, standalone application, embedded servlet containers, production-ready metrics, health checks, externalized configuration, etc. Components include Spring Framework, Spring MVC, Spring Data, Spring Security, etc.

7. **Design Patterns Worked On**:
    - There are many design patterns like Singleton, Factory, Builder, Strategy, Observer, Decorator, etc. 

8. **Example of Decorator Pattern in Java**:
    - The Decorator pattern is used to add new functionality to an object without altering its structure. An example could be decorating a basic stream with buffering or encryption:
      ```java
      InputStream fileStream = new FileInputStream("file.txt");
      InputStream bufferedStream = new BufferedInputStream(fileStream);
      InputStream encryptedStream = new EncryptedInputStream(bufferedStream);
      ```

9. **Running Two Separate Threads Sequentially**:
    - You can use the `join()` method to wait for the first thread to finish before starting the second thread:
      ```java
      Thread thread1 = new Thread(() -> {
          // Thread 1 logic
      });
      Thread thread2 = new Thread(() -> {
          // Thread 2 logic
      });
 
      thread1.start();
      thread1.join(); // Wait for thread1 to finish
      thread2.start();
      ```

10. **Deadlock Scenario**:
    - Deadlock occurs when two or more threads are blocked forever, each waiting for the other to release a resource.
        - Thread 1 holds resource A and waits for resource B.
        - Thread 2 holds resource B and waits for resource A.

11. **Preventing Deadlock Without Synchronization**:
    - Avoiding nested locks, ensuring a fixed order of locking resources, or using timeouts when acquiring locks are some strategies to prevent deadlock without synchronization.

12. **Memory Assigned to Application**:
    - The amount of memory assigned to an application depends on various factors like JVM settings, system configuration, and application requirements. It can be specified using JVM arguments like `-Xmx` for maximum heap size. We have given 3GB of `-Xmx` (Xmx is a flag that specifies the maximum memory (in bytes) allocation pool for the JVM.)

13. **MetaSpace**:
    - MetaSpace is a part of the native memory used by the JVM to store class metadata, including class definitions and method information. Unlike the PermGen space used in older versions of Java, MetaSpace dynamically resizes itself depending on the application's requirements.

14. **New Features of Java 8**:
    - Java 8 introduced several significant features, including Lambda expressions, the Stream API, the Optional class, default and static methods in interfaces, the java.time package for date and time manipulation, and the CompletableFuture class for asynchronous programming, among others.
