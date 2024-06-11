

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