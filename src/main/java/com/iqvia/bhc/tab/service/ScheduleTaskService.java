package com.iqvia.bhc.tab.service;

import java.util.Optional;

import com.iqvia.bhc.tab.db.entity.MessageContent;

/**
 * Schedule Task Service
 * @author TabTu
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
	 * Find a message by message key from database
	 * @param msgId
	 * @return
	 */
	Optional<MessageContent> findMessage(String msgId);
}

