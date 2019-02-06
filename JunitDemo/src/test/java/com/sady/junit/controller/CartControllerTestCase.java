package com.sady.junit.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sady.junit.exception.InvalidCartId;
import com.sady.junit.service.CartService;

@RunWith(SpringRunner.class)
@WebMvcTest(CartController.class)
public class CartControllerTestCase {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CartService service;
	
	@Test 
	public void testGetDetail() throws Exception {
	  
		this.mockMvc 
			.perform(get("/getCartDetail")) 
			.andDo(print())
			.andExpect(status().isOk());
			//.andExpect(MockMvcResultMatchers.jsonPath("cartId").value(1)); 
	}
	  
	@Test public void testGetCartTotalPrice_when_CartId_1() throws Exception {
	  
		this.mockMvc 
			.perform(get("/getCartPrice/{cartId}", 1)) 
			.andDo(print())
			.andExpect(status().isOk()); }
	 
	
	@Test
	public void testGetCartTotalPrice_when_throwsException() throws Exception{
		
		when(service.getCartTotalPrice(7)).thenThrow(InvalidCartId.class);
		
		this.mockMvc
			.perform(get("/getCartPrice/{cartId}", 7))
			.andDo(print())
			.andExpect(status().isBadRequest());
			
	}
	
	
	
}
