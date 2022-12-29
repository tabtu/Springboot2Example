package com.iqvia.bhc.tab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iqvia.bhc.tab.db.entity.MessageContent;
import com.iqvia.bhc.tab.model.ScheduleMessage;
import com.iqvia.bhc.tab.service.ScheduleTaskService;

@RestController
public class PrinterController {
	
	private static final Logger log = LoggerFactory.getLogger(PrinterController.class);
	
	@Autowired
    private ScheduleTaskService taskServ;

    @GetMapping("/echo")
    ResponseEntity<String> test() {
    	String returnStr = "Hello World";
    	return ResponseEntity.accepted().body(returnStr);
    }
    
    @PostMapping("/pushmessage")
    boolean pushNewMessage(@RequestBody ScheduleMessage msg) {
//    	System.out.println(msg.schedule_time);
    	return taskServ.addScheduledMessage(msg.schedule_time, msg.message_content);
    }
    
    @GetMapping("/message/{id}")
    MessageContent getOneMessage(@PathVariable String id) {
    	System.out.println(id);
    	return taskServ.findMessage(id).get();
//        .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
}