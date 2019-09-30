package com.ak.OnlineShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ak.OnlineShoppingBackend.dao.CartLineDAO;
import com.ak.OnlineShoppingBackend.dao.ProductDAO;
import com.ak.OnlineShoppingBackend.dao.UserDAO;
import com.ak.OnlineShoppingBackend.dto.Cart;
import com.ak.OnlineShoppingBackend.dto.CartLine;
import com.ak.OnlineShoppingBackend.dto.Product;
import com.ak.OnlineShoppingBackend.dto.User;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CartLineDAO cartLineDAO=null;
	private static ProductDAO productDAO=null;
	private static UserDAO userDAO=null;
	
	private Product product=null;
	private User user=null;
	private Cart cart=null;
	private CartLine cartLine=null;

	@BeforeClass
	public static void init() {
	context=new AnnotationConfigApplicationContext();
	context.scan("com.ak.OnlineShoppingBackend");
	context.refresh();
	productDAO = (ProductDAO)context.getBean("productDAO");
	userDAO = (UserDAO)context.getBean("userDAO");
	cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
		
	}

	@Test
	public void testAddNewCartLine() {
		//get the user
		user=userDAO.getByEmail("rs@gmail.com"); 
		
		//fetch the cart
		cart=user.getCart();
		
		//get the product
		product=productDAO.get(1);
		
		//create a cartLine
		cartLine=new CartLine();
	
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount()+1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		
		//add the cart
		assertEquals("Failed to add cart!",true, cartLineDAO.add(cartLine));
			
		//update the cart
		cart.setGrantTotal(cart.getGrantTotal()+cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		assertEquals("Failed to update the  cart!",true, cartLineDAO.updateCart(cart));
	
	}

}

