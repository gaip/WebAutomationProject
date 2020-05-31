package com.propine.parser.coreResource.services;

import com.propine.parser.bo.TestcaseBO;
import com.propine.parser.constants.TestExecutionStatus;
import com.propine.parser.coreResource.reporting.ExecutionReport;
import com.propine.parser.utils.Screenshot;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ExecutionService {

	private static Logger logger = Logger.getLogger(ExecutionService.class);

	/**
	 * Update result if testcase executed properly
	 *
	 * @param driver     WebDriver
	 * @param testcaseBO Testcase details
	 */
	public static void executionSuccess(WebDriver driver, TestcaseBO testcaseBO) {
		// update execution status
		testcaseBO.setExecutionStatus(TestExecutionStatus.PASS);

		// add testcase to report list
		addTestCaseForReporting(testcaseBO);

		// take screenshot of last step.
		Screenshot.capture(driver, testcaseBO.getScreenShotNamePrefix() + "SUCCESS");
	}

	/**
	 * Update result if testcase executed with failures.
	 *
	 * @param driver     WebDriver
	 * @param testcaseBO testcase details
	 */
	public static void executionFailure(WebDriver driver, TestcaseBO testcaseBO) {
		// update execution status
		testcaseBO.setExecutionStatus(TestExecutionStatus.FAIL);

		// take screenshot of last step
		Screenshot.capture(driver, testcaseBO.getScreenShotNamePrefix() + "FAILURE");

		// add testcase to report list
		addTestCaseForReporting(testcaseBO);

		// failing testcase
		Assert.fail("Testcase execution failed!");
	}

	/**
	 * Mark testcase as failed and add to report list when exception occured
	 *
	 * @param driver     WebDriver
	 * @param testcaseBO testcase Details
	 * @param e          Exception Generated
	 */
	public static void exceptionOccurred(WebDriver driver, TestcaseBO testcaseBO, Exception e) {

		// print log with exception received
		logger.error("Exception occurred while executing testcase:: " + testcaseBO.getTestcaseName(), e);

		// mark testcase as failed
		executionFailure(driver, testcaseBO);
	}

	/**
	 * Add testcase to reporting list
	 *
	 * @param testcaseBO testcase details
	 */
	private static void addTestCaseForReporting(TestcaseBO testcaseBO) {
		ExecutionReport.testcaseList.add(testcaseBO);
	}


}
