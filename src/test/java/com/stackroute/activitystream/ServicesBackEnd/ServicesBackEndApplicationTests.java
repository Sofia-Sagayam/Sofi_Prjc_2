package com.stackroute.activitystream.ServicesBackEnd;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.activitystream.ServicesBackEnd.dao.CircleDao;
import com.stackroute.activitystream.ServicesBackEnd.dao.MessageDao;
import com.stackroute.activitystream.ServicesBackEnd.dao.UserCircleDao;
import com.stackroute.activitystream.ServicesBackEnd.dao.UserDao;
import com.stackroute.activitystream.ServicesBackEnd.dao.UserMessageDao;
import com.stackroute.activitystream.ServicesBackEnd.model.Circle;
import com.stackroute.activitystream.ServicesBackEnd.model.Message;
import com.stackroute.activitystream.ServicesBackEnd.model.User;
import com.stackroute.activitystream.ServicesBackEnd.model.UserCircle;
import com.stackroute.activitystream.ServicesBackEnd.model.UserMessage;




@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ServicesBackEndApplicationTests {


	@Autowired
	private UserDao userDao;
	private static User user;
	@Autowired
	private CircleDao circleDao;
	private static Circle circle;
	@Autowired
	private UserCircleDao userCircleDao;
	private static UserCircle userCircle;
	@Autowired
	private MessageDao messageDao;
	private static Message message; 
	
	@BeforeClass
	public static void initiate(){
		user=new User();
		circle=new Circle();
		userCircle=new UserCircle();
		message=new Message();
	}
	@Test
	public void saveUser() {
	user.setEmailId("jagan@niit.com");
	user.setUserName("jagan");
	user.setUserPass("jagan#321");
	user.setUserAddress("erode");
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
	
	//circle test
	
	@Test
	public void createCircleTest(){
		circle.setCircleName("big data circle");
		circle.setCircleBy("hansu@niit.com");
		circle.setCircleId("c001");
		circle.setCircleInit(new Date());
		circle.setCircleStatus(true);
		circleDao.addCircle(circle);
		Circle reterivedCircle=circleDao.getCircleById(circle.getCircleId());
		assertNotNull(reterivedCircle);

	}
	@Test
	public void reteriveCircleTest(){
		Circle reterivedData=	circleDao.getCircleById("d001");
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

	//UserCircle
	@Test
	public void createUserCircleTest(){
		userCircle.setCircleId("d001");
		userCircle.setEmailId("jayashree@niit.com");
		userCircle.setUserCircleId("uc006");
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
	//inbox
	@Test
public void sendMessageToCircleTest(){
	message.setCircleId("d001");
	message.setDateOfMessage(new Date());
	message.setMessageContent("good food loves you tooo");
	message.setMessageId("msg101");
	message.setMessageSize("12kb");
	message.setMessageType("text");
	message.setSenderId("hansu@niit.com");
		assertNotNull(messageDao.sendMessage(message));
}
	@Test
	public void sendMessageToUserTest(){
		
		message.setDateOfMessage(new Date());
		message.setReceiverId("roshini@niit.com");
		message.setMessageContent("god is great");
		message.setMessageId("msg05");
		message.setMessageSize("12kb");
		message.setMessageType("text");
		message.setSenderId("hansu@niit.com");
			assertNotNull(messageDao.sendMessage(message));
	}
	@Test
	public void messageFromUserTest(){
		assertNotNull(messageDao.getMessageFromUser("hansu@niit.com"));
		
	}
	
	@Test
	public void messageFromCircleTest(){
		assertNotNull(messageDao.getMessageFromCircle("d001"));
		
	}
	
	@Test
	public void deleteSenderMessageInCircleTest(){
		assertTrue(messageDao.deleteSenderMessageInCircle("170"));
	}
	
	//outbox
	
	
}

