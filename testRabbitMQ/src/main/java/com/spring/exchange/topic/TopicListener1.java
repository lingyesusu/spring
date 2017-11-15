package com.spring.exchange.topic;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class TopicListener1 implements MessageListener {
    public void onMessage(Message message) {
        try {
            String body=new String(message.getBody(),"UTF-8");
            System.out.println("TopicListener1:"+body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}