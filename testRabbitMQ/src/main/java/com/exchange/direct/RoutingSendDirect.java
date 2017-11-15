package com.exchange.direct;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 场景4：Routing (按路线发送接收) 使用场景：发送端按routing key发送消息，不同的接收端按不同的routing key接收消息。
 * 
 * 发送端和场景3的区别： 
 * 1、exchange的type为direct 
 * 2、发送消息的时候加入了routing key 
 * 
 * 接收端和场景3的区别：
 * 在绑定queue和exchange的时候使用了routing key，即从该exchange上只接收routing key指定的消息。
 */

public class RoutingSendDirect {
	private static final String EXCHANGE_NAME = "direct_logs";
	// 路由关键字
	private static final String[] routingKeys = new String[] { "info", "warning", "error" };

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		// 声明交换机
		channel.exchangeDeclare(EXCHANGE_NAME, "direct");// 注意是direct
		// 发送信息
		for (String routingKey : routingKeys) {
			String message = "RoutingSendDirect Send the message level:" + routingKey;
			channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
			System.out.println("RoutingSendDirect Send" + routingKey + "':'" + message);
		}
		channel.close();
		connection.close();
	}
}