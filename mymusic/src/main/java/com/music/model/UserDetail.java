package com.music.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetail {
@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)
private int uid;
private String uname;
 private String upass; 
private String urole;
public int getUid() {
 	   
	return uid;
	}
public void setUid(int uid) {
	this.uid = uid;
}


public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}

public String getUpass() {
	return upass;
}
public void setUpass(String upass) {
	this.upass = upass;
}
public String getUrole() {
	return urole;
}
public void setUrole(String urole) {
	this.urole = urole;
}


}
