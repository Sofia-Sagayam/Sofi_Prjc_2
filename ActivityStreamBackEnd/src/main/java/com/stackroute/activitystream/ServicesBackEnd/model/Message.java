package com.stackroute.activitystream.servicesbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
private int messageId;
private String senderId;
private String receiverId;
private String messageContent;
private String messageType;
private String messageSize;
private String circleId;
private Date dateOfMessage;


public int getMessageId() {
	return messageId;
}
public void setMessageId(int messageId) {
	this.messageId = messageId;
}
public String getSenderId() {
	return senderId;
}
public void setSenderId(String senderId) {
	this.senderId = senderId;
}
public String getReceiverId() {
	return receiverId;
}
public void setReceiverId(String receiverId) {
	this.receiverId = receiverId;
}
public String getMessageContent() {
	return messageContent;
}
public void setMessageContent(String messageContent) {
	this.messageContent = messageContent;
}
public String getMessageType() {
	return messageType;
}
public void setMessageType(String messageType) {
	this.messageType = messageType;
}
public String getMessageSize() {
	return messageSize;
}
public void setMessageSize(String messageSize) {
	this.messageSize = messageSize;
}
public String getCircleId() {
	return circleId;
}
public void setCircleId(String circleId) {
	this.circleId = circleId;
}
public Date getDateOfMessage() {
	return dateOfMessage;
}
public void setDateOfMessage(Date dateOfMessage) {
	this.dateOfMessage = dateOfMessage;
}


}
