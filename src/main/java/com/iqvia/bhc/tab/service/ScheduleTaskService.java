package com.iqvia.bhc.tab.service;

import java.util.Optional;

import com.iqvia.bhc.tab.db.entity.MessageContent;

/**
 * @author TabTu
 *
 */
public interface ScheduleTaskService {

	/**
	 * Schedule a message for printing on console
	 * @param schedule the ''
	 * @param message
	 * @return schedule a quartz task on printer
	 */
	boolean addScheduledMessage(String schedule, String message);
	
	/**
	 * @param msgId
	 * @return
	 */
	Optional<MessageContent> findMessage(String msgId);
}

