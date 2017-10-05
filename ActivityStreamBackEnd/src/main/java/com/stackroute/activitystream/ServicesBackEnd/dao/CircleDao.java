package com.stackroute.activitystream.ServicesBackEnd.dao;

import java.util.List;

import com.stackroute.activitystream.ServicesBackEnd.model.Circle;
//Why one method is public and others are default
public interface CircleDao {
	//what is c
	boolean addCircle(Circle c);
	boolean removeCircle(String circleId);
	//the method name should be getAllCircles()
	List<Circle> getAllCircle();
	//You need one more method getCircleByName(String circleName);
	Circle getCircleById(String circleId );
	public boolean updateCircle(Circle circle);
}
