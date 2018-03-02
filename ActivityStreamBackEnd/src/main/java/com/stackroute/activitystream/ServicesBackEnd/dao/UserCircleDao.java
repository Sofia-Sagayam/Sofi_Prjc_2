package com.stackroute.activitystream.servicesbackend.dao;

import java.util.List;

import com.stackroute.activitystream.servicesbackend.model.UserCircle;

public interface UserCircleDao {

	boolean addUserCircle(UserCircle usercircle);
	boolean removeUserCircle(String userCircleId);
	List<UserCircle> getAllUserCircle();
	UserCircle getUserCircleById(String userCircleId );
	public boolean updateUserCircle(UserCircle circle);
}
