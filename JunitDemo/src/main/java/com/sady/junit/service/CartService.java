package com.sady.junit.service;

import com.sady.junit.bean.Cart;
import com.sady.junit.exception.InvalidCartId;

public interface CartService {

	public Cart getCartDetail();

	public float getCartTotalPrice(int cartId) throws InvalidCartId;

}
