package com.music.service;

import java.util.List;


import com.music.model.UserDetail;

public interface UserServDao {
	
	public void addUser(UserDetail ud);
	public void updateUser(UserDetail ud);
	public void removeUser(int uid);
	public List<UserDetail> listUser();
	public UserDetail getUserbyId(int uid);
}
