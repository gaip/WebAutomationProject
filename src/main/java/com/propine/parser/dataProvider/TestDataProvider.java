package com.propine.parser.dataProvider;

import com.propine.parser.fileReader.excel.ExcelReader;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

	/**
	 * to fetch test data for date parsing test
	 *
	 * @return testValue and expected rvalue
	 */
	@DataProvider(name = "parseTestData")
	public Object[][] getTestData() {
		ExcelReader reader = new ExcelReader();
		return reader.getData();
	}
}
