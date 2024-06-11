# Spring Framework Inversion of Control (IoC) and Dependency Injection (DI)

## Introduction
In Spring Framework, Inversion of Control (IoC) is implemented through Dependency Injection (DI). IoC is a design principle where objects define their dependencies, but the actual resolution of those dependencies is delegated to a container. Dependency Injection is the process where the container injects these dependencies into the object.

## IoC Container
The core of Spring's IoC container lies in the `org.springframework.beans` and `org.springframework.context` packages. The `BeanFactory` provides the basic configuration framework, while the `ApplicationContext` adds more enterprise-specific functionality.

### Beans
In Spring, managed objects are referred to as beans. These beans are instantiated, assembled, and managed by the Spring IoC container.

### ApplicationContext
The `ApplicationContext` interface represents the Spring IoC container. It's responsible for instantiating, configuring, and assembling the beans.

## Configuration Metadata
The container receives instructions on what objects to instantiate, configure, and assemble through configuration metadata. This metadata can be represented in XML, Java annotations, or Java code.

### XML Configuration
XML configuration files declare beans and their dependencies. They specify bean properties, constructor arguments, and references to other beans.

Example: `services.xml` and `daos.xml`

```xml
<bean id="petStore" class="org.springframework.samples.jpetstore.services.PetStoreServiceImpl">
    <property name="accountDao" ref="accountDao"/>
    <property name="itemDao" ref="itemDao"/>
    <!-- additional collaborators and configuration for this bean go here -->
</bean>
```

### ApplicationContext Usage
The `ApplicationContext` allows reading bean definitions and accessing configured instances.

Example:

```java
// create and configure beans
ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");

// retrieve configured instance
PetStoreService service = context.getBean("petStore", PetStoreService.class);

// use configured instance
List<String> userList = service.getUsernameList();
```

## Dependency Resolution Process
The container resolves bean dependencies during initialization:

1. **ApplicationContext Initialization**: The container is created and initialized with configuration metadata.

2. **Dependency Declaration**: For each bean, dependencies are expressed through properties, constructor arguments, or factory methods.

3. **Dependency Injection**: Actual dependencies are provided to the bean when it's created. This can be references to other beans or literal values.

4. **Type Conversion**: Values specified in configuration are converted to the actual types required by properties or constructor arguments.

By default, Spring can convert string values to built-in types like int, long, String, boolean, etc.

Read here for more https://docs.spring.io/spring-framework/reference/index.html