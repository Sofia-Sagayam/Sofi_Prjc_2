package com.stackroute.activitystream.servicesbackend.dao;

import java.util.Date;

import com.stackroute.activitystream.servicesbackend.model.Message;
import com.stackroute.activitystream.servicesbackend.model.Outbox;
import com.stackroute.activitystream.servicesbackend.model.UserMessage;

public interface UserMessageDao {
public boolean sendMessage(UserMessage message);
public boolean sendMessage(Outbox message);
public UserMessage getMessageFromUser(String senderID);
public UserMessage getMessageFromCircle(String circleID);


}
