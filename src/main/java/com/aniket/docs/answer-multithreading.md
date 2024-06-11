

## Multithreading

1. **Multithreading vs Multiprocessing vs Multiprogramming vs Multitasking?**

    - **Multithreading**: Multithreading refers to the ability of a CPU (or a single core) to execute multiple threads concurrently. Threads share the same memory space and resources, allowing for better resource utilization and responsiveness in applications.

    - **Multiprocessing**: Multiprocessing involves the use of multiple CPUs or CPU cores to execute multiple processes concurrently. Each process has its own memory space, and communication between processes is typically achieved through inter-process communication (IPC).

    - **Multiprogramming**: Multiprogramming involves the execution of multiple programs (or processes) concurrently, where each program takes turns using the CPU. The CPU switches rapidly between programs to give the illusion of parallel execution.

    - **Multitasking**: Multitasking is a broader concept that encompasses both multiprogramming and multithreading. It refers to the ability of an operating system to execute multiple tasks (programs, processes, or threads) concurrently, allowing users to run multiple applications simultaneously.

2. **Life cycle of a Thread?**

   The life cycle of a thread in Java consists of the following states:

    - **New**: The thread is in this state before it is started using the `start()` method.
    - **Runnable**: The thread is in this state after it has been started and is ready to run. It may be running or waiting for CPU time.
    - **Blocked/Waiting**: The thread is in this state when it is waiting for a monitor lock, I/O operation, or another condition to be satisfied.
    - **Timed Waiting**: The thread is in this state when it calls methods like `sleep()` or `join()` with a specified timeout.
    - **Terminated**: The thread is in this state when it has completed execution or has been terminated.

3. **Extends vs Runnable?**

    - **Extends Thread**: When a class extends the `Thread` class, it becomes a thread itself. This approach is suitable when you need to override some methods of the `Thread` class or when the class is tightly coupled with the thread's behavior.

    - **Implements Runnable**: When a class implements the `Runnable` interface, it can be executed by a thread. This approach is more flexible because the class is not limited by inheritance constraints. It's recommended to use `Runnable` for better design and code maintainability.

4. **`yield()` vs `sleep()` vs `join()`?**

    - **`yield()`**: The `yield()` method causes the currently executing thread to pause temporarily and allow other threads of the same priority to execute. It's a hint to the scheduler that the current thread is willing to yield its current use of the processor.

    - **`sleep()`**: The `sleep()` method causes the currently executing thread to pause for a specified amount of time. It does not release any locks or monitor resources, allowing other threads to continue their execution.

    - **`join()`**: The `join()` method allows one thread to wait for the completion of another thread. It's often used to ensure that the main thread waits for all worker threads to finish before continuing its execution.

5. **`wait()` vs `sleep()`?**

    - **`wait()`**: The `wait()` method is a part of the `Object` class and is used for inter-thread communication in Java. It releases the lock on the object and causes the current thread to wait until another thread notifies it.

    - **`sleep()`**: The `sleep()` method is a static method of the `Thread` class and is used to pause the execution of the current thread for a specified amount of time. Unlike `wait()`, it does not release the lock on the object.

6. **Why is the `join()` method used?**

   The `join()` method is used to wait for the completion of another thread. It allows the current thread to wait until the thread on which `join()` is called completes its execution. This is useful when you need to ensure that certain tasks are completed before proceeding with further execution.

7. **Can we Override `start()` method in Thread?**

   No, we should not override the `start()` method in the `Thread` class. The `start()` method is a final method in the `Thread` class that is responsible for starting the execution of the thread. Overriding it could lead to unexpected behavior or errors.

8. **Can we Override `run()` method?**

   Yes, we can override the `run()` method in Java. The `run()` method is the entry point for the thread's execution, and we often override it to provide the thread's behavior. When we start a thread, its `run()` method is called automatically by the JVM.

9. **Can we start the thread twice?**

   No, a thread cannot be started twice. Attempting to start a thread that has already been started will result in an `IllegalThreadStateException`.

10. **What is IllegalThreadStateException?**

    `IllegalThreadStateException` is an exception thrown to indicate that a thread is in an illegal state for the requested operation. For example, attempting

to start a thread that has already been started or attempting to resume a thread that is not suspended will result in this exception.

11. **What happens if the `run()` method is called without `start()`?**

    If the `run()` method is called directly without invoking `start()`, it will execute in the context of the current thread just like any other method call. However, it will not create a new thread of execution. This approach does not provide the benefits of multithreading and is not recommended for creating new threads.

12. **Why do we use ThreadPool?**

    ThreadPool is used to manage a pool of worker threads, allowing for efficient reuse of threads and better resource management. It helps in reducing the overhead of thread creation and destruction, improves the responsiveness of applications, and prevents resource exhaustion in highly concurrent environments.

13. **What is Race Condition?**

    A race condition occurs when the outcome of a program depends on the sequence or timing of uncontrollable events. It arises in multithreaded or distributed systems when multiple threads or processes access shared resources concurrently and at least one of the accesses is a write operation.

14. **What is Synchronization? Types of Synchronization?**

    Synchronization in Java is the process of controlling access to shared resources by multiple threads to avoid race conditions and maintain data consistency. There are two types of synchronization:

    - **Method-level synchronization**: Synchronizing the entire method using the `synchronized` keyword, which ensures that only one thread can execute the synchronized method at a time.

    - **Block-level synchronization**: Synchronizing a specific block of code using the `synchronized` keyword, which allows fine-grained control over synchronization and reduces contention.

15. **Object Level Locking vs Class Level Locking?**

    - **Object Level Locking**: In object-level locking, the lock is acquired on the object instance. Each instance of the class has its own lock, allowing multiple threads to execute different synchronized methods of the same object simultaneously.

    - **Class Level Locking**: In class-level locking, the lock is acquired on the class object (represented by `ClassName.class`). Only one thread can acquire the lock on the class object at a time, preventing concurrent execution of synchronized static methods of the class.

16. **If there are 2 synchronized methods m1 and m2 in a class, can 2 different threads t1 and t2 call different methods(m1,m2) respectively on the same object of class c at the same time?**

    Yes, 2 different threads `t1` and `t2` can call different synchronized methods `m1` and `m2` respectively on the same object of class `c` at the same time. This is because synchronized methods lock on the object instance (`this`) rather than the entire class, allowing concurrent execution of different synchronized methods on the same object by different threads.

17. **If a class has a synchronized method and non-synchronized method, can multiple threads execute non-synchronized methods?**

    Yes, multiple threads can execute non-synchronized methods of a class concurrently, even if the class has synchronized methods. Synchronization only applies to synchronized methods or blocks and does not prevent concurrent execution of non-synchronized methods.

18. **Can 2 threads call 2 different static synchronized methods of the same class?**

    No, 2 threads cannot call 2 different static synchronized methods of the same class simultaneously. Static synchronized methods use the class object as the lock, and only one thread can acquire the lock on the class object at a time, preventing concurrent execution of static synchronized methods.

19. **Does static synchronized methods block non-synchronized methods?**

    No, static synchronized methods do not block non-synchronized methods. Synchronization only affects synchronized methods or blocks, and non-synchronized methods can be executed concurrently by multiple threads even if there are static synchronized methods in the class.

20. **Can Constructors be synchronized?**

    Yes, constructors can be synchronized in Java. Synchronizing a constructor ensures that only one thread can execute the constructor at a time, preventing multiple threads from creating instances of the class concurrently. However, synchronizing constructors should be used judiciously to avoid deadlock or performance issues.

21. **What is Deadlock?**

    Deadlock is a situation in which two or more threads are waiting indefinitely for each other to release resources that they need to proceed. As a result, none of the threads can make progress, and the application may become unresponsive or hang.

22. **What is Inter thread communication? Explain `wait()`, `notify()`, and `notifyall()`?**

    Inter-thread communication is a mechanism that allows threads to communicate and synchronize their actions. In Java, inter-thread communication is achieved using the `wait()`, `notify()`, and `notifyAll()` methods of the `Object` class:

    - **`wait()`**: Causes the current thread to wait until another thread invokes the `notify()` or `notifyAll()` method for the same object.

    - **`notify()`**: Wakes up a single thread that is waiting on the object's monitor. If multiple threads are waiting, it is not specified which one will be awakened.

    - **`notifyAll()`**: Wakes up all threads that are waiting on the object's monitor. The highest priority thread will run first.

23.

**What is IllegalMonitorStateException?**

    `IllegalMonitorStateException` is an exception thrown to indicate that a thread has attempted to wait, notify, or notifyAll on an object without owning the object's monitor (i.e., without holding the object's lock). This typically occurs when `wait()`, `notify()`, or `notifyAll()` is called outside a synchronized block or method.

24. **Which class do `wait()`, `notify()`, and `notifyall()` method belong to?**

    `wait()`, `notify()`, and `notifyAll()` methods belong to the `Object` class in Java. Every object in Java has these methods because they are used for inter-thread communication and synchronization.

25. **Explain a few Thread class methods? Is `sleep()` a method in Thread class or Object class?**

    - **`start()`:** Starts the execution of the thread by calling its `run()` method.
    - **`run()`:** Entry point for the thread's execution. Override this method to provide the thread's behavior.
    - **`sleep(long millis)`:** Causes the currently executing thread to sleep (pause) for the specified number of milliseconds. It's a static method of the `Thread` class.

26. **Producer-Consumer Problem in Java?**

    The producer-consumer problem is a classic synchronization problem where there are two types of threads: producers that produce data and put it into a shared buffer, and consumers that consume data from the buffer. The challenge is to ensure that producers do not produce data when the buffer is full and consumers do not consume data when the buffer is empty, while avoiding race conditions and deadlocks.

27. **Volatile vs Synchronized?**

    - **Volatile**: The `volatile` keyword in Java is used to indicate that a variable's value may be modified by multiple threads and ensures visibility of changes made by one thread to other threads. However, it does not provide atomicity or mutual exclusion.

    - **Synchronized**: Synchronization in Java is achieved using the `synchronized` keyword, which ensures mutual exclusion and visibility of changes across threads. It provides both atomicity and mutual exclusion but can introduce contention and performance overhead.

28. **What are Atomic variables?**

    Atomic variables in Java are special types of variables that support atomic operations without requiring explicit synchronization. They provide thread-safe access to their values and ensure that operations performed on them are atomic. Examples include `AtomicInteger`, `AtomicLong`, `AtomicReference`, etc. They are typically used in scenarios where multiple threads access and modify shared variables concurrently.