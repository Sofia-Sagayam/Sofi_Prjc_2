package com.music.DAO;

import java.util.List;


import com.music.model.UserDetail;

public interface UserDAO {
	public void addUser(UserDetail ud);
	public void updateUser(UserDetail ud);
	public void removeUSer(int uid);
	public List<UserDetail> getUser();
	public UserDetail getUserbyId(int uid);
}
