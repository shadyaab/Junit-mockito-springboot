package com.sady.junit.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sady.junit.bean.Cart;
import com.sady.junit.dao.CartDao;
import com.sady.junit.exception.InvalidCartId;
import com.sady.junit.service.CartServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceImplTestCase {

	@InjectMocks
	private CartServiceImpl service;

	@Mock
	private CartDao cartDao;

	@Before
	public void init() {
		System.out.println("It will be executed before every test method is called");
		// MockitoAnnotations.initMocks(this);
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("It will be executed only once");
	}

	@Test
	public void testGetCartDetails() {

		when(cartDao.getCartDetail()).thenReturn(new Cart(1, "IphoneX", 99999, 2));

		Cart cart = service.getCartDetail();

		Assert.assertEquals(cart.getCartId(), 1);
		
		//It will verify number of time certain method is been called
		verify(cartDao, times(1)).getCartDetail();
	}

	@Test
	public void testGetCartTotalPrice_return_result() throws InvalidCartId {

		when(cartDao.getCartSize()).thenReturn(2);

		when(cartDao.getItemPrice(2)).thenReturn(500.0f);
		when(cartDao.getQuantity(2)).thenReturn(2);

		Assert.assertEquals(1000.0f, service.getCartTotalPrice(2), 0.2f);
		
		//It will verify the exact argument being passed
		verify(cartDao, times(1)).getItemPrice(2);
	}

	@Test(expected=InvalidCartId.class)
	public void testGetCartTotalPrice_throw_exception() throws InvalidCartId {

		when(cartDao.getCartSize()).thenReturn(1);

		//when(cartDao.getItemPrice(2)).thenReturn(500.0f);
		//when(cartDao.getQuantity(2)).thenReturn(2);

		service.getCartTotalPrice(2);
	}


}
