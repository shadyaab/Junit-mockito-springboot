package com.sady.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sady.junit.controller.CartServiceImplTestCase;
import com.sady.junit.controller.MockVsSpyTestCase;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	MockVsSpyTestCase.class,
	CartServiceImplTestCase.class
})
public class MockVsSpyTestSuite {

}
