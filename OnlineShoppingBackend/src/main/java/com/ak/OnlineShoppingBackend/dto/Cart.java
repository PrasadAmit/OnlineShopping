package com.ak.OnlineShoppingBackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private User user;
	@Column(name="grant_total")
	private double grantTotal;
	@Column(name="cart_lines")
	private int cartLines;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getGrantTotal() {
		return grantTotal;
	}
	public void setGrantTotal(double grantTotal) {
		this.grantTotal = grantTotal;
	}
	public int getCartLines() {
		return cartLines;
	}
	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", grantTotal=" + grantTotal + ", cartLines=" + cartLines + "]";
	}	
	}
