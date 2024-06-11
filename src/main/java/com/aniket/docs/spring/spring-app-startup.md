## Application Startup Steps

This section outlines the various startup steps that the core container of the Spring Framework is instrumented with. These steps provide insights into the internal workings of the Spring container during application initialization.

### 1. spring.beans.instantiate

- **Description**: Instantiation of a bean and its dependencies.
- **Tags**:
    - `beanName`: The name of the bean.
    - `beanType`: The type required at the injection point.

### 2. spring.beans.smart-initialize

- **Description**: Initialization of SmartInitializingSingleton beans.
- **Tags**:
    - `beanName`: The name of the bean.

### 3. spring.context.annotated-bean-reader.create

- **Description**: Creation of the AnnotatedBeanDefinitionReader.

### 4. spring.context.base-packages.scan

- **Description**: Scanning of base packages.
- **Tags**:
    - `packages`: Array of base packages for scanning.

### 5. spring.context.beans.post-process

- **Description**: Beans post-processing phase.

### 6. spring.context.bean-factory.post-process

- **Description**: Invocation of the BeanFactoryPostProcessor beans.
- **Tags**:
    - `postProcessor`: The current post-processor.

### 7. spring.context.beandef-registry.post-process

- **Description**: Invocation of the BeanDefinitionRegistryPostProcessor beans.
- **Tags**:
    - `postProcessor`: The current post-processor.

### 8. spring.context.component-classes.register

- **Description**: Registration of component classes through `AnnotationConfigApplicationContext#register`.
- **Tags**:
    - `classes`: Array of given classes for registration.

### 9. spring.context.config-classes.enhance

- **Description**: Enhancement of configuration classes with CGLIB proxies.
- **Tags**:
    - `classCount`: Count of enhanced classes.

### 10. spring.context.config-classes.parse

- **Description**: Configuration classes parsing phase with the ConfigurationClassPostProcessor.
- **Tags**:
    - `classCount`: Count of processed classes.

### 11. spring.context.refresh

- **Description**: Application context refresh phase.

These startup steps provide a detailed overview of the internal processes involved in initializing a Spring application context. While the specific details and names of these steps may vary and are subject to change, understanding their general flow is essential for understanding Spring application startup.

Read here for more https://docs.spring.io/spring-framework/reference/index.html