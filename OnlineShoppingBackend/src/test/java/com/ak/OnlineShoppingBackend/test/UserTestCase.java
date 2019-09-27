package com.ak.OnlineShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ak.OnlineShoppingBackend.dao.UserDAO;
import com.ak.OnlineShoppingBackend.dto.Address;
import com.ak.OnlineShoppingBackend.dto.Cart;
import com.ak.OnlineShoppingBackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user=null;
	private Cart cart=null;
 	private Address address=null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ak.OnlineShoppingBackend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
 		}
/*	
		@Test
		public void testAdd() {
			user = new User();
			user.setFirstName("Ram");
			user.setLastName("Sita");
			user.setEmail("rs@gmail.com");
			user.setContactNumber("9876543210");
			user.setRole("USER");
			user.setPassword("123456");

			//add the user
			assertEquals("Failed to add user!",true, userDAO.addUser(user));

			address = new Address();
			address.setAddressLineOne("583/A, Suraj Nagar");
			address.setAddressLineTwo("ATM Layout");
			address.setCity("Maysur");
			address.setState("Chennai");
			address.setCountry("India");
			address.setPostalCode("860067");
			address.setBilling(true);

			//link the user with the address using the user id
			//address.setUserId(user.getId());
			address.setUserId(user.getId());
			//add the user
			assertEquals("Failed to add address!",true, userDAO.addAddress(address));

			if(user.getRole().equals("USER")) {
			
			//create a cart for this user
			cart=new Cart();

			cart.setUser(user);

			//add the cart
			assertEquals("Failed to add cart!",true, userDAO.addCart(cart));
				
			//add a shipping address for this user

			address = new Address();
			address.setAddressLineOne("105/B, HSRLayout");
			address.setAddressLineTwo("BTM Layout");
			address.setCity("Bangaluru");
			address.setState("Karnataka");
			address.setCountry("India");
			address.setPostalCode("860068");
			
			//set shipping to true
			address.setShipping(true);

			//link it with the user
			address.setUserId(user.getId());

			//add the user
			assertEquals("Failed to add shipping address!",true, userDAO.addAddress(address));
			}
		}

	}
*/
/*	@Test
	public void testAdd() {
			user = new User();
			user.setFirstName("Ram");
			user.setLastName("Sita");
			user.setEmail("rs@gmail.com");
			user.setContactNumber("9876543210");
			user.setRole("USER");
			user.setPassword("123456");

			
			if(user.getRole().equals("USER")) {
				//create a cart for this user
			
				cart=new Cart();
				
				cart.setUser(user);
				
				//attach cart with user
				user.setCart(cart);
				
				//add the user
				assertEquals("Failed to add cart!",true, userDAO.addUser(user));
		}
	}
	@Test
	public void testUpdateCart() {
		
		//fetch the user by its mail
		user=userDAO.getByEmail("vl@gmail.com");
		
		//get the cart of user
		cart=user.getCart();
		cart.setGrantTotal(5555);
		cart.setCartLines(2);
		
	assertEquals("Failed to update  cart!",true, userDAO.updateCart(cart));
	
	}
*/
	
/*	@Test
	public void testAddAddress() {
		//we need to add an user
			user = new User();
			user.setFirstName("Ram");
			user.setLastName("Sita");
			user.setEmail("rs@gmail.com");
			user.setContactNumber("9876543210");
			user.setRole("USER");
			user.setPassword("123456");

			//add the user
			assertEquals("Failed to add user!",true, userDAO.addUser(user));

			
		
		//we are going to add the address
			address = new Address();
			address.setAddressLineOne("101/A, Suraj Nagar");
			address.setAddressLineTwo("BTM Layout");
			address.setCity("Maysur");
			address.setState("Chennai");
			address.setCountry("India");
			address.setPostalCode("860067");
			address.setBilling(true);
			
			//attached the user to address
			address.setUser(user);
			
			//add the user
			assertEquals("Failed to add address!",true, userDAO.addAddress(address));

		//we are going to add the shipping address

			address = new Address();
			address.setAddressLineOne("102/A, Suraj Nagar");
			address.setAddressLineTwo("BTM Layout");
			address.setCity("Maysur");
			address.setState("Chennai");
			address.setCountry("India");
			address.setPostalCode("860067");

			//set shipping is true
			address.setShipping(true);
			
			//attached the user to address
			address.setUser(user);
			
			//add the user
			assertEquals("Failed to add shipping address!",true, userDAO.addAddress(address));
	}
	
	*/	
/*	@Test
	public void testAddAdddress() { 
	
	user =userDAO.getByEmail("rs@gmail.com");	
	
	address = new Address();
	address.setAddressLineOne("103/A, Suraj Nagar");
	address.setAddressLineTwo("BTM Layout");
	address.setCity("Hosur");
	address.setState("Bangaluru");
	address.setCountry("India");
	address.setPostalCode("860067");

	//set shipping is true
	address.setShipping(true);
	
	//attached the user to address
	address.setUser(user);
	
	//add the user
	assertEquals("Failed to add shipping address!",true, userDAO.addAddress(address));
}
*/
	
	@Test
	public void testGetAddress() {
		user=userDAO.getByEmail("rs@gmail.com");
		
		//add the user
		assertEquals("Failed to fetch the list of address and size doesn't match !",4,
				userDAO.listShippingAddress(user).size());

		//add the user
		assertEquals("Failed to fetch the list of address and size doesn't match !","Bangaluru",
				userDAO.getBillingAddress(user).getCity());

	}
}