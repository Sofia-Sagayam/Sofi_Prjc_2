package com.stackroute.activitystream.ServicesBackEnd.dao;

import java.util.List;

import com.stackroute.activitystream.ServicesBackEnd.model.User;

public interface UserDao {
	public boolean registerUser(User user);
	public List<User> getUsers();
	public User getUserbyId(String mailid);
	public boolean updateUser(User user);
	public boolean deleteUser(String id);
	public boolean validateUser(String usrid,String usrpass);
}
