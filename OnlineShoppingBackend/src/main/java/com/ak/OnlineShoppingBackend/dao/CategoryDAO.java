package com.ak.OnlineShoppingBackend.dao;

import java.util.List;

import com.ak.OnlineShoppingBackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);
}
