package com.propine.parser.fileCreation;

import com.propine.parser.constants.FilePathConstants;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HtmlFile {

	private static Logger logger = Logger.getLogger(HtmlFile.class);

	/**
	 * Create html file from the string
	 *
	 * @param htmlString html string
	 */
	public static void createFile(String htmlString) {

		logger.info("Creating new html file");

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		File file = new File(FilePathConstants.OUTPUT_DIRECTORY_FILE_PATH + "/" + "ExecutionReport.html");

		try {
			fileWriter = new FileWriter(file, false);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(htmlString);
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		logger.info("HTML File Created at Path:: " + FilePathConstants.OUTPUT_DIRECTORY_FILE_PATH);

	}
}
