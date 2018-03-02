package com.music.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.music.model.RUser;
import com.music.model.UserDetail;
import com.music.service.UserServDao;

@Controller
@RequestMapping(value="/SignUp")
public class RController {
	@Autowired
	UserServDao udi;
	
	UserDetail ud=new UserDetail();
	@RequestMapping(method=RequestMethod.GET)
    public String showForm(ModelMap model){
        RUser user = new RUser();
        model.addAttribute("USER", user);
        return "registration";
    }

    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView processForm(@ModelAttribute(value="USER") @Valid RUser user,BindingResult result){
        if(result.hasErrors()){ 
        	
        	            return new ModelAndView("registration");
        }else{
        	if(user.getPass().equals(user.getcPass()))
        	{
        	ud.setUname(user.getName());
        	ud.setUpass(user.getPass());
        	ud.setUrole("ROLE_USER");
        	addU(ud);
        	return new ModelAndView("succ");
        }
        	else
        	{
        		 return new ModelAndView("registration");
        	}
        }
    }
    
    public void addU(UserDetail u)
    {
    	udi.addUser(u);
    	
    }
}
