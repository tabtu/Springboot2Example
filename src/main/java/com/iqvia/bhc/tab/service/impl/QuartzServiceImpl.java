package com.iqvia.bhc.tab.service.impl;

import java.util.Calendar;
import java.util.UUID;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
//import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
//import org.quartz.TriggerKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqvia.bhc.tab.service.QuartzService;

/**
 * Quartz Service Implement
 * @author TabTu
 */

@Service
public class QuartzServiceImpl implements QuartzService {

	private static final Logger log = LoggerFactory.getLogger(ScheduleTaskServiceImpl.class);
	
	private String iqviaQuartzGroup = "iqviaQuartzGroup";

    @Autowired
    private Scheduler iqviaClusterScheduler;
    
	@Override
    public String scheduleJob(Class<? extends Job> jobBeanClass, String cron, String data) {
		// random UUID for job name
		String jobName = UUID.randomUUID().toString();
        JobDetail jobDetail = JobBuilder.newJob(jobBeanClass)
                .withIdentity(jobName, iqviaQuartzGroup)
                .usingJobData("data", data)
                .build();
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity(jobName, iqviaQuartzGroup)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
        try {
        	iqviaClusterScheduler.scheduleJob(jobDetail, cronTrigger);
        } catch (SchedulerException e) {
        	log.error(e.getMessage());
        }
        return jobName;
    }

    @Override
    public String scheduleJobWithCalendar(Class<? extends Job> jobBeanClass, Calendar calendar, String data) {
    	// convert a calendar to cron format
    	String startCron = String.format("%d %d %d %d %d ? %d",
    		  calendar.get(Calendar.SECOND), 
    		  calendar.get(Calendar.MINUTE),
    		  calendar.get(Calendar.HOUR_OF_DAY),
    		  calendar.get(Calendar.DAY_OF_MONTH),
    		  calendar.get(Calendar.MONTH) + 1,
    		  calendar.get(Calendar.YEAR));
        return scheduleJob(jobBeanClass, startCron, data);
    }
}
