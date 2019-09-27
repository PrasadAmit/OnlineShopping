package com.ak.OnlineShoppingBackend.dao;

import java.util.List;

import com.ak.OnlineShoppingBackend.dto.Address;
import com.ak.OnlineShoppingBackend.dto.Cart;
import com.ak.OnlineShoppingBackend.dto.User;

public interface UserDAO {
	//add an User
	boolean addUser(User user);
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user);
	
	//update a Cart
	boolean updateCart(Cart cart);

}
