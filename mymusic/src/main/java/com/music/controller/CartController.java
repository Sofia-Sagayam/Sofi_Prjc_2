package com.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
	@RequestMapping("/add")
	public ModelAndView addToCart(@RequestParam(value = "name", required = false, defaultValue = "world") String name)
	{
	
		ModelAndView mv=new ModelAndView("AddCart");
		
		return mv;
	}
	
	@RequestMapping("/chck")
	public ModelAndView chckOut(@RequestParam(value = "name", required = false, defaultValue = "world") String name)
	{
	
		ModelAndView mv=new ModelAndView("CheckOut");
		
		return mv;
	}
	
	@RequestMapping("/pay")
	public ModelAndView payCash(@RequestParam(value = "name", required = false, defaultValue = "world") String name)
	{
	
		ModelAndView mv=new ModelAndView("Payment");
		
		return mv;
	}
	@RequestMapping("/deal")
	public ModelAndView confirmDeal(@RequestParam(value = "name", required = false, defaultValue = "world") String name)
	{
	
		ModelAndView mv=new ModelAndView("Confirm");
		
		return mv;
	}
}
