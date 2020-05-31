package com.propine.parser;

import com.propine.parser.constants.PathConstants;
import com.propine.parser.directoryManager.Directory;
import com.propine.parser.fileReader.excel.ExcelReader;
import com.propine.parser.testNG.RuntimeTestNG;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class StartUp {

	private Logger logger = Logger.getLogger(StartUp.class);

	// starting point of the execution
	public static void main(String[] args) {

		// clean and create new directory for output
		Directory dir = new Directory();
		dir.createOutputDirectory();

		// configure logging properties
		PropertyConfigurator.configure(PathConstants.LOG_PROPERTIES_FILE_PATH);

		// fetch test data from external file
		ExcelReader reader = new ExcelReader();
		reader.generateTestData();

		// Start Execution
		RuntimeTestNG runtimeTestNG = new RuntimeTestNG();
		runtimeTestNG.create().run();
	}
}
