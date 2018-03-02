package com.stackroute.activitystream.servicesbackend;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.activitystream.servicesbackend.dao.CircleDao;
import com.stackroute.activitystream.servicesbackend.dao.UserDao;
import com.stackroute.activitystream.servicesbackend.model.Circle;
import com.stackroute.activitystream.servicesbackend.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CircleServiceTest {
	
	@Autowired
	private CircleDao circleDao;
	private static Circle circle;
	
	@BeforeClass
	public static void initiate(){
		circle=new Circle();
		
	}
	
	@Test(expected=DataIntegrityViolationException.class)
	public void createCircleTest(){
		circle.setCircleName("logger circle");
		circle.setCircleBy("logger@niit.com");
		circle.setCircleId("c007");
		
		circleDao.addCircle(circle);
		Circle reterivedCircle=circleDao.getCircleById(circle.getCircleId());
		assertNotNull(reterivedCircle);

	}
	@Test(expected=AssertionError.class)
	public void reteriveCircleTest(){
		Circle reterivedData=circleDao.getCircleById("c0");
		assertNotNull(reterivedData);
	}
	@Test(expected=NullPointerException.class)
	public void updateCircleTest(){
		Circle reterivedData=circleDao.getCircleById("c");
		reterivedData.setCircleName("try");
		assertTrue(circleDao.updateCircle(reterivedData));
	}
	@Test(expected=AssertionError.class)
	public void deleteCircleTest(){
		assertTrue(circleDao.removeCircle("c0"));
	}

}
