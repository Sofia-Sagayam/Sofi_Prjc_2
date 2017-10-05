package com.stackroute.activitystream.ServicesBackEnd.dao;

import java.util.List;

import com.stackroute.activitystream.ServicesBackEnd.model.UserCircle;

public interface UserCircleDao {

	//adUserToCircle
	boolean addUserCircle(UserCircle usercircle);
	//remveUserFromCircle
	boolean removeUserCircle(String userCircleId);
	//Why this method?
	List<UserCircle> getAllUserCircle();
	UserCircle getUserCircleById(String userCircleId );
	public boolean updateUserCircle(UserCircle circle);
	//you may need to get all the circle names / ids subscribed by a particular user
	// like public String[] getMyCircles(String userID)  // if you want to get all circle names subscribed by a particular user
	// like public int[] getMyCircles(String userID)  // if you want to get all circle ids subscribed by a particular user
}
