package com.spring.exchange.topic;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProducerMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"topic/producer.xml");
		RabbitTemplate rabbitTemplate = (RabbitTemplate) context
				.getBean("rabbitTemplate");
		// 第二个参数为路由key(routingKey)的值，当路由可以为test321.hello.test123时，两个消费队列都可以收到消息，当值为test321.hello.aaa时，只有绑定了test321.#的队列才可以收到消息，当值为ta1.hello.test123，只有绑定了*.*.test123的队列才可收到消息
		for (int i = 1; i <= 10; i++) {
			String str = "hello" + i;
			rabbitTemplate.send("leo.pay.topic.exchange", "test321.hello.test123", new Message(str.getBytes(),new MessageProperties()));
		}
		for (int i = 1; i <= 10; i++) {
			String str = "hello" + i;
			rabbitTemplate.send("leo.pay.topic.exchange", "test321.hello.aaa", new Message(str.getBytes(),new MessageProperties()));
		}
	}
}