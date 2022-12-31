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
		msg.schedule_time = "2022-12-31 12:31:00";
		msg.message_content = "";

		boolean taskResult = taskServ.addScheduledMessage(msg.schedule_time, msg.message_content);
		assertEquals(true, taskResult);
    	
	}
}
