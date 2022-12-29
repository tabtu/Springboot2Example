package com.iqvia.bhc.tab.service;

import java.util.Calendar;

import org.quartz.Job;

/**
 * @author TabTu
 *
 */
public interface QuartzService {
	
	/**
	 * @param jobBeanClass
	 * @param cron
	 * @param data
	 * @return
	 */
	String scheduleJob(Class<? extends Job> jobBeanClass, String cron, String data);

	
    /**
     * @param jobBeanClass
     * @param calendar
     * @param data
     * @return
     */
    String scheduleJobWithCalendar(Class<? extends Job> jobBeanClass, Calendar calendar, String data);
	
}
