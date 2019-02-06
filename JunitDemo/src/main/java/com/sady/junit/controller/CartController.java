package com.sady.junit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sady.junit.bean.Cart;
import com.sady.junit.exception.InvalidCartId;
import com.sady.junit.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService service;

	@RequestMapping("/getCartDetail")
	public ResponseEntity<Cart> getCartDetail() {
		return new ResponseEntity<Cart>(service.getCartDetail(), HttpStatus.OK);
	}

	@RequestMapping("/getCartPrice/{cartId}")
	public ResponseEntity<?> getCartTotalPrice(@PathVariable("cartId") int cartId) {

		float totalPrice = 0.0f;
		try {
			totalPrice = service.getCartTotalPrice(cartId);
		} catch (InvalidCartId e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Float>(totalPrice, HttpStatus.OK);
	}

}
