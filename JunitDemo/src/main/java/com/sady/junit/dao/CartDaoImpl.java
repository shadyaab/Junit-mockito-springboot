package com.sady.junit.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sady.junit.bean.Cart;

@Repository
public class CartDaoImpl implements CartDao {

	private static Map<Integer, Cart> cartMap;

	static {
		cartMap = new HashMap<>();
		cartMap.put(1, new Cart(1, "pixel2", 40000, 4));
		cartMap.put(2, new Cart(2, "oneplus6", 35000.4f, 3));
	}

	@Override
	public Cart getCartDetail() {
		return cartMap.get(1);
	}

	@Override
	public float getItemPrice(int cartId) {
		return cartMap.get(cartId).getPrice();
	}

	@Override
	public int getQuantity(int cartId) {
		return cartMap.get(cartId).getQuantity();
	}

	@Override
	public int getCartSize() {
		return cartMap.size();
	}

}
