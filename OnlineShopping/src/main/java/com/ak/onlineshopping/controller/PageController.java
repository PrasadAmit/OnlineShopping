package com.ak.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index(){
		ModelAndView mav= new ModelAndView("page");
		mav.addObject("title", "Home");
		mav.addObject("userClickHome",true);
		return mav;
	}	
	@RequestMapping(value= "/about")
	public ModelAndView about(){
		ModelAndView mav= new ModelAndView("page");
		mav.addObject("title", "About Us");
		mav.addObject("userClickAbout",true);
		return mav;
	}	
	@RequestMapping(value= "/contact")
	public ModelAndView contact(){
		ModelAndView mav= new ModelAndView("page");
		mav.addObject("title", "Contact Us");
		mav.addObject("userClickContact",true);
		return mav;
	}	
}
