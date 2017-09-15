package com.stackroute.activitystream.ServicesBackEnd.dao;

import java.util.Date;

import com.stackroute.activitystream.ServicesBackEnd.model.Message;
import com.stackroute.activitystream.ServicesBackEnd.model.Outbox;
import com.stackroute.activitystream.ServicesBackEnd.model.UserMessage;

public interface UserMessageDao {
public boolean sendMessage(UserMessage message);
public boolean sendMessage(Outbox message);
public UserMessage getMessageFromUser(String senderID);
public UserMessage getMessageFromCircle(String circleID);


}
