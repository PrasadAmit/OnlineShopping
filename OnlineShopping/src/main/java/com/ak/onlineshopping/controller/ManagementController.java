package com.ak.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ak.OnlineShoppingBackend.dao.CategoryDAO;
import com.ak.OnlineShoppingBackend.dao.ProductDAO;
import com.ak.OnlineShoppingBackend.dto.Category;
import com.ak.OnlineShoppingBackend.dto.Product;
import com.ak.onlineshopping.util.FileUploadUtility;
import com.ak.onlineshopping.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	public ProductDAO productDAO;

	// Showing the Product Saved in Database

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mav = new ModelAndView("page");

		mav.addObject("userClickManageProducts", true);
		mav.addObject("{title}", "Manage Products");
		Product nProduct = new Product();

		// set few of the fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mav.addObject("product", nProduct);

		if (operation != null) {
			if (operation.equals("product")) {
				mav.addObject("message", "Product Submitted Successfully");
			} else if (operation.equals("category")) {
				mav.addObject("message", "Category Submitted Successfully");
			}
		}
		return mav;
	}
	
	// Editing Saved Product
	@RequestMapping(value = "/{id}/product/", method = RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id) {

		ModelAndView mav = new ModelAndView("page");
		mav.addObject("userClickManageProducts", true);
		mav.addObject("{title}", "Manage Products");

		// fetch the product from the database
		Product nProduct = productDAO.get(id);
		// set the Product fetched from database
		mav.addObject("product", nProduct);
		return mav;
	}

	// Handling product submission

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model, HttpServletRequest request) {
		if (mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
		} else {
			if (!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, results);
			}
		}

		// check for there are any errors
		if (results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("{title}", "Manage Products");
			model.addAttribute("message", "Validation failed for Product Submitions");
			return "page";
		}

		if (mProduct.getId() == 0) {
			// create a new product if id is 0
			productDAO.add(mProduct);
		} else {
			// update the product if id is not 0
			productDAO.update(mProduct);
		}

		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		return "redirect:/manage/products?operation=product";
	}

	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		// Is going to fetch the product from database
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		// activating and deactivating based on the active field of product
		product.setActive(!product.isActive());
		// active the product
		productDAO.update(product);

		return (isActive) ? "You have successfully deactivate the product with id" + product.getId()
				: "You have successfully activate the product with id" + product.getId();

	}

	// To handle category submission
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		// add the new category
		categoryDAO.add(category);

		return "redirect:/manage/products?operation=category";
	}

	// returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();

	}

	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
}
 