package com.aniket.misc.concurrency.usedforsynchronization;

import java.util.concurrent.Semaphore;

public class SemaphoreMultiThreading {

    //Resource that needs fine-grained control over multiple Threads
    public static int resource = 0;

    //Create a semaphore
    //A Semaphore with a count of 2 means that two threads can acquire the semaphore concurrently.
    public static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {


        Thread incrementTheResource = new Thread(() -> {
            try {
                semaphore.acquire();
                //Thread.sleep(1000);
                resource++;
                System.out.println("Resource increment : "+resource);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                semaphore.release();
            }
        });

        Thread decrementCounter = new Thread(() -> {
            try {
                semaphore.acquire();
                resource--;
                System.out.println("Resource decrement : "+resource);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
             semaphore.release();
            }
        });

        incrementTheResource.start();
        decrementCounter.start();

    }

}
