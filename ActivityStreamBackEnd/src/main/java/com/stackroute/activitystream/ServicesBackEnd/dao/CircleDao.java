package com.stackroute.activitystream.servicesbackend.dao;

import java.util.List;

<<<<<<< HEAD
import com.stackroute.activitystream.servicesbackend.model.Circle;

=======
import com.stackroute.activitystream.ServicesBackEnd.model.Circle;
//Why one method is public and others are default
>>>>>>> 510ac28f9ce32f7248135fde80af97a7e75898fb
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
