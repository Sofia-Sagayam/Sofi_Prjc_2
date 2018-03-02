package com.stackroute.activitystream.circleservice.CircleService;

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

import com.stackroute.activitystream.servicesbackend.dao.CircleDao;
import com.stackroute.activitystream.servicesbackend.model.Circle;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CircleServiceApplicationTests {

	@Autowired
	private CircleDao circleDao;
	private static Circle circle;
	
	@BeforeClass
	public static void initiate(){
		circle=new Circle();
	}
	@Test
	public void createCircleTest(){
		circle.setCircleName("dummy circle");
		circle.setCircleBy("sofi");
		circle.setCircleId("dummy");
		circle.setCircleInit(new Date());
		circle.setCircleStatus(true);
		circleDao.addCircle(circle);
		Circle reterivedCircle=circleDao.getCircleById(circle.getCircleId());
		assertNotNull(reterivedCircle);

	}
	@Test
	public void reteriveCircleTest(){
		Circle reterivedData=	circleDao.getCircleById("c001");
		assertNotNull(reterivedData);
	}
	@Test
	public void updateCircleTest(){
		Circle reterivedData=	circleDao.getCircleById("d001");
		reterivedData.setCircleName("try");
		assertTrue(circleDao.updateCircle(reterivedData));
	}
	@Test
	public void deleteCircleTest(){
		assertTrue(circleDao.removeCircle("d001"));
	}
	

}
