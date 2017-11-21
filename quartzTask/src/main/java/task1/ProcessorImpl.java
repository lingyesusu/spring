package task1;

import org.springframework.core.task.TaskExecutor;

import service.Service;

/**
 * �������ӿ�ʵ����
 */
public class ProcessorImpl {

	//ִ����
	private TaskExecutor taskExecutor;

	//ҵ��ӿ�
	private Service service;

	public void process() {
		// ʹ�ö��̴߳���
		taskExecutor.execute(new Runnable() {
			public void run() {
				try {
					// ҵ����
					String say = service.say();
					System.out.println(say);
				} catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
			}
		});
	}

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
}