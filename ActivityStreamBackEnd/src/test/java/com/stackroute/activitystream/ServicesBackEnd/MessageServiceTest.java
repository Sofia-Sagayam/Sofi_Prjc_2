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

import com.stackroute.activitystream.servicesbackend.dao.MessageDao;
import com.stackroute.activitystream.servicesbackend.model.Message;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class MessageServiceTest {
	
	@Autowired
	private MessageDao messageDao;
	private static Message message;
	
	@BeforeClass
	public static void initiate(){
		message=new Message();
	}
	
	@Test//(expected=DataIntegrityViolationException.class)
public void sendMessageToCircleTest(){
	message.setCircleId("d001");
	message.setDateOfMessage(new Date());
	message.setMessageContent("circle is working....");
	message.setMessageId(104);
	message.setMessageSize("12kb");
	message.setMessageType("text");
	message.setSenderId("sofia@niit.com");
		assertNotNull(messageDao.sendMessage(message));
}
	@Test//(expected=DataIntegrityViolationException.class)
	public void sendMessageToUserTest(){
		
		message.setDateOfMessage(new Date());
		message.setReceiverId("sofia@niit.com");
		message.setMessageContent("akka papppaaaaa ☺!!!!");
	//	message.setMessageId("msg09");
		message.setMessageSize("12kb");
		message.setMessageType("text");
		message.setSenderId("jagan@niit.com");
			assertTrue(messageDao.sendMessage(message));
	}
	@Test//(expected=AssertionError.class)
	public void messageFromUserTest(){
		assertNotNull(messageDao.getMessageFromUser("hansu@niit.com"));
		
	}
	
	@Test//(expected=AssertionError.class)
	public void messageFromCircleTest(){
		assertNotNull(messageDao.getMessageFromCircle("dummy"));
		
	}
	
	@Test(expected=AssertionError.class)
	public void deleteSenderMessageInCircleTest(){
		assertTrue(messageDao.deleteSenderMessageInCircle("17hjhjhjh0"));
	}
}
