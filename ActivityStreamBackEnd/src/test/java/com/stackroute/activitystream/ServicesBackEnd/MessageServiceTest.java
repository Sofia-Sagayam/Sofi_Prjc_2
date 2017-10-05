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

import com.stackroute.activitystream.ServicesBackEnd.dao.MessageDao;
import com.stackroute.activitystream.ServicesBackEnd.model.Message;
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
	
	@Test
public void sendMessageToCircleTest(){
	message.setCircleId("d001");
	message.setDateOfMessage(new Date());
	message.setMessageContent("good food loves you tooo");
	message.setMessageId("m007");
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
}
