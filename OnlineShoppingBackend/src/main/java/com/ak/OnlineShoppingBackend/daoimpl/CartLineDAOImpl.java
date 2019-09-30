package com.ak.OnlineShoppingBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ak.OnlineShoppingBackend.dao.CartLineDAO;
import com.ak.OnlineShoppingBackend.dto.Cart;
import com.ak.OnlineShoppingBackend.dto.CartLine;

@Repository("cartLineDAO")
@Transactional
public class CartLineDAOImpl implements CartLineDAO {

	@Autowired
	private SessionFactory sessionFactory; 
		
	@Override
	public CartLine get(int id) {
		return 	sessionFactory.getCurrentSession().get(CartLine.class, id);
	}

	@Override
	public boolean add(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
			}
		catch(Exception ex){
		 	ex.printStackTrace();		
		return false;
		}
	}

	@Override
	public boolean update(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
			}
		catch(Exception ex){
		 	ex.printStackTrace();		
		return false;
		}}

	@Override
	public boolean delete(CartLine cartLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CartLine> list(int cartId) {
		String selectQuery="FROM  CartLine WHERE cartId= :cartId ";
		 return sessionFactory.getCurrentSession()
			.createQuery(selectQuery, CartLine.class)
			.setParameter("cartId", cartId)
			.setParameter("shipping", true)
			.getResultList();
			}
	
	@Override
	public List<CartLine> listAvailable(int cartId) {
		String selectQuery="FROM  CartLine WHERE cartId= :cartId AND available = :available";
		 return sessionFactory.getCurrentSession()
			.createQuery(selectQuery, CartLine.class)
			.setParameter("cartId", cartId)
			.setParameter("available", true)
			.getResultList();
			}
	
	@Override
	public CartLine getByCartandProduct(int cartId, int productId) {

		String selectQuery="FROM  CartLine WHERE cartId= :cartId AND product.Id= :productId";
		try {
		return sessionFactory.getCurrentSession()
			.createQuery(selectQuery, CartLine.class)
				.setParameter("cartId", cartId)
					.setParameter("productId", productId)
						.getSingleResult();
		}
	catch(Exception ex){
	return null;
	}
}
	//related to the cart
		public boolean updateCart(Cart cart) {
			try {
				sessionFactory.getCurrentSession().update(cart);
				return true;
				}
			catch(Exception ex){
				ex.printStackTrace();		
			return false;
			}
		}
	
}