package com.propine.parser.testcases.regression;

import com.propine.parser.dataProvider.TestDataProvider;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class DateParserTest extends TestDataProvider {

	Logger logger = Logger.getLogger(DateParserTest.class);

	@Test(dataProvider = "parseTestData")
	public void dateParserTest(String testValue, String expectedResult) {
		logger.info("Validating test with testValue::" + testValue + " | Expected Result:: " + expectedResult);
	}

	@Test
	public void test2() {

	}

}
