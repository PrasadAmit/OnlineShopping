package com.ak.OnlineShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ak.OnlineShoppingBackend.dao.CategoryDAO;
import com.ak.OnlineShoppingBackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ak.OnlineShoppingBackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	public void testaddCategory() {
		category = new Category();
		//category.setId(5);
		category.setName("Laptop");
		category.setDescription("This is Laptop");
		category.setImageURL("Cat_6.jpg");

		assertEquals("Successfully added category inside the table!", true, categoryDAO.add(category));
	}

	/*@Test
	public void testGetCategory() {

		category = categoryDAO.get(1);
		assertEquals("Successfully fatched a single category from the table!", "Television", category.getName());
	}
*/
	/*
	 * update the category data
	 */
/*	@Test
	public void testupdateCategory() {

		category = categoryDAO.get(4);
		//category.setName("Mobile");
		//category.setActive(false);
		category.setDescription("This is Mobile");
		assertEquals("Successfully updated a single category into the table!", true, categoryDAO.update(category));
	}
 	 
*/
	
/*	//delete the category
	  @Test public void testDeleteCategory() {
	  
	  category = categoryDAO.get(2);
	  assertEquals("Successfully deleted a single category into the table!", true,
	  categoryDAO.delete(category));
	  	  
	  }
	 */
	
	/*  @Test public void testListCategory() {
	  assertEquals("Successfully fetched the list of categories from the table!",3,
	  categoryDAO.list().size());
	  
	  }
	*/ 

/*	@Test
	public void testCRUDCategory() {

		// Adding the category
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is Laptop");
		category.setImageURL("Cat_1.jpg");

		assertEquals("Successfully added category inside the table!", true, categoryDAO.add(category));

		category = new Category();
		category.setName("Radio");
		category.setDescription("This is Radio");
		category.setImageURL("Cat_2.jpg");

		assertEquals("Successfully added category inside the table!", true, categoryDAO.add(category));

		category = new Category();
		category.setName("TV");
		category.setDescription("This is Television");
		category.setImageURL("Cat_3.jpg");

		assertEquals("Successfully added category inside the table!", true, categoryDAO.add(category));


		category = new Category();
		category.setName("Mobile");
		category.setDescription("This is Mobile");
		category.setImageURL("Cat_4.jpg");

		assertEquals("Successfully added category inside the table!", true, categoryDAO.add(category));

		category = new Category();
		category.setName("Pager");
		category.setDescription("This is Pager");
		category.setImageURL("Cat_5.jpg");

		assertEquals("Successfully added category inside the table!", true, categoryDAO.add(category));

*/		// fetching and updating  the category
/*
		category = categoryDAO.get(3);
		//category.setName("TV");
		category.setActive(true);
		assertEquals("Successfully updated a single category into the table!", true, categoryDAO.update(category));

		//delete the category
//		assertEquals("Successfully deleted a single category into the table!", true, categoryDAO.delete(category));

		//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!", 3, categoryDAO.list().size());	
	
	}
*/
	
}
