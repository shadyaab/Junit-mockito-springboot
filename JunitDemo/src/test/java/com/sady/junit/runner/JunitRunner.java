package com.sady.junit.runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.sady.junit.suite.CartTestSuite;
import com.sady.junit.suite.MockVsSpyTestSuite;

public class JunitRunner {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(
				CartTestSuite.class,
				MockVsSpyTestSuite.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println("Test was successfull: " + result.wasSuccessful());

	}

}
