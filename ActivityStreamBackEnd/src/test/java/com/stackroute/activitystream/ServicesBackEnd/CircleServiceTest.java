package com.stackroute.activitystream.ServicesBackEnd;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.activitystream.ServicesBackEnd.dao.CircleDao;
import com.stackroute.activitystream.ServicesBackEnd.dao.UserDao;
import com.stackroute.activitystream.ServicesBackEnd.model.Circle;
import com.stackroute.activitystream.ServicesBackEnd.model.User;

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
	
	@Test
	public void createCircleTest(){
		circle.setCircleName("logger circle");
		circle.setCircleBy("logger@niit.com");
		circle.setCircleId("c006");
		circle.setCircleInit(new Date());
		circle.setCircleStatus(true);
		circleDao.addCircle(circle);
		Circle reterivedCircle=circleDao.getCircleById(circle.getCircleId());
		assertNotNull(reterivedCircle);

	}
	@Test
	public void reteriveCircleTest(){
		Circle reterivedData=circleDao.getCircleById("d001");
		assertNotNull(reterivedData);
	}
	@Test
	public void updateCircleTest(){
		Circle reterivedData=circleDao.getCircleById("d001");
		reterivedData.setCircleName("try");
		assertTrue(circleDao.updateCircle(reterivedData));
	}
	@Test
	public void deleteCircleTest(){
		assertTrue(circleDao.removeCircle("d001"));
	}

}
