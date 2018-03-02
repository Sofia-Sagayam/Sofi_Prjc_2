package com.music.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
public class RUser {
	 @NotNull
	    @Size(min=1,max=20)
	private String name;
	 @NotNull
	 @Size(min=1,max=20)
	private String pass;
	 @NotNull
	 @Size(min=1,max=20)
	private String cPass;
	public String getName() {
		return name;
	} 
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getcPass() {
		return cPass;
	}
	public void setcPass(String cPass) {
		this.cPass = cPass;
	}
	
	
}
