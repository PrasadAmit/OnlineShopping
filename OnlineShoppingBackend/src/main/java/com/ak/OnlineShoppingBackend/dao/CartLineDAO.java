package com.ak.OnlineShoppingBackend.dao;

import java.util.List;

import com.ak.OnlineShoppingBackend.dto.Cart;
import com.ak.OnlineShoppingBackend.dto.CartLine;

public interface CartLineDAO {

	//the common methods from previously coded one
	public CartLine get(int id);
	public boolean add(CartLine cartLine); 
	public boolean update(CartLine cartLine); 
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);

	//other business methods related to the cart lines
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartandProduct(int cartId, int productId);

	//update a Cart
		boolean updateCart(Cart cart);

}
