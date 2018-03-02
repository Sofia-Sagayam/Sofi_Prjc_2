package com.stackroute.activitystream.servicesbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Circle {
	@Id
	private String circleId;
	private String circleName;
<<<<<<< HEAD
	private String circleCreatedBy;
	private boolean circleStatus;
	private Date circleCreatedDate;
=======
	//is it circleBy or createdBy?
	private String circleBy;
	//if the data type is boolean, the field name should start with "is".  like isActive
	private boolean circleStatus;
	//Waht is this Init?
	private Date circleInit;
>>>>>>> 510ac28f9ce32f7248135fde80af97a7e75898fb
	public String getCircleId() {
		return circleId;
	}
	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}
	public String getCircleName() {
		return circleName;
	}
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}
	public String getCircleBy() {
		return circleCreatedBy;
	}
	
	public void setCircleBy(String circleCreatedBy) {
		this.circleCreatedBy = circleCreatedBy;
	}
	public boolean isCircleStatus() {
		return circleStatus;
	}
	public void setCircleStatus(boolean circleStatus) {
		this.circleStatus = circleStatus;
	}
	public Date getCircleInit() {
		return circleCreatedDate;
	}
	public void setCircleInit(Date circleCreatedDate) {
		this.circleCreatedDate = circleCreatedDate;
	}
	public String toString(){
		return this.getCircleId()+" "+this.getCircleName()+" "+this.getCircleBy()+" "+this.getCircleInit();
	}


}
