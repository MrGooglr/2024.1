package com.aniket.misc.concurrency.usedforsynchronization;

import java.util.concurrent.BrokenBarrierException;

public class CyclicBarrier {

    public static final int MAX_THREAD = 3;

    public static java.util.concurrent.CyclicBarrier cyclicBarrier = new java.util.concurrent.CyclicBarrier(MAX_THREAD);

    public static void main(String[] args) {

        for (int i = 0; i < MAX_THREAD; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("Waiting at CyclicBarrier "+Thread.currentThread());
                try {
                    /*it is a barrier that all threads must wait at,
                    until all threads reach it,
                    before any of the threads can continue*/
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Done Waiting at CyclicBarrier "+Thread.currentThread());
            });
            thread.start();
        }

    }

}
