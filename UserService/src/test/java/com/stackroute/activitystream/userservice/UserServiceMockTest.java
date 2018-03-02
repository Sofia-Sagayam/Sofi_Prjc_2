package com.stackroute.activitystream.userservice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

import com.google.gson.Gson;
import com.stackroute.activitystream.UserService.UserServiceApplication;
import com.stackroute.activitystream.servicesbackend.dao.UserDao;
import com.stackroute.activitystream.servicesbackend.model.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=UserServiceApplication.class)
@WebAppConfiguration
public class UserServiceMockTest {
	 @Autowired
	    private WebApplicationContext wac;
	    private MockMvc mockMvc;
	    @Autowired
		private UserDao userDao;
	    @Before
	    public void setup() {
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	    }
	    @Test
	    public void getAllUserTest() throws Exception {
	    	this.mockMvc.perform(get("http://localhost:9005/alluser"))
	         .andExpect(status().isOk())
	         .andExpect(content().contentType("application/json;charset=UTF-8"));
	    	}
	    @Test
	    public void signUp() throws Exception{
	    	User user=new User();
	    	user.setUserName("sweta");
	    	user.setEmailId("mocktest@gmail.com");
	    	user.setUserPass("sweta@123");
	    	user.setUserAddress("sweta street mockmvc");
	    	
	    	this.mockMvc.perform(post("http://localhost:9005/signup")
	    	        .contentType(MediaType.APPLICATION_JSON).content(javaToJson(user)))
	    			.andExpect(status().isCreated());
	    			
	    }
	    @Test
	    public void signIn() throws Exception{
	    	User u1=new User();
	    	
	    	
	    	u1.setEmailId("jayashree@niit.com");
	    	u1.setUserPass("jaya#321");
	    //	List<User> users = Arrays.asList(u1);
	    	
	   	        mockMvc.perform(get("http://localhost:9005/signin"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
	                .andExpect(jsonPath("$", hasSize(1)))
	                .andExpect(jsonPath("$[0].emailId", is("jayashree@niit.com")))
	                .andExpect(jsonPath("$[0].userPass", is("jaya#321")));
	    	
	    	
	    }
	    
	    // json convertion method
	    private String javaToJson(User user){
	    	Gson gson = new Gson();
	        String json = gson.toJson(user);
	        System.out.println(json);
	        return json;
	    }
}
