package com.sady.junit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sady.junit.bean.Cart;
import com.sady.junit.dao.CartDao;
import com.sady.junit.exception.InvalidCartId;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;

	@Override
	public Cart getCartDetail() {
		return cartDao.getCartDetail();
	}

	@Override
	public float getCartTotalPrice(int cartId) throws InvalidCartId {

		if (!isValidCartId(cartId)) {
			throw new InvalidCartId("Invalid Cart Id - [" + cartId + "]");
		}

		float price = cartDao.getItemPrice(cartId);

		int quantity = cartDao.getQuantity(cartId); 

		return price * quantity;
	}

	private boolean isValidCartId(int cartId) {
		if (cartId <= cartDao.getCartSize()) {
			return true;
		}

		return false;
	}
	
}
