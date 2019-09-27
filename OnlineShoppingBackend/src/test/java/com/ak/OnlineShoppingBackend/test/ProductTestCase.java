package com.ak.OnlineShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ak.OnlineShoppingBackend.dao.ProductDAO;
import com.ak.OnlineShoppingBackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ak.OnlineShoppingBackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	/*
	@Test
	public void testCRUDProduct() {

		// Adding the category
		product= new Product();
		product.setName("vivo V2");
		product.setBrand("Vivo");
		product.setDescription("This is vivo camera phone");
		product.setUnitPrice(27000);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(1);
		
		assertEquals("Something went wrong while inserting a new product!",
				true, productDAO.add(product));

			
				//reading and updating product
		
				product = productDAO.get(3);
			// product.setName("Galexy S8");
			//	 product.setActive(false);
		
		assertEquals("Something went wrong while inserting a new product!",
				true, productDAO.update(product));
		

		assertEquals("Something went wrong while inserting a new product!",
				true, productDAO.delete(product));


		//fetching the list
		assertEquals("Something went wrong while inserting a new product!",
				11 , productDAO.list().size());	
		
	}

	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while inserting a new product!", 
				7 , productDAO.listActiveProducts().size());
		}

	
	
	@Test
	public void testListActiveProductsByCategory() {
	
		assertEquals("Something went wrong while inserting a new product!", 
				3 , productDAO.listActiveProductsByCategory(1).size());
		assertEquals("Something went wrong while inserting a new product!", 
				3 , productDAO.listActiveProductsByCategory(2).size());
		assertEquals("Something went wrong while inserting a new product!", 
				0 , productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while inserting a new product!", 
				1 , productDAO.listActiveProductsByCategory(4).size());
	
	}


 // Orderby is not set getting error
  	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while inserting a new product!", 
				 7, productDAO.getLatestActiveProduct
				(7).size());
		}
*/
		}
