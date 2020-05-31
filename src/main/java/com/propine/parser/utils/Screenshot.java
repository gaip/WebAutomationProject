package com.propine.parser.utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

	private static Logger logger = Logger.getLogger(Screenshot.class);

	static String screenshotDirPath = "output/screenshot";

	public static void capture(WebDriver driver, String screenshotName) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotNameWithExt = screenshotName + ".png";
		try {
			FileUtils.copyFile(file, new File(screenshotDirPath + "/" + screenshotNameWithExt));
			logger.info("Screenshot " + screenshotNameWithExt + " Generated");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
