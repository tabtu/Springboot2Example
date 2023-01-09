package com.iqvia.bhc.tab.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iqvia.bhc.tab.model.ScheduleMessage;

@SpringBootTest
class ScheduleTaskServiceTest {

	@Autowired
    private ScheduleTaskService taskServ;

	@Test
	void testAddScheduleTaskService() {
		ScheduleMessage msg = new ScheduleMessage();
		msg.schedule_time = "2022-12-31T11:31:00";
		msg.message_content = "send a test message";
		msg.time_zone = "EST";
		
		boolean taskResult_withTimeZone = taskServ.addScheduledMessage(msg.message_content, msg.schedule_time, msg.time_zone);
		assertEquals(true, taskResult_withTimeZone);
		
		boolean taskResult_defaultTimeZone = taskServ.addScheduledMessage(msg.message_content, msg.schedule_time);
		assertEquals(true, taskResult_defaultTimeZone);
	}
}
