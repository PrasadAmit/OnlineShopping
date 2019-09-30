package com.ak.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

	@RequestMapping("/show")
	public ModelAndView showCart() {
		ModelAndView mav=new ModelAndView("page");
		
		mav.addObject("title", "User Cart");
		mav.addObject("userClickShowCart", true);
		mav.addObject("cartLines", null);
		return mav;
	}
}
