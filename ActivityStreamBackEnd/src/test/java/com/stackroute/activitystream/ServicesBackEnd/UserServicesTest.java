package com.stackroute.activitystream.ServicesBackEnd;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.activitystream.ServicesBackEnd.dao.UserDao;
import com.stackroute.activitystream.ServicesBackEnd.model.Circle;
import com.stackroute.activitystream.ServicesBackEnd.model.Message;
import com.stackroute.activitystream.ServicesBackEnd.model.User;
import com.stackroute.activitystream.ServicesBackEnd.model.UserCircle;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserServicesTest {
	@Autowired
	private UserDao userDao;
	private static User user;
	
	
	@BeforeClass
	public static void initiate(){
		user=new User();
		
	}
	
	@Test
	public void saveUser() {
	user.setEmailId("logger@niit.com");
	user.setUserName("logger");
	user.setUserPass("logger#321");
	user.setUserAddress("bangalore");
	userDao.registerUser(user);
	User found=userDao.getUserbyId(user.getEmailId());
	assertNotNull(found);
	
	}

	@Test
	public void reteriveUser(){
		User reterivedData=	userDao.getUserbyId("roshini@niit.com");
		assertNotNull(reterivedData);
	}
	@Test
	public void updateUser(){
		User reterivedData=	userDao.getUserbyId("roshini@niit.com");
		reterivedData.setUserName("jai kutty");
		assertTrue(userDao.updateUser(reterivedData));
	}
	@Test
	public void deleteUser(){
		assertTrue(userDao.deleteUser("dummy@niit.com"));
	}
	
}
