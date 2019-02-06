package com.sady.junit.dao;

import com.sady.junit.bean.Cart;

public interface CartDao {

	public Cart getCartDetail();

	public float getItemPrice(int cartId);
	
	public int getQuantity(int cartId);

	public int getCartSize();
	
}
