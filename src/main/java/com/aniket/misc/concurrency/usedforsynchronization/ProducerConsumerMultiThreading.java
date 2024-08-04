package com.aniket.misc.concurrency.usedforsynchronization;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerMultiThreading {

    public static Queue<Double> queue = new LinkedList<>();
    private static final int MAX_SIZE = 5;
    public static void main(String[] args) {
        //need to start two threads one producer thread
        // one consumer thread

        Thread producer = new Thread(() -> {
            while (true){
                produce();
            }
        });

        Thread consumer = new Thread(() -> {
            while (true){
                consume();
            }
        });

        producer.start();
        consumer.start();

    }

    public static void produce(){
        while(queue.size() == MAX_SIZE){
            try {
                queue.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            queue.offer(Math.random()*100);
            queue.notifyAll();
        }
    }

    public static void consume(){
        while(queue.isEmpty()){
            try {
                queue.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(queue.poll());
        queue.notifyAll();

    }

}
