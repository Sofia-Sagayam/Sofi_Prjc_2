package com.stackroute.activitystream.ServicesBackEnd.dao;

import java.util.List;

import com.stackroute.activitystream.ServicesBackEnd.model.User;

public interface UserDao {
	public boolean registerUser(User user);
	public List<User> getUsers();
	//still you are not following naming conventions
	public User getUserbyId(String mailid);
	public boolean updateUser(User user);
	public boolean deleteUser(String id);
	//still you are not following naming conventions
	public boolean validateUser(String usrid,String usrpass);
}
