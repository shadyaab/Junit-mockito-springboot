package com.sady.junit.controller;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockVsSpyTestCase {
	
	@BeforeClass
	public static void init() {
		System.out.println("MockVsSpyTestCase is executing...");
	}
	
	@AfterClass
	public static void end() {
		System.out.println("MockVsSpyTestCase execution endsssss");
	}
	
	/**
	 * Mock doesn't create any Object, but it just mock the object - (Dummy Object)
	 * Hence, it doesn't persist the state of an object
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testMock() {
		HashMap<Integer, String> mock = Mockito.mock(HashMap.class);
		mock.put(1, "John");
		
		assertEquals(0, mock.size());
	}
	
	/**
	 * Spy creates real Object, hence maintaining the state of an Object
	 * But still you can stub the behavior of a particular method.
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testSpy() {
		
		HashMap<Integer, String> spy = Mockito.spy(HashMap.class);
		spy.put(1, "John");
		
		//when(spy.size()).thenReturn(2);
		
		assertEquals(1, spy.size());
	}

}
