package com.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.music.model.FileUpload;
import com.music.model.Music;

@Controller
public class FileUploadController  {
	@ModelAttribute("fileUploadForm")//This refers to command name which we gave 
	public FileUpload create()
	{
	return new FileUpload();//creating a model object
	}
	 
	@RequestMapping(value={"/upload"},method=RequestMethod.POST)
	public ModelAndView addingGenre(@ModelAttribute("gen") FileUpload gen)
	{
			MultipartFile mpf=gen.getFile();
			String filename="";
			if(mpf!=null)
			{
				filename=mpf.getOriginalFilename();
			}
			return new ModelAndView("FileSucc","fileName",filename);
	}
}
