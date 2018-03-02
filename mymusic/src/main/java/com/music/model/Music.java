package com.music.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Music {
	@Id
private String genreid;
	private String genrename;   
private String desc;
private String price;
public String getGenreid() {
	return genreid;
}  
public void setGenreid(String genreid) {
	this.genreid = genreid;
}
public String getGenrename() {
	return genrename;
}    
public void setGenrename(String genrename) {
	this.genrename = genrename;
	
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}


		
}
