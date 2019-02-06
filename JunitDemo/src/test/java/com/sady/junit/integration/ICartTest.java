package com.sady.junit.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
@WebAppConfiguration
public class ICartTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	/*
	 * @Test public void givenWac_whenServletContext_thenItProvidesGreetController()
	 * { ServletContext servletContext = this.context.getServletContext();
	 * 
	 * //System.out.println(servletContext); //System.out.println(servletContext
	 * instanceof MockServletContext); //
	 * System.out.println(this.context.getBean("cartController"));
	 * Assert.assertNotNull(servletContext); Assert.assertTrue(servletContext
	 * instanceof MockServletContext); //
	 * Assert.assertNotNull(this.context.getBean("greetController")); }
	 */

	@Test
	public void test() throws Exception {
		this.mockMvc
			.perform(get("/getCartDetail"))
			.andDo(print())
			.andExpect(status().isOk());
		// .andExpect();

	}

}
