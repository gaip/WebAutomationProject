package com.propine.parser.utils;

import com.propine.parser.bo.TestcaseBO;
import com.propine.parser.listeners.CustomListeners;

public class TestCaseUtil {

	public static TestcaseBO updateTestCaseDetails() {
		TestcaseBO testcaseBO = new TestcaseBO();

		String testcaseName = getMethodName();
		int currentInvocationCount = getCurrentInvocationCount(testcaseName);

		testcaseBO.setTestcaseName(testcaseName);
		testcaseBO.setInvocationNumber(currentInvocationCount);

		return testcaseBO;
	}

	private static String getTestCaseName() {
		String testcaseName = getMethodName();
		return testcaseName;
	}

	private static int getCurrentInvocationCount(String testcaseName) {
		return CustomListeners.testcaseInvocationCount.get(testcaseName);
	}

	private static String getMethodName() {
		return Thread.currentThread().getStackTrace()[3].getMethodName();
	}


}
