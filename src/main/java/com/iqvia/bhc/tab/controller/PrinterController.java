package com.iqvia.bhc.tab.controller;

import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iqvia.bhc.tab.model.ScheduleMessage;
import com.iqvia.bhc.tab.service.ScheduleTaskService;

@RestController
public class PrinterController {
	
	@Autowired
    private ScheduleTaskService taskServ;

    /**
     * echo a message back, will be added 'Hello IQVIA: ' as prefix
     */
    @GetMapping("/echo")
    ResponseEntity<String> echo() {
    	String returnStr = "Hello IQVIA.";
    	return ResponseEntity.ok().body(returnStr);
    }
    
    /**
     * return a example schedule message schema
     */
    @GetMapping("/example")
    ResponseEntity<Object> example() {
    	ScheduleMessage exampleMessage = new ScheduleMessage();
    	exampleMessage.schedule_time = "2022-12-31 12:31";
    	exampleMessage.message_content = "HELLO: IQVIA";
    	exampleMessage.time_zone = "EST";
    	return ResponseEntity.ok().body(exampleMessage);
    }
    
    /**
     * put a message to be printed by scheduled time
     * {"schedule_time":"2022-12-31T11:45:12", "message_content":"Hello IQVIA."}
     */
    @PutMapping("/putmessage")
    ResponseEntity<Boolean> putNewMessage(@RequestBody ScheduleMessage msg) {
    	boolean taskResult = taskServ.addScheduledMessage(msg.message_content, msg.schedule_time);
    	return ResponseEntity.accepted().body(taskResult);
    }
    
    /**
     * get a available time zone list
     * @return
     */
    @GetMapping("timezonelist")
    ResponseEntity<String> getTimeZoneList() {
    	String result = "";
    	String[] timeZoneList = TimeZone.getAvailableIDs();
		for(String timeZoneId : timeZoneList) {
			result += timeZoneId + "\n";
		}
		return ResponseEntity.ok().body(result);
    }
    
    /**
     * post a message to be printed by scheduled time
     * {"schedule_time":"2022-12-31T11:45:12", "time_zone":"EST", "message_content":"Hello IQVIA."}
     */
    @PostMapping("/postmessage")
    ResponseEntity<Boolean> postNewMessage(@RequestBody ScheduleMessage msg) {
    	boolean taskResult = taskServ.addScheduledMessage(msg.message_content, msg.schedule_time, msg.time_zone);
    	return ResponseEntity.accepted().body(taskResult);
    }
}