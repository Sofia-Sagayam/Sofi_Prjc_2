package com.stackroute.activitystream.ServicesBackEnd.model;

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
	private String circleBy;
	private boolean circleStatus;
	private Date circleInit;
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
		return circleBy;
	}
	public void setCircleBy(String circleBy) {
		this.circleBy = circleBy;
	}
	public boolean isCircleStatus() {
		return circleStatus;
	}
	public void setCircleStatus(boolean circleStatus) {
		this.circleStatus = circleStatus;
	}
	public Date getCircleInit() {
		return circleInit;
	}
	public void setCircleInit(Date circleInit) {
		this.circleInit = circleInit;
	}
	public String toString(){
		return this.getCircleId()+" "+this.getCircleName()+" "+this.getCircleBy()+" "+this.getCircleInit();
	}


}