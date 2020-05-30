package com.propine.parser.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    static String screenshotDirPath = "output/screenshot";

    public static void capture(WebDriver driver, String screenshotName) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File(screenshotDirPath + "/" + screenshotName + ".png"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
