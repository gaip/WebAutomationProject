package com.propine.parser.fileReader.properties;

import com.propine.parser.constants.FilePathConstants;
import com.propine.parser.constants.PropertiesConstants;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	private Logger logger = Logger.getLogger(PropertyReader.class);

	private static Properties properties = new Properties();

	public PropertyReader() {
		readFile();
	}

	/*
	 * read and store all properties
	 */
	private void readFile() {
		logger.info("Reading properties file.");

		File file = new File(FilePathConstants.CONFIG_PROPERTIES_FILE_PATH);

		try (FileReader reader = new FileReader(file)) {

			// load all values
			properties.load(reader);

		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}


	public static String getProperty(String propKey) {
		return properties.getProperty(propKey);
	}

	@Test
	public void unitTest() {
		PropertyReader reader = new PropertyReader();
		logger.info(reader.getProperty(PropertiesConstants.KEY_BROWSER));
	}

}
