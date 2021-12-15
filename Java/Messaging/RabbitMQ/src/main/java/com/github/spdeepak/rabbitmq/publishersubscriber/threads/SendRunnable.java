package com.github.spdeepak.rabbitmq.publishersubscriber.threads;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SendRunnable implements Runnable {

    private final static String QUEUE_NAME = "hello";

    @Override
    public void run() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            int i = 0;
            while (i < 10) {
                String message1 = "Hello Deepak = " + i;
                channel.basicPublish("", QUEUE_NAME, null, message1.getBytes("UTF-8"));
                System.out.println("Sent Message ==> '" + message1 + "'");
                i++;
                String message2 = "Hello Deepak = " + i;
                channel.basicPublish("", QUEUE_NAME, null, message2.getBytes("UTF-8"));
                System.out.println("Sent Message ==> '" + message2 + "'");
                //Thread.sleep(500);
            }
            channel.close();
            connection.close();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } /*catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
