### 1. Java program to create and start multiple threads that increment a shared counter variable concurrently

```java
public class SharedCounter {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        int numThreads = 5;
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    synchronized (SharedCounter.class) {
                        counter++;
                    }
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Counter value: " + counter);
    }
}
```

**Explanation:**
- `SharedCounter` class demonstrates multiple threads incrementing a shared `counter` variable (`counter++` operation).
- Each thread runs a loop (`for (int j = 0; j < 1000; j++)`) and increments the counter inside a synchronized block to ensure thread safety.
- `synchronized (SharedCounter.class)` ensures that only one thread can execute the critical section (increment operation) at a time, preventing data corruption.

### 2. Java program to create a producer-consumer scenario using the wait() and notify() methods for thread synchronization

```java
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private static final Queue<Integer> queue = new LinkedList<>();
    private static final int MAX_SIZE = 5;

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            while (true) {
                produce();
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                consume();
            }
        });

        producer.start();
        consumer.start();
    }

    private static void produce() {
        synchronized (queue) {
            while (queue.size() == MAX_SIZE) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int item = (int) (Math.random() * 100);
            queue.offer(item);
            System.out.println("Produced: " + item);
            queue.notifyAll();
        }
    }

    private static void consume() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int item = queue.poll();
            System.out.println("Consumed: " + item);
            queue.notifyAll();
        }
    }
}
```

**Explanation:**
- `ProducerConsumer` class demonstrates a producer-consumer scenario using a shared queue (`queue`).
- `produce()` method adds items to the queue (`queue.offer(item)`) and notifies waiting consumers after producing (`queue.notifyAll()`).
- `consume()` method removes items from the queue (`queue.poll()`) and notifies waiting producers after consuming (`queue.notifyAll()`).
- Both `produce()` and `consume()` methods synchronize on the `queue` object to ensure thread safety and prevent race conditions.

### 3. Java program that uses the ReentrantLock class to synchronize access to a shared resource among multiple threads

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private static int counter = 0;
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        int numThreads = 5;
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    lock.lock();
                    try {
                        counter++;
                    } finally {
                        lock.unlock();
                    }
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Counter value: " + counter);
    }
}
```

**Explanation:**
- `ReentrantLockExample` class demonstrates the use of `ReentrantLock` (`lock`).
- Each thread acquires the lock using `lock.lock()` before accessing the shared `counter` variable.
- The `try-finally` block ensures that the lock is always released (`lock.unlock()`), even if an exception occurs during execution.
- `ReentrantLock` provides more flexibility and features compared to `synchronized` blocks, such as conditions and timeouts.

### 4. Java program to demonstrate Semaphore usage for thread synchronization

```java
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static final Semaphore semaphore = new Semaphore(1);
    private static int sharedResource = 0;

    public static void main(String[] args) {
        Thread incrementThread = new Thread(() -> {
            try {
                semaphore.acquire();
                sharedResource++;
                System.out.println("Incremented: " + sharedResource);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        });

        Thread decrementThread = new Thread(() -> {
            try {
                semaphore.acquire();
                sharedResource--;
                System.out.println("Decremented: " + sharedResource);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        });

        incrementThread.start();
        decrementThread.start();
    }
}
```

**Explanation:**
- `SemaphoreExample` class demonstrates the use of `Semaphore` (`semaphore`) with an initial permit count of 1.
- Threads acquire permits using `semaphore.acquire()` before accessing the `sharedResource` and release permits using `semaphore.release()` after accessing.
- `Semaphore` allows multiple threads to access a shared resource simultaneously up to a specified limit (`1` in this case), providing more fine-grained control than `synchronized` blocks or `ReentrantLock`.

### 5. Java program to showcase the usage of the CyclicBarrier class for thread synchronization

```java
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    private static final int NUM_THREADS = 3;
    private static final CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS);

    public static void main(String[] args) {
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Thread waiting at barrier.");
                    barrier.await(); // Threads wait here until all reach the barrier
                    System.out.println("Thread passed barrier.");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
}
```

**Explanation:**
- `CyclicBarrierExample` class demonstrates the use of `CyclicBarrier` (`barrier`) to synchronize multiple threads.
- Each thread calls `barrier.await()` to wait at the barrier until all threads have reached this point.
- Once all threads have reached the barrier, they are released simultaneously, allowing them to proceed further.
- `CyclicBarrier` is useful for scenarios where you want multiple threads to wait for each other at a predefined point before continuing execution together.

### 6. Java program that uses the CountDownLatch class to synchronize the start and finish of multiple threads

```java
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    private static final int NUM_THREADS = 3;
    private static final CountDownLatch startLatch = new CountDownLatch(1);
    private static final CountDownLatch finishLatch = new CountDownLatch(NUM_THREADS);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread thread = new Thread(new Worker(startLatch, finishLatch));
            thread.start();
        }

        // Start all threads
        startLatch.countDown();

        // Wait for all threads to finish
        finishLatch.await();

        System.out.println("All threads have finished their work.");
    }

    static class Worker implements Runnable {
        private final CountDownLatch startLatch;
        private final CountDownLatch finishLatch;

        public Worker(CountDownLatch startLatch, CountDownLatch finishLatch) {
            this.startLatch = startLatch;
            this.finishLatch = finishLatch;
        }

        @Override
        public void run() {
            try {
                startLatch.await(); // Wait until startLatch countdown reaches zero
                System.out.println(Thread.currentThread().getName() + " is working...");
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println(Thread.currentThread().getName() + " has finished.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                finishLatch.countDown(); // Signal that this thread has finished
            }
        }
    }
}
```

**Explanation:**
- `CountDownLatchExample` demonstrates the use of `CountDownLatch` to synchronize the start and finish of multiple threads (`NUM_THREADS`).
- `startLatch` is used to start all threads simultaneously by awaiting its countdown to zero and then counting down.
- `finishLatch` is used to wait until all threads have finished their execution by awaiting its countdown to zero.
- Each `Worker` thread simulates work by waiting for the `startLatch` and then doing some work (sleeping for a random duration) before counting down on `finishLatch` to signal completion.

### 7. Java program to illustrate the usage of the ReadWriteLock interface for concurrent read-write access to a shared resource

```java
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private static final Map<String, String> map = new HashMap<>();
    private static final ReadWriteLock lock = new ReentrantReadWriteLock();
    private static final Lock readLock = lock.readLock();
    private static final Lock writeLock = lock.writeLock();

    public static void main(String[] args) {
        Runnable writeTask = () -> {
            writeLock.lock();
            try {
                map.put("key1", "value1");
                System.out.println(Thread.currentThread().getName() + " wrote to map.");
                Thread.sleep(1000); // Simulating some write operation time
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
            }
        };

        Runnable readTask = () -> {
            readLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " reading from map: " + map.get("key1"));
                Thread.sleep(500); // Simulating some read operation time
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
        };

        // Start multiple read threads and one write thread
        for (int i = 0; i < 3; i++) {
            new Thread(readTask).start();
        }
        new Thread(writeTask).start();
    }
}
```

**Explanation:**
- `ReadWriteLockExample` demonstrates how to use `ReadWriteLock` (`lock`) and its `readLock` and `writeLock` to achieve concurrent read-write access to a shared resource (`map`).
- Multiple threads (`readTask`) acquire the `readLock` for reading from the map, allowing concurrent access for reading operations.
- One thread (`writeTask`) acquires the `writeLock` for writing to the map, ensuring exclusive access during write operations to maintain data integrity.
- `ReentrantReadWriteLock` optimizes performance by allowing multiple threads to read concurrently while maintaining exclusive write access.

### 8. Java program demonstrating how to access a map concurrently using the ConcurrentHashMap class

```java
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    private static final ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Runnable writeTask = () -> {
            for (int i = 0; i < 5; i++) {
                map.put(String.valueOf(i), i);
                System.out.println(Thread.currentThread().getName() + " wrote: " + i);
                try {
                    Thread.sleep(100); // Simulating some write operation time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable readTask = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " reading: " + map.get(String.valueOf(i)));
                try {
                    Thread.sleep(100); // Simulating some read operation time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Start multiple read and write threads
        Thread writeThread = new Thread(writeTask);
        Thread readThread1 = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);

        writeThread.start();
        readThread1.start();
        readThread2.start();

        writeThread.join();
        readThread1.join();
        readThread2.join();
    }
}
```

**Explanation:**
- `ConcurrentHashMapExample` demonstrates concurrent access to a `ConcurrentHashMap` (`map`) using its thread-safe operations.
- `ConcurrentHashMap` allows multiple threads to read and write concurrently without external synchronization, ensuring thread safety.
- `writeTask` adds elements to the map (`map.put`) and `readTask` reads elements (`map.get`), both with simulated delays to illustrate concurrent operations.
- `ConcurrentHashMap` achieves high concurrency by partitioning the map into segments, allowing multiple threads to modify different segments concurrently.

### 9. Java program that utilizes the ConcurrentLinkedQueue class to implement a thread-safe queue

```java
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {
    private static final ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Runnable producer = () -> {
            for (int i = 0; i < 5; i++) {
                queue.offer(i); // Add elements to the queue
                System.out.println(Thread.currentThread().getName() + " produced: " + i);
                try {
                    Thread.sleep(100); // Simulating some production time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            while (!queue.isEmpty()) {
                Integer element = queue.poll(); // Retrieve and remove elements from the queue
                System.out.println(Thread.currentThread().getName() + " consumed: " + element);
                try {
                    Thread.sleep(100); // Simulating some consumption time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Start producer and consumer threads
        Thread producerThread = new Thread(producer);
        Thread consumerThread1 = new Thread(consumer);
        Thread consumerThread2 = new Thread(consumer);

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();

        producerThread.join();
        consumerThread1.join();
        consumerThread2.join();
    }
}
```

**Explanation:**
- `ConcurrentLinkedQueueExample` demonstrates the use of `ConcurrentLinkedQueue` (`queue`) as a thread-safe queue implementation.
- `ConcurrentLinkedQueue` allows multiple threads to insert (`offer`) and remove (`poll`) elements concurrently without external synchronization.
- `producer` adds elements to the queue, and `consumer` retrieves and processes elements, both with simulated delays to illustrate concurrent operations.
- `ConcurrentLinkedQueue` achieves thread safety and high throughput by using lock-free algorithms, ensuring efficient concurrent access.

### 10. Java program to showcase the usage of the Phaser class for coordination and synchronization of multiple threads

```java
import java.util.concurrent.Phaser;

public class PhaserExample {
    private static final int NUM_THREADS = 3;
    private static final Phaser phaser = new Phaser(NUM_THREADS);

    public static void main(String[] args) {
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread thread = new Thread(new Worker(phaser));
            thread.start();
        }
    }

    static class Worker implements Runnable {
        private final Phaser phaser;

        public Worker(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " starting phase 1");
            phaser.arriveAndAwaitAdvance(); // Wait for all threads to reach this point
            System.out.println(Thread.currentThread().getName() + " starting phase 2");
            phaser.arriveAndAwaitAdvance(); // Wait for all threads to reach this point
            System.out.println(Thread.currentThread().getName() + " starting phase 3");
            phaser.arriveAndDeregister(); // Deregister from phaser
        }
   ```

### 11. Java program that utilizes the Exchanger class for exchanging data between two threads

```java
import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread producer = new Thread(() -> {
            try {
                String data1 = "Data from Producer";
                System.out.println("Producer sending: " + data1);
                String receivedData = exchanger.exchange(data1);
                System.out.println("Producer received: " + receivedData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulating some delay before consuming
                String data2 = "Data from Consumer";
                System.out.println("Consumer sending: " + data2);
                String receivedData = exchanger.exchange(data2);
                System.out.println("Consumer received: " + receivedData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
```

**Explanation:**
- `ExchangerExample` demonstrates how two threads (`producer` and `consumer`) exchange data using `Exchanger`.
- The `Exchanger<String>` facilitates exchanging data of type `String` between two threads using the `exchange` method.
- The `producer` thread sends data (`data1`) and receives data (`receivedData`) from the `consumer` thread, and vice versa.
- `Exchanger` provides a synchronization point where threads wait for each other to exchange data, ensuring coordination between them.

### 12. Java program to demonstrate the usage of the Callable and Future interfaces for executing tasks asynchronously and obtaining their results

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            System.out.println("Task executing...");
            Thread.sleep(2000); // Simulating some task execution time
            return 123;
        };

        Future<Integer> future = executorService.submit(task);

        System.out.println("Waiting for result...");
        Integer result = future.get(); // Blocking call to get the result

        System.out.println("Result received: " + result);

        executorService.shutdown();
    }
}
```

**Explanation:**
- `CallableFutureExample` demonstrates the use of `Callable<Integer>` to represent a task that returns a result (`Integer`).
- `ExecutorService` is used to submit the `Callable` task (`task`) for execution asynchronously.
- `Future<Integer>` represents the result of the asynchronous computation and provides methods to check if the computation is complete (`isDone`) and retrieve the result (`get`).
- The main thread waits for the result using `future.get()`, which blocks until the task completes and returns the result (`123` in this case).
- `Callable` and `Future` interfaces provide a way to execute tasks asynchronously, retrieve results, and handle exceptions that may occur during task execution.

### 13. Java program that uses the ScheduledExecutorService interface to schedule tasks for execution at a specified time or with a fixed delay

```java
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Task executed at: " + System.currentTimeMillis());

        // Execute the task after 2 seconds delay
        executorService.schedule(task, 2, TimeUnit.SECONDS);

        // Execute the task after 1 second initial delay and then every 3 seconds
        executorService.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS);

        // Shutdown the executor after some time
        executorService.schedule(() -> executorService.shutdown(), 10, TimeUnit.SECONDS);
    }
}
```

**Explanation:**
- `ScheduledExecutorServiceExample` demonstrates scheduling tasks using `ScheduledExecutorService`.
- `ScheduledExecutorService` allows scheduling tasks (`Runnable` `task`) to run after a specified delay (`schedule`) or at fixed intervals (`scheduleAtFixedRate`).
- `schedule(task, 2, TimeUnit.SECONDS)` schedules `task` to run once after an initial delay of 2 seconds.
- `scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS)` schedules `task` to run initially after 1 second and then every 3 seconds, regardless of the task execution time.
- `schedule(() -> executorService.shutdown(), 10, TimeUnit.SECONDS)` schedules a task to shutdown the `executorService` after 10 seconds.
- `ScheduledExecutorService` provides flexible scheduling options for executing tasks periodically or with delays.

### 14. Java program to demonstrate the usage of the ForkJoinPool class for parallel execution of recursive tasks

```java
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExample {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        SumTask task = new SumTask(array, 0, array.length);

        int result = forkJoinPool.invoke(task);

        System.out.println("Sum: " + result);
    }

    static class SumTask extends RecursiveTask<Integer> {
        private final int[] array;
        private final int start;
        private final int end;

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= 2) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);
                leftTask.fork();
                int rightResult = rightTask.compute();
                int leftResult = leftTask.join();
                return leftResult + rightResult;
            }
        }
    }
}
```

**Explanation:**
- `ForkJoinPoolExample` demonstrates parallel execution of a recursive task (`SumTask`) using `ForkJoinPool`.
- `ForkJoinPool` divides the task (`SumTask`) into smaller subtasks (`leftTask` and `rightTask`) until each subtask can be executed independently.
- `SumTask` extends `RecursiveTask<Integer>` to compute the sum of elements in the `array` recursively.
- If the task size (`end - start`) is small (`<= 2`), the task computes the sum directly.
- Otherwise, it splits the task into two subtasks (`leftTask` and `rightTask`), forks the `leftTask` for parallel execution, computes the `rightResult` sequentially, and joins (`leftTask.join()`) the `leftResult`.
- `ForkJoinPool` manages thread execution and task scheduling efficiently, utilizing multiple processors for parallel execution of recursive tasks.

### 15. Java program that utilizes the StampedLock class for optimizing concurrent read-write access to a shared resource

```java
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {
    private static final StampedLock lock = new StampedLock();
    private static final Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        Runnable writeTask = () -> {
            long stamp = lock.writeLock();
            try {
                map.put("key1", "value1");
                System.out.println("Write operation performed.");
                Thread.sleep(1000); // Simulating some write operation time
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockWrite(stamp);
            }
        };

        Runnable readTask = () -> {
            long stamp = lock.readLock();
            try {
                System.out.println("Read operation performed: " + map.get("key1"));
                Thread.sleep(500); // Simulating some read operation time
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
            }
        };

        // Start multiple read and write threads
        Thread writeThread = new Thread(writeTask);
        Thread readThread1 = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);

        writeThread.start();
        readThread1.start();
        readThread2.start();
    }
}
```

**Explanation:**
- `StampedLockExample` demonstrates the use of `StampedLock` (`lock`) for optimizing concurrent read-write access to a shared resource (`map`).
- `StampedLock` provides three modes: `readLock()` for shared read access, `writeLock()` for exclusive write access, and optimistic read (`tryOptimisticRead()`).
- `writeTask` acquires a write lock (`lock.writeLock()`) to perform a write operation (`map.put`) and releases the lock (`lock.unlockWrite(stamp)`) afterward.
- `readTask`