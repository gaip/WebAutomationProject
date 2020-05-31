package com.propine.parser.dataProvider;

import com.propine.parser.fileReader.excel.ExcelReader;

public class TestDataProvider {

	public Object[][] getTestData(){
		ExcelReader reader = new ExcelReader();
		return reader.readFile();
	}
}
