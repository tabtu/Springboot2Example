package com.iqvia.bhc.tab.service;

import java.util.Calendar;

import org.quartz.Job;

/**
 * Quartz Service
 * @author TabTu
 */
public interface QuartzService {
	
	/**
	 * Schedule a new print task with 'cron' expression.
	 * @param jobBeanClass quartz bean class
	 * @param cron schedule plan
	 * @param data message content
	 * @return
	 */
	String scheduleJob(Class<? extends Job> jobBeanClass, String cron, String data);

	
    /**
     * Schedule a new print task with calendar.
     * @param jobBeanClass quartz bean class
     * @param calendar scheduled time
     * @param data message content
     * @return
     */
    String scheduleJobWithCalendar(Class<? extends Job> jobBeanClass, Calendar calendar, String data);
	
}
