package com.iqvia.bhc.tab.db.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

/**
 * Message Content Entity
 *
 * @author TabTu
 * 
 */

@Entity (name = "MessageContent")
@Table (name = "iqvia_bhc_tab_messageContent")
public class MessageContent implements Serializable {
	
	private static final long serialVersionUID = -2273596636377074492L;
	
	@Id
	@Column (name = "messageKey", nullable = false)
	private String messageKey;
	
	@Column (name = "messageContent", nullable = true, length = 65535, columnDefinition = "Text")
	private String messageContent;


	public MessageContent() { } 
	
	public MessageContent(String msgKey, String msgContent) {
		this.messageKey = msgKey;
        this.messageContent = msgContent;
    }
    
	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
}
