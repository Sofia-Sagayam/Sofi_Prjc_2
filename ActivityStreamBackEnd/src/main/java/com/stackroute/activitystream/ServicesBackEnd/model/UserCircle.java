package com.stackroute.activitystream.servicesbackend.model;


import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class UserCircle {
	@Id
private String userCircleId;
private String circleId;
private String emailId;
	
//Where are subscribe field and date of joing field?
public String getUserCircleId() {
	return userCircleId;
}
public void setUserCircleId(String userCircleId) {
	this.userCircleId = userCircleId;
}
public String getCircleId() {
	return circleId;
}
public void setCircleId(String circleId) {
	this.circleId = circleId;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
}

