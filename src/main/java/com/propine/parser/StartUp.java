package com.propine.parser;

import com.propine.parser.constants.FilePathConstants;
import com.propine.parser.coreResource.directoryManager.Directory;
import com.propine.parser.coreResource.fileOperations.fileReader.excel.ExcelReader;
import com.propine.parser.coreResource.fileOperations.fileReader.properties.PropertyReader;
import com.propine.parser.coreResource.reporting.ExecutionReport;
import com.propine.parser.coreResource.testNGGenerator.RuntimeTestNG;
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
		PropertyConfigurator.configure(FilePathConstants.LOG_PROPERTIES_FILE_PATH);

		// Generate properties
		PropertyReader propertyReader = new PropertyReader();

		// fetch test data from external file
		ExcelReader excelReader = new ExcelReader();
		excelReader.generateTestData();

		// Start Execution
		RuntimeTestNG runtimeTestNG = new RuntimeTestNG();
		runtimeTestNG.create().run();

		// Report Creation
		ExecutionReport report = new ExecutionReport();
		report.createReport();
	}
}
