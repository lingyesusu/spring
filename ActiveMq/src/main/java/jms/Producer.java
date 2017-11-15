package jms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Producer {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:producer.xml");
		ProducerService producerService = context.getBean(ProducerService.class);
		for (int i = 0; i <100; i++) {
			producerService.sendMessage("test"+i);
		}
		context.close();
	}

}
