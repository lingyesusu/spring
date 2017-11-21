package task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import task1.ProcessorImpl;

public class this1 {
	
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/MyXml1.xml");
        ProcessorImpl processorImpl = context.getBean(ProcessorImpl.class);
        processorImpl.process();
    }

}
