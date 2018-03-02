package com.music.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.music.DAO.MusicDaoImpl;
import com.music.model.Music;
import com.music.model.UserDetail;
import com.music.service.MusicServDao;
import com.music.service.MusicServDaoImpl;
import com.music.service.UserServDao;





@Controller
public class MusicController {
	@Autowired
	MusicServDao mdi;
	@Autowired
	UserServDao udi;
	
	public MusicController(){
	
	}
	int all;
	String toreturn;
	List<Music> one=new ArrayList<Music>();
	List<Music> two=new ArrayList<Music>();
	List<Music> three=new ArrayList<Music>();
	List<Music> alll=new ArrayList<Music>();
	
	MusicDaoImpl md=new MusicDaoImpl();
	Music holder;
	
		Gson g=new Gson();
@RequestMapping("/hiphop")
public ModelAndView myMap1(@RequestParam(value = "name", required = false, defaultValue = "world") String name)
{
 all=Integer.parseInt(name);
	ModelAndView mv=new ModelAndView("Genre");
	mv.addObject("hello","hello");
	return mv;
}
@RequestMapping("/jazz")
public ModelAndView myMap2(@RequestParam(value = "name", required = false, defaultValue = "world") String name)
{
	all=Integer.parseInt(name);
	ModelAndView mv=new ModelAndView("Genre");
	mv.addObject("hello","hello");
	return mv;
}

@RequestMapping("/rock")
public ModelAndView myMap3(@RequestParam(value = "name", required = false, defaultValue = "world") String name)
{
	all=Integer.parseInt(name);
	ModelAndView mv=new ModelAndView("Genre");
	mv.addObject("hello","hello");
	return mv;
}

@RequestMapping("/all")
public ModelAndView myMap4(@RequestParam(value = "name", required = false, defaultValue = "world") String name)
{
	all=Integer.parseInt(name);
	
	ModelAndView mv=new ModelAndView("Genre");
	mv.addObject("hello","hello");
	return mv;
}

@RequestMapping("/ud")
public ModelAndView myMapUD(@RequestParam(value = "name", required = false, defaultValue = "12") String name)
{
	all=Integer.parseInt(name);
	
	ModelAndView mv=new ModelAndView("UserD");
	mv.addObject("hello","hello");
	return mv;
}


@RequestMapping("/Music")
public @ResponseBody String getValues()
{
	switch(all)
	{
	case 1:
		holder=mdi.getGenrebyId("gen001");
		
		one.add(holder);
		toreturn=g.toJson(one);
		break;
	case 2:
		holder=mdi.getGenrebyId("gen002");
		
		two.add(holder);
		toreturn=g.toJson(two);
		break;
	case 3:
		holder=mdi.getGenrebyId("gen003");
		
		three.add(holder);
		toreturn=g.toJson(three);
		break;
	case 4:
		alll=mdi.listMusic();
		toreturn=g.toJson(alll);
		break;
		
	}
	
	
	return toreturn;
}

@RequestMapping("/usr")
public @ResponseBody String getUsr()
{
	List<UserDetail> listU=udi.listUser();
	return g.toJson(listU);
}
/*@RequestMapping("/admin")
public ModelAndView adminMap(@RequestParam(value = "name", required = false, defaultValue = "1") String name)
{  
	all=Integer.parseInt(name);
		ModelAndView mv=new ModelAndView("AdminTrax");
	mv.addObject("hello","hello");
	return mv;
}*/
@RequestMapping("/insert")
public ModelAndView insertMap(@RequestParam(value = "name", required = false, defaultValue = "1") String name)
{
	
	all=Integer.parseInt(name);
		ModelAndView mv=new ModelAndView("Insersion");
	mv.addObject("hello","hello");
	return mv;
}

@RequestMapping("/insertU")
public ModelAndView insertMapUser(@RequestParam(value = "name", required = false, defaultValue = "1") String name)
{
	all=Integer.parseInt(name);
		ModelAndView mv=new ModelAndView("InsertUser");
	mv.addObject("hello","hello");
	return mv;
}


String assignValue="";
int av=0;

@RequestMapping("/Update")
public ModelAndView updateMap(@RequestParam String gid,@ModelAttribute("m") Music m,BindingResult res)
{
	assignValue = gid;
	Music muc=mdi.getGenrebyId(gid);
	
	ModelAndView mv=new ModelAndView("Update","mobj",muc);
	mv.addObject("hello","hello");
	return mv;
}

@RequestMapping("/UpUser")
public ModelAndView updateUsr(@RequestParam int uid,@ModelAttribute("u") UserDetail u,BindingResult res)
{
	av =uid;
	UserDetail usd=udi.getUserbyId(uid);
	
		ModelAndView mv=new ModelAndView("UserUpdate","uobj",usd);
	mv.addObject("hello","hello");
	return mv;
}

@RequestMapping("/Delete")
public ModelAndView deleteMap(@RequestParam String gid,@ModelAttribute("m") Music m,BindingResult res)
{

	mdi.removeGenre(gid);
	
	ModelAndView mv=new ModelAndView("succ");
	mv.addObject("hello","hello");
	return mv;
}
@RequestMapping("/DelUser")
public ModelAndView deleteMapUser(@RequestParam int uid,@ModelAttribute("u") UserDetail ud,BindingResult res)
{
	udi.removeUser(uid);
		ModelAndView mv=new ModelAndView("succ");
	mv.addObject("hello","hello");
	return mv;
}
@RequestMapping("/succ")
public ModelAndView succMap(@RequestParam(value = "name", required = false, defaultValue = "1") String name)
{
	all=Integer.parseInt(name);
	
	ModelAndView mv=new ModelAndView("succ");
	mv.addObject("hello","hello");
	return mv;
}


@ModelAttribute("music")//This refers to command name which we gave 
public Music create()
{
return new Music();//creating a model object
}
 
@RequestMapping(value={"/musicMap"},method=RequestMethod.POST)
public ModelAndView addingGenre(@ModelAttribute("gen") Music gen)
{
		mdi.addGenre(gen);
	return new ModelAndView("succ");
}

@ModelAttribute("user")//This refers to command name which we gave 
public UserDetail createUser()
{
return new UserDetail();//creating a model object
}

@RequestMapping(value={"/userMap"},method=RequestMethod.POST)
public ModelAndView addingUser(@ModelAttribute("usr") UserDetail usr)
{
	
	udi.addUser(usr);
	return new ModelAndView("succ");
}

@RequestMapping(value={"/upd"},method=RequestMethod.POST)
public ModelAndView updatingGenre(@ModelAttribute Music m)
{
	m.setGenreid(assignValue);
	mdi.updateGenre(m);
	return new ModelAndView("succ");
}
@RequestMapping(value={"/updu"},method=RequestMethod.POST)
public ModelAndView updatingUser(@ModelAttribute UserDetail u)
{
	u.setUid(av);
	udi.updateUser(u);
	return new ModelAndView("succ");
}
@RequestMapping("/sign")
public ModelAndView signIn(@RequestParam(value = "name", required = false, defaultValue = "world") String name)
{
	ModelAndView mv=null;
	
	if(name.equals("1"))
	{
	mv=new ModelAndView("SignIn");	
	} 
	else if(name.equals("2"))
	{
	mv= new ModelAndView("SignUp");
	}
	return mv;
}


}
