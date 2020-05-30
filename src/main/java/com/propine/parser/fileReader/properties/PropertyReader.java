package com.propine.parser.fileReader.properties;

import com.propine.parser.constants.PathConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private Logger logger = LoggerFactory.getLogger(PropertyReader.class);

    private Properties properties = new Properties();

    public PropertyReader() {
        readFile();
    }

    /*
     * read and store all properties
     */
    private void readFile() {
        logger.info("Reading properties file.");

        File file = new File(PathConstants.CONFIG_PROPERTIES_FILE_PATH);

        try (FileReader reader = new FileReader(file)) {

            // load all values
            properties.load(reader);

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public String getProperty(String propKey) {
        return properties.getProperty(propKey);
    }

}
