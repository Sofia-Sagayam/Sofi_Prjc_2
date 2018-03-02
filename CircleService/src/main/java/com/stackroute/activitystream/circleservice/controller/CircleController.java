package com.stackroute.activitystream.circleservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activitystream.servicesbackend.dao.CircleDao;
import com.stackroute.activitystream.servicesbackend.model.Circle;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CircleController {
	@Autowired
	private CircleDao circleDao;
	
	@RequestMapping(value="/allCircles",method = RequestMethod.GET)
	public ResponseEntity<List<Circle>> getCustomers() {
		List<Circle> circles=circleDao.getAllCircle();
		return new ResponseEntity<List<Circle>>(circles, HttpStatus.OK);
	}
	
	@RequestMapping(value="/createCircle",method= RequestMethod.POST)
	  public ResponseEntity<String> createCircle(@RequestBody Circle circle){
		if(circleDao.addCircle(circle))
		{
		return new ResponseEntity<String>("circle created successfully!!..",HttpStatus.CREATED);
	  }
		return new ResponseEntity<String>("pls try again....",HttpStatus.NOT_ACCEPTABLE);
		
	  }
	
	  @RequestMapping(value="/updateCircle",method= RequestMethod.PUT)
	  public ResponseEntity<String> updateUser(@RequestBody Circle circle){
		  if(circleDao.updateCircle(circle)){
		return new ResponseEntity<String>("updated successfully...",HttpStatus.OK);
		}
		return new ResponseEntity<String>("oops plss try again...",HttpStatus.NOT_FOUND);
				
	  }
	  
	  @DeleteMapping(value="/deleteCircle/{id}")
	  public ResponseEntity<String> deleteUser(@PathVariable("id") String id){
		 
		  if(circleDao.removeCircle(id)){
		return new ResponseEntity<String>("deleted successfully,,,",HttpStatus.OK);
		}
		return new ResponseEntity<String>("oops pls try again...",HttpStatus.NOT_FOUND);
				
	  }
	  

}
