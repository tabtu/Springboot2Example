package com.iqvia.bhc.tab.service.impl;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iqvia.bhc.tab.db.entity.MessageContent;
import com.iqvia.bhc.tab.db.repository.MessageContentRepo;
import com.iqvia.bhc.tab.service.QuartzService;
import com.iqvia.bhc.tab.service.ScheduleTaskService;
import com.iqvia.bhc.tab.task.PrintJob;
import com.iqvia.bhc.tab.utils.Convertor;
import com.iqvia.bhc.tab.utils.MD5Utils;

/**
 * Schedule Task Service Implement
 * @author TabTu
 */
@Service
public class ScheduleTaskServiceImpl implements ScheduleTaskService  {

	private static final Logger log = LoggerFactory.getLogger(ScheduleTaskServiceImpl.class);
	
	@Autowired
	private MessageContentRepo messageRepo;
	
	@Autowired
	private QuartzService quartzServ;
	
	@Override
	public boolean addScheduledMessage(String schedule, String message) {
		try {
			String md5str = MD5Utils.MD5_64bit(message);
			var existedMsg = messageRepo.findById(md5str);
			// if message is not exist in database
			if (existedMsg.isEmpty()) {
				MessageContent newMsg = new MessageContent(md5str, message);
				messageRepo.save(newMsg);
//				existedMsg.ifPresent( arg -> {arg = newMsg;} );
				existedMsg = Optional.ofNullable(newMsg);
			}
			// convert the schedule sending date time
			Calendar calendar = Convertor.StringToCalendar(schedule);
			// schedule a new job
			String message_id = quartzServ.scheduleJobWithCalendar(PrintJob.class, calendar, message);
			log.debug(schedule + " : " + message_id);
			return true;
		}
		catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}
	
	@Override
	public Optional<MessageContent> findMessage(String msgId) {
		return messageRepo.findById(msgId);
	}
}