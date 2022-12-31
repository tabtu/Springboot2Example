package com.iqvia.bhc.tab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/echo/{message}")
    ResponseEntity<String> echo(@PathVariable String message) {
    	String returnStr = "Hello IQVIA: ";
    	return ResponseEntity.ok().body(returnStr + message);
    }
    
    /**
     * return a example schedule message schema
     */
    @GetMapping("/example")
    ResponseEntity<Object> example() {
    	ScheduleMessage exampleMessage = new ScheduleMessage();
    	exampleMessage.schedule_time = "2022-12-31 12:31";
    	exampleMessage.message_content = "HELLO: IQVIA";
    	return ResponseEntity.ok().body(exampleMessage);
    }
    
    /**
     * put a message to be printed by scheduled time
     * {"schedule_time":"2022-12-31 11:45:12", "message_content":"Hello IQVIA."}
     */
    @PutMapping("/putmessage")
    ResponseEntity<Boolean> putNewMessage(@RequestBody ScheduleMessage msg) {
    	boolean taskResult = taskServ.addScheduledMessage(msg.schedule_time, msg.message_content);
    	return ResponseEntity.accepted().body(taskResult);
    }
    
    /**
     * post a message to be printed by scheduled time
     * {"schedule_time":"2022-12-31 11:45:12", "message_content":"Hello IQVIA."}
     */
    @PostMapping("/postmessage")
    ResponseEntity<Boolean> postNewMessage(@RequestBody ScheduleMessage msg) {
    	boolean taskResult = taskServ.addScheduledMessage(msg.schedule_time, msg.message_content);
    	return ResponseEntity.accepted().body(taskResult);
    }
}