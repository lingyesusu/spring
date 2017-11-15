package com.queue.onetomany;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * 场景2：单发送多接收 
 * 使用场景：一个发送端，多个接收端，如分布式的任务派发。为了保证消息发送的可靠性，不丢失消息，使消息持久化了。
 * 同时为了防止接收端在处理消息时down掉 ，只有在消息处理完成后才发送ack消息。
 * 
 * 发送端和场景1不同点： 
 * 1、使用“task_queue”声明了另一个Queue，因为RabbitMQ不容许声明2个相同名称、配置不同的Queue
 * 2、使"task_queue"的Queue的durable的属性为true，即使消息队列durable
 * 3、使用MessageProperties.PERSISTENT_TEXT_PLAIN使消息durable
 * 
 * 接收端和场景1不同点： 
 * 1、使用“task_queue”声明消息队列，并使消息队列durable
 * 2、在使用channel.basicConsume接收消息时使autoAck为false，即不自动会发ack，由channel.basicAck()在消息处理完成后发送消息。
 * 3、使用了channel.basicQos(1)保证在接收端一个消息没有处理完时不会接收另一个消息，即接收端发送了ack后才会接收下一个消息。在这种情况下发送端会尝试把消息发送给下一个not busy的接收端。
 */

public class NewTask {
	private static final String TASK_QUEUE_NAME = "task_queue";

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
		// 分发信息
		for (int i = 0; i < 10; i++) {
			String message = "Hello RabbitMQ" + i;
			channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
			System.out.println("NewTask send '" + message + "'");
		}
		channel.close();
		connection.close();
	}
}