package com.stackroute.activitystream.ServicesBackEnd.dao;

import java.util.List;

import com.stackroute.activitystream.ServicesBackEnd.model.UserCircle;

public interface UserCircleDao {

	boolean addUserCircle(UserCircle usercircle);
	boolean removeUserCircle(String userCircleId);
	List<UserCircle> getAllUserCircle();
	UserCircle getUserCircleById(String userCircleId );
	public boolean updateUserCircle(UserCircle circle);
}
