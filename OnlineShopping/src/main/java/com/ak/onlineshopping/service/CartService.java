package com.ak.onlineshopping.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.OnlineShoppingBackend.dao.CartLineDAO;
import com.ak.OnlineShoppingBackend.dto.Cart;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;

	@Autowired
	private HttpSession session;

/*	private Cart getCart() {
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
*/
}
