package com.stackroute.activitystream.servicesbackend;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.activitystream.servicesbackend.dao.UserDao;
import com.stackroute.activitystream.servicesbackend.model.User;





@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
//Thse are not services
//It should be UserDAOTestCase
public class UserServicesTest {
	@Autowired
	private UserDao userDao;
	private static User user;
	
	
	@BeforeClass
	public static void initiate(){
		user=new User();
		
	}
	
	//@Test(expected=Exception.class)
	public void saveUser() {
	user.setEmailId("divya@niit.com");
	user.setUserName("divya");
	user.setUserPass("123");
	user.setUserAddress("chenaai");
	userDao.registerUser(user);
	User found=userDao.getUserbyId(user.getEmailId());
	assertNotNull(found);
	
	}
	
	//login user

	@Test(expected=AssertionError.class)
	public void reteriveUser(){
		User reterivedData=	userDao.getUserbyId("dummy@niit.com");
		
		assertNotNull(reterivedData);
	}
	@Test(expected=NullPointerException.class)
	public void updateUser(){
		User reterivedData=	userDao.getUserbyId("dummy@niit.com");
		reterivedData.setUserName("jai kutty");
		assertTrue(userDao.updateUser(reterivedData));
	}
	@Test(expected=AssertionError.class)
	public void deleteUser(){
		
		assertTrue(userDao.deleteUser("dummy@niit.com"));
	}
	
}
