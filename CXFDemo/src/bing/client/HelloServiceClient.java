package bing.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bing.server.IHelloService;

/**
 * <p>
 * WebService���÷�-�ͻ���
 * </p>
 * 
 * @author IceWee
 * @date 2012-7-6
 * @version 1.0
 */
public class HelloServiceClient {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-client.xml");
        IHelloService helloService = (IHelloService) context.getBean("client");
        String response = helloService.sayHello("Peter");
        System.out.println(response);
    }

}