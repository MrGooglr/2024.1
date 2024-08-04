

## Concurrency

1. **Runnable vs Callable?**

    - **Runnable**: `Runnable` is a functional interface in Java that represents a task that can be executed concurrently. It has a single method `run()` that does not return any value. Runnable tasks are typically used with the `Thread` class or `ExecutorService` to execute code concurrently.

    - **Callable**: `Callable` is a functional interface in Java similar to `Runnable`, but it allows the task to return a result and throw checked exceptions. It has a single method `call()` that returns a result of a specified type (`V`). Callables are used with the `ExecutorService` interface, and the result of the `call()` method can be obtained through a `Future` object.

2. **What is a Future Object?**

   A `Future` object represents the result of an asynchronous computation. It provides a way to check if the computation is complete, retrieve the result of the computation (if it is complete), and cancel the computation if desired. `Future` objects are typically returned by methods of the `ExecutorService` interface when submitting tasks for execution.

3. **What is CompletableFuture?**

   `CompletableFuture` is a class introduced in Java 8 that represents a future result of an asynchronous computation that may be explicitly completed (setting its value and completion status). It provides a wide range of methods for composing, combining, and handling asynchronous computations, such as `thenApply()`, `thenAccept()`, `thenCombine()`, etc.

4. **Use of `Done()`, `IsCancelled()`, and `Cancel()` method of Future Object?**

    - **`isDone()`:** Returns `true` if the computation represented by the `Future` object has completed, either normally or abnormally (due to cancellation or failure), and `false` otherwise.

    - **`isCancelled()`:** Returns `true` if the computation represented by the `Future` object was cancelled before it completed normally, and `false` otherwise.

    - **`cancel(boolean mayInterruptIfRunning)`:** Attempts to cancel the computation represented by the `Future` object. If the computation has not started yet, it will be cancelled, and the method will return `true`. If the computation has already started and `mayInterruptIfRunning` is `true`, the thread executing the computation will be interrupted, and the method will return `true`. If `mayInterruptIfRunning` is `false` and the computation has already started, it will not be cancelled, and the method will return `false`.

5. **Explain ThreadLocal class?**

   `ThreadLocal` is a class in Java that provides thread-local variables. Each thread accessing a `ThreadLocal` variable has its own independently initialized copy of the variable. `ThreadLocal` is typically used to store thread-specific data, such as user sessions, database connections, or transaction contexts, without explicitly passing them to methods or synchronizing access.

6. **What is CountDownLatch?**

   `CountDownLatch` is a synchronization aid in Java that allows one or more threads to wait until a set of operations being performed in other threads completes. It consists of a count that is decremented each time a thread completes an operation, and threads waiting for the count to reach zero are blocked until it does. Once the count reaches zero, the waiting threads are released.

7. **What is CyclicBarrier?**

   `CyclicBarrier` is another synchronization aid in Java that allows a fixed number of threads to wait for each other to reach a common barrier point before proceeding. Unlike `CountDownLatch`, which is used for one-time synchronization, `CyclicBarrier` can be reused for subsequent synchronization points. Once all threads have reached the barrier, the barrier is reset, and the threads can proceed.

8. **What is ReEntrant lock?**

   `ReentrantLock` is a synchronization mechanism in Java that provides the same basic functionality as `synchronized` blocks but with more advanced features. It allows locking and unlocking of critical sections of code, supports fairness policies for thread scheduling, and provides more flexible locking mechanisms, such as condition variables.

9. **ExecutorService.submit() vs Executor.execute()?**

    - **`submit()`:** The `submit()` method of `ExecutorService` is used to submit a task for execution and returns a `Future` object representing the result of the task. It is suitable for tasks that produce a result or throw exceptions.

    - **`execute()`:** The `execute()` method of `ExecutorService` is used to submit a task for execution without expecting a result. It is suitable for tasks that do not produce a result or throw exceptions.

10. **Different types of ThreadExecutor Services?**

    There are several types of thread executor services in Java, including:

    - **SingleThreadExecutor**: Executes tasks sequentially using a single worker thread.
    - **FixedThreadPool**: Executes tasks using a fixed number of worker threads.
    - **CachedThreadPool**: Creates new worker threads as needed and reuses existing ones when available.
    - **ScheduledThreadPool**: Executes tasks at a scheduled time or with a delay.

11. **Explain how FixedThreadPool executor works?**

    In a `FixedThreadPool`, a fixed number of worker threads are created when the pool is created. Tasks submitted to the pool are assigned to these worker threads for execution. If all the worker threads are busy when a task is submitted, the task is placed in a queue until a worker thread becomes available. Once a worker thread completes a task, it picks up the next task from the queue (if any). The number of worker threads in the pool remains constant, and excess tasks are queued until a worker thread becomes available.

java.util.concurrent package provides a powerful framework for managing concurrent tasks in Java. It includes classes like `ExecutorService`, `Future`, `CompletableFuture`, `ThreadLocal`, `CountDownLatch`, `CyclicBarrier`, `ReentrantLock`, etc., that help in writing efficient and scalable concurrent programs.

java.util.function package provides functional interfaces like `Runnable`, `Callable`, `Supplier`, `Consumer`, `Function`, etc., that are used in conjunction with the concurrent classes to define and execute tasks concurrently.

java.util.* package provides a wide range of utility classes and interfaces that are used in concurrent programming, such as `Collections`, `Arrays`, `Map`, `List`, `Set`, `Queue`, etc.

---

In Java, when dealing with threads, `thread.start()` and `thread.run()` are two methods used to begin the execution of a thread, but they differ significantly in their functionality and purpose:

### 1. `thread.start()`
- **Purpose:** Used to start a new thread of execution, which invokes the `run()` method of the thread.
- **Functionality:**
    - **Creates a New Thread:** When `thread.start()` is called, a new thread is created and its lifecycle begins.
    - **Concurrency:** The `run()` method of the thread runs concurrently in a separate call stack.
    - **Asynchronous Execution:** `start()` returns immediately after starting the thread, allowing the calling thread to continue executing independently.
    - **Thread Safety:** Ensures proper thread lifecycle management and safe concurrent execution of multiple threads.

- **Example:**
  ```java
  Thread thread = new Thread(() -> {
      System.out.println("Thread running: " + Thread.currentThread().getName());
  });
  thread.start(); // Starts a new thread and executes the lambda in its own context
  ```

### 2. `thread.run()`
- **Purpose:** Directly calls the `run()` method of the thread in the current thread's context, without starting a new thread.
- **Functionality:**
    - **Runs Sequentially:** Executes the `run()` method synchronously in the current thread, without any concurrency.
    - **No New Thread:** Does not create a new thread; instead, it runs in the current thread's stack.
    - **Blocking:** `run()` method runs to completion before the control returns to the caller, blocking further execution until it finishes.
    - **No Thread Safety:** Since it runs synchronously in the current thread, it does not provide concurrency benefits or thread safety.

- **Example:**
  ```java
  Thread thread = new Thread(() -> {
      System.out.println("Thread running: " + Thread.currentThread().getName());
  });
  thread.run(); // Executes the run method in the current thread context
  ```

### Key Differences:
- **Concurrency:** `start()` creates a new thread and runs `run()` concurrently, while `run()` executes synchronously in the current thread.
- **New Thread Creation:** `start()` initiates a new thread's lifecycle, whereas `run()` runs in the current thread without starting a new one.
- **Asynchronous vs Synchronous:** `start()` enables asynchronous execution, allowing concurrent operation, while `run()` is synchronous and blocks further execution until completion.
- **Thread Safety:** `start()` ensures proper thread management and concurrency control, providing thread safety, whereas `run()` runs in a single thread context and does not offer concurrency benefits.

### When to Use Each:
- **Use `thread.start()`**:
    - When you need concurrent execution or want to leverage multi-threading for parallel tasks.
    - When the thread's execution should not block the caller's thread.

- **Use `thread.run()`**:
    - When you want to execute the thread's logic in a synchronous manner within the current thread's context.
    - Useful for sequential execution or testing purposes where multi-threading is not required.

In summary, `thread.start()` and `thread.run()` serve different purposes: `start()` initiates a new thread for concurrent execution, while `run()` directly executes the thread's logic in the current thread's context synchronously.