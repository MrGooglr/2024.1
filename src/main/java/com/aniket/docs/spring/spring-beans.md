# Bean Scopes in Spring Framework

When defining a bean in Spring, you not only specify its dependencies and configuration but also its scope. Bean scope determines the lifecycle and visibility of the bean instance within the application context. Spring provides several built-in scopes, as well as the ability to define custom scopes.

## Singleton Scope (Default)

- **Description**: Scopes a single bean definition to a single object instance for each Spring IoC container.
- **Behavior**: Only one instance of the bean is created for the entire application context.
- **Example**: Typically used for stateless beans or beans that can be shared safely across multiple components.

## Prototype Scope

- **Description**: Scopes a single bean definition to any number of object instances.
- **Behavior**: Each time the bean is requested, a new instance is created.
- **Example**: Useful for stateful beans or beans that should not be shared across components.

## Request Scope (Web-aware ApplicationContext)

- **Description**: Scopes a bean to the lifecycle of a single HTTP request.
- **Behavior**: Each HTTP request gets its own instance of the bean.
- **Example**: Suitable for beans that hold request-specific data or state.

## Session Scope (Web-aware ApplicationContext)

- **Description**: Scopes a bean to the lifecycle of an HTTP Session.
- **Behavior**: Each user session gets its own instance of the bean.
- **Example**: Useful for beans that maintain session-specific data or state.

## Application Scope (Web-aware ApplicationContext)

- **Description**: Scopes a bean to the lifecycle of a ServletContext.
- **Behavior**: Only one instance of the bean is created for the entire web application context.
- **Example**: Typically used for global beans that are shared across the entire application.

## WebSocket Scope (Web-aware ApplicationContext)

- **Description**: Scopes a bean to the lifecycle of a WebSocket.
- **Behavior**: Each WebSocket connection gets its own instance of the bean.
- **Example**: Suitable for beans that manage WebSocket-specific data or state.

## Custom Scopes

- **Description**: Allows defining custom bean scopes tailored to specific application requirements.
- **Behavior**: Developers can implement custom logic to manage the lifecycle and visibility of bean instances.
- **Example**: Custom scopes can be created for specialized use cases not covered by built-in scopes.

By selecting the appropriate scope for each bean, developers can effectively manage resource usage, optimize performance, and ensure proper data isolation within the Spring application context.


## The BeanFactory API

The BeanFactory API forms the foundation of Spring's Inversion of Control (IoC) functionality. It provides contracts that are primarily utilized in integration with other parts of Spring and third-party frameworks. The `DefaultListableBeanFactory` implementation serves as a crucial delegate within the higher-level `GenericApplicationContext` container.

### Key Interfaces and Components

- **BeanFactory**: The core interface representing the IoC container. It provides methods for retrieving bean instances based on their names or types.
- **Related Interfaces**: Interfaces like `BeanFactoryAware`, `InitializingBean`, and `DisposableBean` serve as integration points for other framework components.
- **Callback Interfaces**: These interfaces allow for efficient interaction between the container and its components without requiring annotations or reflection.

### Flexibility and Extensibility

- **Configuration Format Agnostic**: The core BeanFactory API does not make assumptions about the configuration format or component annotations to be used. All configuration flavors come in through extensions.
- **Shared Metadata Representation**: Extensions operate on shared `BeanDefinition` objects as a core metadata representation, making the container flexible and extensible.

### BeanFactory or ApplicationContext?

- **ApplicationContext**: It includes all the functionality of a BeanFactory and is generally recommended for common purposes. It provides features like integrated lifecycle management, automatic registration of post-processors, access to MessageSource for internationalization, and more.
- **BeanFactory**: It provides basic bean instantiation and wiring functionalities but lacks advanced features like integrated lifecycle management and automatic registration of post-processors.

### Feature Matrix

| Feature                                | BeanFactory                  | ApplicationContext         |
|----------------------------------------|------------------------------|-----------------------------|
| Bean instantiation/wiring              | Yes                          | Yes                         |
| Integrated lifecycle management        | No                           | Yes                         |
| Automatic BeanPostProcessor registration | No                         | Yes                         |
| Automatic BeanFactoryPostProcessor registration | No                    | Yes                         |
| Convenient MessageSource access        | No                           | Yes                         |
| Built-in ApplicationEvent publication mechanism | No                    | Yes                         |

In summary, while BeanFactory provides basic IoC functionality, ApplicationContext offers additional features like integrated lifecycle management and automatic registration of post-processors, making it the preferred choice for most scenarios.


Read here for more https://docs.spring.io/spring-framework/reference/index.html