package com.stackroute.activitystream.messageservice.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activitystream.servicesbackend.dao.MessageDao;
import com.stackroute.activitystream.servicesbackend.model.Message;
import com.stackroute.activitystream.servicesbackend.model.User;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class MessageController {
@Autowired
private MessageDao messageDao;

@RequestMapping(value="/messageFromUser/{id:.+}",method = RequestMethod.GET)
public ResponseEntity<List<Message>> getMessageFromUser(@PathVariable("id") String id) {
	System.out.println("in msg controller id is ****************************"+id);
	List<Message> messages=messageDao.getMessageFromUser(id);
	return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);
}
@RequestMapping(value="/messageFromCircle/{id}",method = RequestMethod.GET)
public ResponseEntity<List<Message>> getMessageFromCircle(@PathVariable("id") String id) {
	System.out.println("in msg controller id is ****************************"+id);
	List<Message> messages=messageDao.getMessageFromCircle(id);
	return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);
}


@RequestMapping(value="/sendMessageToUser",method= RequestMethod.POST)
  public ResponseEntity<String> sendMessageToUser(@RequestBody Message message){
	System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+message.getMessageContent()+" "+message.getMessageId()+" "+message.getReceiverId()+" "+message.getSenderId());
	message.setSenderId("sofia@niit.com");
	message.setReceiverId(message.getReceiverId());
	message.setDateOfMessage(new Date());
	message.setMessageType("text");
	if(messageDao.sendMessage(message))
	{
	return new ResponseEntity<String>("sent!!..",HttpStatus.CREATED);
  }
	return new ResponseEntity<String>("unable to sent check ur network...",HttpStatus.NOT_ACCEPTABLE);
	
  }

@RequestMapping(value="/sendMessageToCircle",method= RequestMethod.POST)
public ResponseEntity<String> sendMessageToCircle(@RequestBody Message message){
	if(messageDao.sendMessage(message))
	{
	return new ResponseEntity<String>("sent!!..",HttpStatus.CREATED);
}
	return new ResponseEntity<String>("unable to sent check ur network...",HttpStatus.NOT_ACCEPTABLE);
	
}
@GetMapping("/")
public String serverStarted(){
	return "server started";
}
}
