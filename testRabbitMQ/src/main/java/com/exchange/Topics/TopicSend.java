package com.exchange.Topics;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 场景5：
 * Topics (按topic发送接收) 
 * 使用场景：
 * 发送端不只按固定的routing key发送消息，而是按字符串“匹配”发送，接收端同样如此。
 * 
 * 发送端和场景4的区别：
 *  1、exchange的type为topic 
 *  2、发送消息的routing key不是固定的单词，而是匹配字符串，如"*.lu.#"，*匹配一个单词，#匹配0个或多个单词。 
 *  
 * 收端和场景4的区别：
 * 1、exchange的type为topic 
 * 2、接收消息的routing key不是固定的单词，而是匹配字符串。
 */

public class TopicSend {
	private static final String EXCHANGE_NAME = "topic_logs";

	public static void main(String[] args) throws IOException, TimeoutException {
		Connection connection = null;
		Channel channel = null;
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			connection = factory.newConnection();
			channel = connection.createChannel();

			// 声明一个匹配模式的交换机
			channel.exchangeDeclare(EXCHANGE_NAME, "topic");
			// 待发送的消息
			String[] routingKeys = new String[] { "quick.orange.rabbit",
												"lazy.orange.elephant", "quick.orange.fox",
												"lazy.brown.fox", "quick.brown.fox",
												"quick.orange.male.rabbit", "lazy.orange.male.rabbit" };
			// 发送消息
			for (String severity : routingKeys) {
				String message = "From " + severity + " routingKey' s message!";
				channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
				System.out.println("TopicSend Sent '" + severity + "':'" + message + "'");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (connection != null) {
				channel.close();
				connection.close();
			}
		} finally {
			if (connection != null) {
				channel.close();
				connection.close();
			}
		}
	}
}