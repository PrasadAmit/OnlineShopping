package com.ak.OnlineShoppingBackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ak.OnlineShoppingBackend.dao.CategoryDAO;
import com.ak.OnlineShoppingBackend.dto.Category;
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		
		// Adding first category
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is television");
		category.setImageURL("Cat_1.jpg");

		categories.add(category);

		// second categories
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is Mobile");
		category.setImageURL("Cat_2.jpg");
		categories.add(category);

		// Third Categories
		category = new Category();	
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is Laptop");
		category.setImageURL("Cat_3.jpg");
		categories.add(category);

	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		
		//enhanced for loop
		for(Category category : categories) {
			if(category.getId() == id)
				return category;
		}
		return null;
	}

}
