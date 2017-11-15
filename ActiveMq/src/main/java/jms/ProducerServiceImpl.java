package jms;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

@SuppressWarnings("restriction")
public class ProducerServiceImpl implements ProducerService{

	@Autowired
	private JmsTemplate jmsTemplate;
	@Resource(name="queueDestination")
	private Destination destination;
	
	public void sendMessage(final String  message){
		//ʹ��JmsTemplate������Ϣ
		jmsTemplate.send(destination, new MessageCreator() {
			//����һ����Ϣ
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage=session.createTextMessage(message);
				return textMessage;
			}
		});
		System.out.println("������Ϣ"+message);
	}
	
}
