package com.stackroute.activitystream.UserService.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activitystream.servicesbackend.dao.UserDao;
import com.stackroute.activitystream.servicesbackend.model.User;







@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	@Autowired
	private UserDao userDao;
	
	/*@RequestMapping(value="/",method = RequestMethod.GET)
	public ResponseEntity<List<User>> getWelcome() {
		List<User> users=userDao.getUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}*/
	
	@GetMapping("/")
    String hello() {
        return "hello world";
    }

	
	@RequestMapping(value="/alluser",method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		List<User> users=userDao.getUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value="/signup",method= RequestMethod.POST)
	  public ResponseEntity<String> registerUser(@RequestBody User user){
		if(userDao.registerUser(user))
		{
		return new ResponseEntity<String>("registered successfully!!..",HttpStatus.CREATED);
	  }
		return new ResponseEntity<String>("mailid registered already,pls use new mailid",HttpStatus.NOT_ACCEPTABLE);
		
	  }
	@RequestMapping(value="/signin",method= RequestMethod.POST)
	  public ResponseEntity<String> loginUser(@RequestBody User user){
		  //send email id and password to dao.  it should return true or false
		
		if(userDao.validateUser(user.getEmailId(), user.getUserPass()))
		{
			
		return new ResponseEntity<String>("welcome!!! ",HttpStatus.CREATED);
		
		}
		return new ResponseEntity<String>("oops wrong mailid or password...",HttpStatus.NOT_FOUND);
		
		
		
	  }
	/*@RequestMapping(value="/admin/signin",method= RequestMethod.POST)
	  public ResponseEntity<String> loginUserAdmin(@RequestBody User user){
		  //send email id and password to dao.  it should return true or false
		
		if(userDao.validateUser(user.getEmailId(), user.getUserPass()))
		{
			
		return new ResponseEntity<String>("welcome!!! ",HttpStatus.CREATED);
		
		}
		return new ResponseEntity<String>("oops wrong mailid or password...",HttpStatus.NOT_FOUND);
	}*/
	  @RequestMapping(value="/updateUser",method= RequestMethod.PUT)
	  public ResponseEntity<String> updateUser(@RequestBody User user){
		  if(userDao.updateUser(user)){
		return new ResponseEntity<String>("updated successfully...",HttpStatus.OK);
		}
		return new ResponseEntity<String>("oops email id is not registerd...",HttpStatus.NOT_FOUND);
				
	  }
	  
	  @DeleteMapping(value="/deleteUser/{id}")
	  public ResponseEntity<String> deleteUser(@PathVariable("id") String id){
		 
		  if(userDao.deleteUser(id)){
		return new ResponseEntity<String>("deleted successfully,,,",HttpStatus.OK);
		}
		return new ResponseEntity<String>("oops email id is not registerd...",HttpStatus.NOT_FOUND);
				
	  }
	  
	  @RequestMapping(value="/userBy/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	  public Resource<User> userById(@PathVariable("id") String mailId){
		  User user=userDao.getUserbyId(mailId);
		  
		  Resource<User> userResource=new Resource<>(user);
		  userResource.add(linkTo(methodOn(UserController.class).allUser()).withRel("users"));
		  return userResource;
	  }
	  @RequestMapping(value="/users")
	  public List<Resource<User>> allUser(){
		  List<User> users=userDao.getUsers();
		  List<Resource<User>> userResources=new ArrayList<Resource<User>>();
		  for(User user:users){
			  userResources.add(getUserResource(user));
		  }
	  return userResources;
	  }
	  
	  private Resource<User> getUserResource(User user){
		Resource<User> userResource=new Resource<User>(user);
		userResource.add(linkTo(methodOn(UserController.class).userById(user.getEmailId())).withSelfRel());
		
	  return userResource;
	  }
}

