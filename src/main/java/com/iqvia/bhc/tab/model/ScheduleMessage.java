package com.iqvia.bhc.tab.model;


/**
 * Schedule Message Structure
 * @author TabTu
 */
public class ScheduleMessage {
	/**
	 * the target schedule time for printing the message
	 * example "2022-12-31 12:12:12"
	 */
	public String schedule_time;
	

	/**
	 * the time zone id for trigger time
	 * example "CA"
	 */
	public String time_zone;
	
	/**
	 * message content
	 */
	public String message_content;
}
