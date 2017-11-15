package jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class CustomerMessageListener implements MessageListener{

	public void onMessage(Message message) {
		TextMessage textMessage=(TextMessage) message;
		try {
			System.out.println("接收消息"+textMessage.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
