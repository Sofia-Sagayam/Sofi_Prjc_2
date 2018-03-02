package com.stackroute.activitystream.servicesbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
@Entity
public class User {
	@Id
	private String emailId;
	private String userName;
	//What is this userPass? can use password.
	private String userPass;
	private String userAddress;
	//Why this user roles?
	private String userRoles;
	
<<<<<<< HEAD
		public String getUserRoles() {
=======
	//where is onLine property?
	
	
	
	public String getUserRoles() {
>>>>>>> 510ac28f9ce32f7248135fde80af97a7e75898fb
		return userRoles;
	}
	public void setUserRoles(String userRoles) {
		this.userRoles = userRoles;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	
}
