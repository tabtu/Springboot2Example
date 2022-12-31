package com.iqvia.bhc.tab.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iqvia.bhc.tab.db.entity.MessageContent;

/**
 * Message Content Repository
 * @author TabTu
 */

@Repository
public interface MessageContentRepo extends JpaRepository<MessageContent, String> {
	// TODO: add specific query if required.
	
}
