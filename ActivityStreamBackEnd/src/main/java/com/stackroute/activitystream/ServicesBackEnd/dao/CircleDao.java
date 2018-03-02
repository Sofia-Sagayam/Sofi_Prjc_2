package com.stackroute.activitystream.servicesbackend.dao;

import java.util.List;

import com.stackroute.activitystream.servicesbackend.model.Circle;

public interface CircleDao {
	boolean addCircle(Circle c);
	boolean removeCircle(String circleId);
	List<Circle> getAllCircle();
	Circle getCircleById(String circleId );
	public boolean updateCircle(Circle circle);
}
