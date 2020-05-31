package com.propine.parser.directoryManager;

import com.propine.parser.constants.FilePathConstants;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Directory {

	private Logger logger = Logger.getLogger(Directory.class);

	/**
	 * Will create new output directory to store execution result
	 */
	public void createOutputDirectory() {

		logger.info("Creating new output directory.");

		// clean existing directory
		cleanOutputDirectory();

		// create new directory
		File outputDir = new File(FilePathConstants.OUTPUT_DIRECTORY_FILE_PATH);
		outputDir.mkdirs();

		// create log file to store logs
		logger.info("Creating new log file.");
		String fileName = "log.txt";
		File logFile = new File(FilePathConstants.OUTPUT_DIRECTORY_FILE_PATH + "/" + fileName);
		try {
			logFile.createNewFile();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * To create testcase wise directory
	 *
	 * @param directoryName testcaseName with invocation count
	 */
	public static void createTestCaseDirectory(String directoryName) {

		File dir = new File(FilePathConstants.SCREENSHOT_DIRECTORY_FILE_PATH + "/" + directoryName);
		dir.mkdirs();
	}

	/**
	 * Delete existing directory
	 */
	private void cleanOutputDirectory() {
		logger.warn("Deleting existing directory and files.");
		File outputDir = new File(FilePathConstants.OUTPUT_DIRECTORY_FILE_PATH);
		removeFiles(outputDir);
	}

	/**
	 * Recursively delete all directory and files present in output folder
	 *
	 * @param outputDir directory object
	 */
	private void removeFiles(File outputDir) {
		File[] files = outputDir.listFiles();

		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					removeFiles(file);
					file.delete();
				} else {
					file.delete();
				}
			}
		}
		outputDir.delete();
	}

	/**
	 * Unit test to check creation and deletion of files and directory
	 */
	@Test
	public void unitTest() {
		Directory directory = new Directory();
		directory.createOutputDirectory();

		// testcase directory
		Directory.createTestCaseDirectory("Test1");
	}
}
