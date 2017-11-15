package com.spring.exchange.direct;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProducerMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("direct/producer.xml");
        AmqpTemplate template1 = (AmqpTemplate) context.getBean("rabbitTemplate1");
        AmqpTemplate template2 = (AmqpTemplate) context.getBean("rabbitTemplate2");
        for (int i = 0; i < 20; i++) {
            System.out.println("Sending message #" + i);
            Spittle spittle = new Spittle((long) i, "Hello world (" + i + ")", new Date());
            if(i%2==0){
            	template1.convertAndSend(spittle);
            }else{
            	template2.convertAndSend(spittle);
            }
            Thread.sleep(5000);
        }
        System.out.println("Done!");
    }
}