package com.propine.parser.fileReader.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private Properties properties = new Properties();

    public PropertyReader() {
        readFile();
    }

    /*
     * read and store all properties
     */
    private void readFile() {

        File file = new File("src/main/resources/config.properties");
        FileReader reader = null;

        try {
            reader = new FileReader(file);

            properties.load(reader);
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getProperty(String propKey) {
        return properties.getProperty(propKey);
    }
}
