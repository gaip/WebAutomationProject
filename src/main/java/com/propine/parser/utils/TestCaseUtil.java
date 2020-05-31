package com.propine.parser.utils;

import com.propine.parser.bo.TestcaseBO;
import com.propine.parser.listeners.CustomListeners;

public class TestCaseUtil {

	/**
	 * Add current testcase details to the object
	 *
	 * @return Updated Testcase details
	 */
	public static TestcaseBO updateTestCaseDetails() {
		TestcaseBO testcaseBO = new TestcaseBO();

		String testcaseName = getMethodName();
		int currentInvocationCount = getCurrentInvocationCount(testcaseName);

		testcaseBO.setTestcaseName(testcaseName);
		testcaseBO.setInvocationNumber(currentInvocationCount);
		testcaseBO.setScreenShotNamePrefix(testcaseName + "_" + currentInvocationCount + "/");

		return testcaseBO;
	}

	/**
	 * Get Testcase name
	 *
	 * @return testcase name
	 */
	private static String getTestCaseName() {
		String testcaseName = getMethodName();
		return testcaseName;
	}

	/**
	 * Get Invocation Count of testcase
	 *
	 * @param testcaseName Testcase Name
	 * @return Current Invocation Count
	 */
	private static int getCurrentInvocationCount(String testcaseName) {
		return CustomListeners.testcaseInvocationCount.get(testcaseName);
	}

	/**
	 * Get method name from the stack trace
	 *
	 * @return testcase Name
	 */
	private static String getMethodName() {
		return Thread.currentThread().getStackTrace()[3].getMethodName();
	}


}
