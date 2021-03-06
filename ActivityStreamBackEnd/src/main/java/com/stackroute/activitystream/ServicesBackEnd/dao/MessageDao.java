package com.stackroute.activitystream.servicesbackend.dao;

import java.util.List;

import com.stackroute.activitystream.servicesbackend.model.Message;
import com.stackroute.activitystream.servicesbackend.model.Outbox;
import com.stackroute.activitystream.servicesbackend.model.UserMessage;

public interface MessageDao {
			public boolean sendMessage(Message message);
			public List<Message> getMessageFromUser(String senderID);
		public List<Message> getMessageFromCircle(String circleID);
		//you need only sendMessageToUser()
	         //  sendMessageToCircle
	         //not inbox/outbox.
		public boolean sendMessageToInbox(UserMessage message);
		public boolean sendMessageToOutbox(Outbox message);
		public boolean deleteSenderMessageInCircle(String msgId);
	
	//Need deleteSentMessage(String userID, String messgeID )
	// and deleteReceivedMessage(String userID,  String messageID)   like methods
}
