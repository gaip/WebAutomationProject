package com.propine.parser.testcases;

import com.propine.parser.dataProvider.TestDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class DateParserTest extends TestDataProvider {

	Logger logger = LoggerFactory.getLogger(DateParserTest.class);

	@Test(dataProvider = "parseTestData")
	public void dateParserTest(String testValue, String expectedResult) {
		logger.info("Validating test with testValue::" + testValue + " | Expected Result:: " + expectedResult);
	}

}
