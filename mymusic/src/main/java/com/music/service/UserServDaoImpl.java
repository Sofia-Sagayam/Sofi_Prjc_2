package com.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.music.DAO.UserDAO;
import com.music.model.UserDetail;
@Service
public class UserServDaoImpl implements UserServDao {
@Autowired
	UserDAO udo;
	@Override   
	@Transactional
	public void addUser(UserDetail ud) {
	udo.addUser(ud);  
	}   
	@Override
	public void updateUser(UserDetail ud) {
		udo.updateUser(ud);
	} 
	@Override
	public void removeUser(int uid) {
		udo.removeUSer(uid);
	}
		@Override
	public List<UserDetail> listUser() {
		return udo.getUser();
			}
		

	@Override
	public UserDetail getUserbyId(int uid) {
				return  udo.getUserbyId(uid);
	
	} 

}
