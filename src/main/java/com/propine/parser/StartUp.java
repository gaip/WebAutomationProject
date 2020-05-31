package com.propine.parser;

import com.propine.parser.constants.PathConstants;
import com.propine.parser.directoryManager.Directory;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartUp {

	private Logger logger = LoggerFactory.getLogger(StartUp.class);

	// starting point of the execution
	public static void main(String[] args) {

		// clean and create new directory for output
		Directory dir = new Directory();
		dir.createOutputDirectory();

		// configure logging properties
		PropertyConfigurator.configure(PathConstants.LOG_PROPERTIES_FILE_PATH);




	}
}
