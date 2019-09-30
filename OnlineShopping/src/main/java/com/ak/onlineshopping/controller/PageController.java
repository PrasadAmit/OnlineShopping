package com.ak.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ak.OnlineShoppingBackend.dao.CategoryDAO;
import com.ak.OnlineShoppingBackend.dao.ProductDAO;
import com.ak.OnlineShoppingBackend.dto.Category;
import com.ak.OnlineShoppingBackend.dto.Product;
import com.ak.onlineshopping.exception.ProductNotFoundException;

@Controller
public class PageController {

	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title","Home");

		logger.info("Inside PageController index method  - INFO");
		logger.debug("Inside PageController index method  - DEBUG");
		// passing the list of categories
		mav.addObject("categories", categoryDAO.list());
		mav.addObject("userClickHome", true);
		return mav;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "About Us");
		mav.addObject("userClickAbout", true);
		return mav;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Contact Us");
		mav.addObject("userClickContact", true);
		return mav;
	}

	/*
	 * Methods to all the products and based on category
	 */

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "All Products");

		// passing the list of categories
		mav.addObject("categories", categoryDAO.list());
		mav.addObject("userClickAllProducts", true);
		return mav;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("page");

		// categoryDAO to fetch a single category
		Category category = null;

		category = categoryDAO.get(id);

		mav.addObject("title", category.getName());

		// passing the list of categories
		mav.addObject("categories", categoryDAO.list());

		// passing the single categories
		mav.addObject("category", category);

		mav.addObject("userClickCategoryProducts", true);
		return mav;
	}

	/*Viewing a single product */
	
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProducts(@PathVariable int id) throws ProductNotFoundException {
		ModelAndView mav = new ModelAndView("page");
		
		Product  product = productDAO.get(id);
		
		//customised Exception
		if(product==null) throw new ProductNotFoundException();
		
		//update the view count
		product.setViews(product.getViews()+ 1);
		productDAO.update(product);
		
		mav.addObject("title", product.getName());
		mav.addObject("product", product);
		
		mav.addObject("userClickShowProducts", true);
		return mav;
	}
}

