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

import com.stackroute.activitystream.ServicesBackEnd.dao.UserCircleDao;
import com.stackroute.activitystream.ServicesBackEnd.model.UserCircle;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)

public class UserCircleServiceTest {
	@Autowired
	private UserCircleDao userCircleDao;
	private static UserCircle userCircle;
	
	@BeforeClass
	public static void initiate(){
		userCircle=new UserCircle();
		
	}

	@Test
	public void createUserCircleTest(){
		userCircle.setCircleId("c001");
		userCircle.setEmailId("logger@niit.com");
		userCircle.setUserCircleId("uc007");
		userCircleDao.addUserCircle(userCircle);
		UserCircle reterivedData=userCircleDao.getUserCircleById(userCircle.getUserCircleId());
		assertNotNull(reterivedData);

	}
	@Test
	public void reteriveUserCircleTest(){
		UserCircle reterivedData=	userCircleDao.getUserCircleById("uc002");
		assertNotNull(reterivedData);
	}

	@Test
	public void deleteUserCircleTest(){
		assertTrue(userCircleDao.removeUserCircle("uc001"));	
	}
}
