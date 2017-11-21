package task1;

import org.springframework.core.task.TaskExecutor;

import service.Service;

/**
 * 处理器接口实现类
 */
public class ProcessorImpl {

	//执行器
	private TaskExecutor taskExecutor;

	//业务接口
	private Service service;

	public void process() {
		// 使用多线程处理
		taskExecutor.execute(new Runnable() {
			public void run() {
				try {
					// 业务处理
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