package com.iqvia.bhc.tab.task;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import com.iqvia.bhc.tab.utils.Convertor;

/**
 * Job to print the message on Console
 * @author TabTu
 */
public class PrintJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        String message = jobExecutionContext.getJobDetail().getJobDataMap().get("data").toString();
        String now = Convertor.DateToString(new Date());
        
        System.out.println(now + " : " + message);
    }
}
