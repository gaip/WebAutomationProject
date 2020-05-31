package com.propine.parser.componentFlow;

import com.propine.parser.bo.TestcaseBO;
import com.propine.parser.component.DateParser;
import org.openqa.selenium.WebDriver;

public class FlowDateParser {

	/**
	 * Steps to validate scenario
	 *
	 * @param driver    WebDriver
	 * @param testValue value to check
	 * @return generated result
	 */
	public static String submitTextAndReturnResult(WebDriver driver, TestcaseBO testcaseBO, String testValue) {
		DateParser dateParser = new DateParser(driver);

		// fill test value
		dateParser.enterDate(testcaseBO, testValue);

		// submit value
		dateParser.clickSubmitButton(testcaseBO);

		// fetch value
		return dateParser.fetchResult(testcaseBO);
	}
}
