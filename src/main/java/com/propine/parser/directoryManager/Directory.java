package com.propine.parser.directoryManager;

import com.propine.parser.constants.PathConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Directory {

    private Logger logger = LoggerFactory.getLogger(Directory.class);

    public void createOutputDirectory() {

        logger.info("Creating new output directory.");

        // clean existig directory
        cleanOutputDirectory();

        // create new directory
        File outputDir = new File(PathConstants.OUTPUT_DIRECTORY_FILE_PATH);
        outputDir.mkdirs();

        logger.info("Creating new log file.");
        String fileName = "log.txt";
        File logFile = new File(PathConstants.OUTPUT_DIRECTORY_FILE_PATH + "/" + fileName);
        try {
            logFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cleanOutputDirectory() {
        logger.warn("Deleting existing directory and files.");
        File outputDir = new File(PathConstants.OUTPUT_DIRECTORY_FILE_PATH);
        removeFiles(outputDir);
    }

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
}
