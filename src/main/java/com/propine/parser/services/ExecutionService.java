package com.propine.parser.services;

import com.propine.parser.bo.TestcaseBO;
import com.propine.parser.constants.TestExecutionStatus;
import com.propine.parser.reporting.ExecutionReport;
import com.propine.parser.utils.Screenshot;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ExecutionService {

	private static Logger logger = Logger.getLogger(ExecutionService.class);

	public static void executionSuccess(WebDriver driver, TestcaseBO testcaseBO) {
		testcaseBO.setExecutionStatus(TestExecutionStatus.PASS);
		addTestCaseForReporting(testcaseBO);
	}

	public static void executionFailure(WebDriver driver, TestcaseBO testcaseBO) {
		testcaseBO.setExecutionStatus(TestExecutionStatus.FAIL);
		Screenshot.capture(driver, testcaseBO.getTestcaseName() + "_" + testcaseBO.getInvocationNumber() + "/" +
				"failure");
		addTestCaseForReporting(testcaseBO);

		// failing testcase
		Assert.fail("Testcase execution failed!");
	}

	public static void exceptionOccurred(WebDriver driver, TestcaseBO testcaseBO, Exception e) {
		logger.error("Exception occurred while executing testcase:: " + testcaseBO.getTestcaseName(), e);
		executionFailure(driver, testcaseBO);
	}

	private static void addTestCaseForReporting(TestcaseBO testcaseBO) {
		ExecutionReport.testcaseList.add(testcaseBO);
	}


}
