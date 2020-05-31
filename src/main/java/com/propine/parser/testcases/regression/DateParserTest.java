package com.propine.parser.testcases.regression;

import com.propine.parser.bo.TestcaseBO;
import com.propine.parser.componentFlow.FlowDateParser;
import com.propine.parser.dataProvider.TestDataProvider;
import com.propine.parser.driverManager.DriverManager;
import com.propine.parser.services.ExecutionService;
import com.propine.parser.utils.TestCaseUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DateParserTest extends TestDataProvider {

	Logger logger = Logger.getLogger(DateParserTest.class);

	@Test(dataProvider = "parseTestData")
	public void dateParserTest(String testValue, String expectedResult) {
		logger.info("Validating test with testValue::" + testValue + " | Expected Result:: " + expectedResult);
		WebDriver driver = null;
		DriverManager driverManager = null;
		TestcaseBO testcaseBO = null;

		try {
			// to get current testcase details
			testcaseBO = TestCaseUtil.updateTestCaseDetails();
			testcaseBO.setTestValue(testValue);
			testcaseBO.setExpectedResult(expectedResult);

			// manager object
			driverManager = new DriverManager();

			// driver for current testcase
			driver = driverManager.loadHomePage();

			// perform execution steps
			String actualResult = FlowDateParser.submitTextAndReturnResult(driver, testValue);
			testcaseBO.setActualResult(actualResult);

			// assert on value
			Assert.assertEquals(actualResult, expectedResult);

			// mark testcase as success
			ExecutionService.executionSuccess(driver, testcaseBO);

		} catch (AssertionError ae) {
			// mark testcase as fail
			ExecutionService.executionFailure(driver, testcaseBO);
		} catch (Exception e) {
			// mark testcase as fail and display error
			ExecutionService.exceptionOccurred(driver, testcaseBO, e);
		} finally {
			// quit driver
			driverManager.quitDriver(driver);
		}
	}
}
