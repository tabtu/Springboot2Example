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
 * @author TabTu
 *
 */
@Service
public class SchduleTaskServiceImpl implements ScheduleTaskService  {

	private static final Logger log = LoggerFactory.getLogger(SchduleTaskServiceImpl.class);
	
	@Autowired
	private MessageContentRepo messageRepo;
	
	@Autowired
	private QuartzService quartzServ;
	
	@Override
	public boolean addScheduledMessage(String schedule, String message) {
		try {
			String md5str = MD5Utils.MD5_64bit(message);
			var existedMsg = messageRepo.findById(md5str);

			if (existedMsg.isEmpty()) {
				MessageContent newMsg = new MessageContent(md5str, message);
				messageRepo.save(newMsg);
//				existedMsg.ifPresent( arg -> {arg = newMsg;} );
				existedMsg = Optional.ofNullable(newMsg);
			}
			
			Calendar calendar = Convertor.StringToCalendar(schedule);
			
			String res = quartzServ.scheduleJobWithCalendar(PrintJob.class, calendar, message);
//			System.out.println(res);
			
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