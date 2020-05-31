/*
package com.propine.parser.test.java.dateParser;

import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DateParserTest extends BaseTest {

    Logger logger = LoggerFactory.getLogger(DateParserTest.class);

    @Test(dataProvider = "testData")
    public void testDate(String testValue, String expectedResult) {

        logger.info("TestValue:: " + testValue + " | Expected Result:: " + expectedResult);

        // fill date
        dateParser.enterDate(testValue);

        // click submit
        dateParser.clickSubmitButton();

        // check result
        String result = dateParser.fetchResult();
        Assert.assertEquals(result, expectedResult);

    }
}
*/
