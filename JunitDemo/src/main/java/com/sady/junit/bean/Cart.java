package com.sady.junit.bean;

import lombok.Data;

@Data
public class Cart {

	private int cartId;
	private String item;
	private float price;
	private int quantity;

	public Cart() {

	}

	public Cart(int cartId, String item, float price, int quantity) {
		this.cartId = cartId;
		this.item = item;
		this.price = price;
		this.quantity = quantity;
	}

}
