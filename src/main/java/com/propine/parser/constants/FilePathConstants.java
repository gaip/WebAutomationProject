package com.propine.parser.constants;

public interface FilePathConstants {

	// config path
	String CONFIG_PROPERTIES_FILE_PATH = "src/main/resources/config.properties";
	String LOG_PROPERTIES_FILE_PATH = "src/main/resources/log4j.properties";

	// directory path
	String OUTPUT_DIRECTORY_FILE_PATH = "output";
	String SCREENSHOT_DIRECTORY_FILE_PATH = OUTPUT_DIRECTORY_FILE_PATH + "/" + "screenshot";

	// testdata path
	String TESTDATA_EXCEL_FILE_PATH = "src/main/resources/TestData.xlsx";

	// testcase path
	String TESTCASE_PACKAGE_PATH = "com.propine.parser.testcases";
}
