package com.deepaksp.rabbitmq.publishersubscriber.threads;

public class QueueRunnable {

    public static void main(String[] args) {
        Thread subscriber = new Thread(new RecvRunnable());
        Thread producer = new Thread(new SendRunnable());
        subscriber.run();
        producer.run();
    }
}
