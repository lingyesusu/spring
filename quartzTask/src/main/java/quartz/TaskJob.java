package quartz;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TaskJob {

    public void job1(){
    	
        System.out.printf("Task: %s, Current time: %s\n", 1, new Date().getTime());
    }

}