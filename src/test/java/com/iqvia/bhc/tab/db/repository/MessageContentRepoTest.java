package com.iqvia.bhc.tab.db.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iqvia.bhc.tab.db.entity.MessageContent;

@SpringBootTest
class MessageContentRepoTest {

	@Autowired
	private MessageContentRepo messageRepo;
	
	@Test
	void testFindMessage() {
		String msgKey = "IQVIATEST";
		String msgContentFromDB = "this is a test db message from database.";
		var getResult = messageRepo.findById(msgKey);
		try {
			assertEquals(msgContentFromDB, getResult.get().getMessageContent());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testAddMessageAndRemoveMessage() {
		String msgKey = "IQVIATESTIQVIATEST";
		String msgContent = "this is a test for repo";

		// add a message
		MessageContent mc = new MessageContent(msgKey, msgContent);
		messageRepo.save(mc);
		messageRepo.flush();

		// assert the insertion
		var readMsg = messageRepo.findById(msgKey);
		try {
			assertEquals(msgContent, readMsg.get().getMessageContent());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		// delete the message
		messageRepo.deleteById(msgKey);
		messageRepo.flush();
		
		// assert the deletion
		var confirmDel = messageRepo.findById(msgKey);
		try {
			assertEquals(Optional.empty(), confirmDel);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}	
	
}
