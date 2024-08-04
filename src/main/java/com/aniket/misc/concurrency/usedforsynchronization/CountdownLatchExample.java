package com.aniket.misc.concurrency.usedforsynchronization;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchExample {

    public static final int MAX_THREADS = 3;

    public static final CountDownLatch countDownLatchFinish = new CountDownLatch(MAX_THREADS);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < MAX_THREADS; i++) {
            Thread thread = new Thread(new WorkerThread(countDownLatchFinish));
            thread.start();
        }

        //wait untill all it's workers complete work with countdown() awaiting its countdown to zero.
        countDownLatchFinish.await();
        System.out.println("All workers finished the work");
    }

    static class WorkerThread implements Runnable{

        CountDownLatch countDownLatchFinish;

        public WorkerThread(CountDownLatch countDownLatchFinish) {
            this.countDownLatchFinish = countDownLatchFinish;
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread is working "+Thread.currentThread().getName());
                Thread.sleep(100);
                System.out.println("Thread finished "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                // with each countdown it will decrement the counter till it reaches zero
                countDownLatchFinish.countDown();
            }
        }
    }


}
