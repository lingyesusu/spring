package com.spring.exchange.fanout;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class FanoutListener1 implements MessageListener {
    public void onMessage(Message message) {
        try {
            String body=new String(message.getBody(),"UTF-8");
            System.out.println("FanoutListener1:"+body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}