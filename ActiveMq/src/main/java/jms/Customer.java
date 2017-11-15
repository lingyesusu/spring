package jms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Customer {

	
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:customer.xml");

	}

}
