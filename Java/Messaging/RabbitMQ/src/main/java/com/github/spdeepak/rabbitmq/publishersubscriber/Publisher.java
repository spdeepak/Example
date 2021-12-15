package com.github.spdeepak.rabbitmq.publishersubscriber;

import com.deepaksp.rabbitmq.object.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Publisher {

	private final static String QUEUE_NAME = "hello";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection();
			 Channel channel = connection.createChannel()) {

			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			for (int i = 0; i < 100; i++) {
				Car car = new Car(Long.valueOf(i), "Tiago", "Maruti");
				String message = new ObjectMapper().writeValueAsString(car);
				channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
				System.out.println(" [x] Sent '" + message + "'");
				Thread.sleep(100);
			}
		}
	}
}
