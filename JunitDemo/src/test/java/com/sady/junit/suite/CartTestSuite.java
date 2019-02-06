package com.sady.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sady.junit.controller.CartControllerTestCase;
import com.sady.junit.controller.CartServiceImplTestCase;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CartServiceImplTestCase.class,
	CartControllerTestCase.class
})
public class CartTestSuite {

}
