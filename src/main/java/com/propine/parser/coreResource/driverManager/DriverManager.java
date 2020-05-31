package com.propine.parser.coreResource.driverManager;

import com.propine.parser.constants.PropertiesConstants;
import com.propine.parser.constants.SupportedBrowsers;
import com.propine.parser.coreResource.fileOperations.fileReader.properties.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class DriverManager {

	private Logger logger = Logger.getLogger(DriverManager.class);

	/**
	 * Navigate to Home Page
	 *
	 * @return WebDriver instance
	 */
	public WebDriver loadHomePage() {
		WebDriver driver = createDriver();
		driver.get(PropertyReader.getProperty(PropertiesConstants.KEY_URL));

		return driver;
	}

	/**
	 * Create new driver
	 *
	 * @return WebDriver
	 */
	private WebDriver createDriver() {
		WebDriver driver;

		// fetch browser value
		String browser = PropertyReader.getProperty(PropertiesConstants.KEY_BROWSER).toUpperCase();

		// select browser and initialize driver
		switch (SupportedBrowsers.valueOf(browser)) {
			case CHROME:
				WebDriverManager.chromedriver().setup();
				driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
				logger.info("Testcase will be executed on Chrome Browser");
				break;
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				driver = new EventFiringWebDriver(new FirefoxDriver(getFirefoxOptions()));
				logger.info("Testcase will be executed on Firefox Browser");
				break;
			default:
				throw new IllegalStateException("Incorrect Browser Value Provided. Value:: " + browser);
		}

		// maximize window
		driver.manage().window().maximize();

		return driver;
	}

	public void quitDriver(WebDriver driver) {
		driver.quit();
	}

	/**
	 * Set Chrome options
	 *
	 * @return options
	 */
	private ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		return options;
	}

	/**
	 * Set Firefox options
	 *
	 * @return options
	 */
	private FirefoxOptions getFirefoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("disable-infobars");
		return options;
	}

	/**
	 * Unit test to check open/close browser
	 */
	@Test
	public void unitTest() {
		// initializing properties to get url and browser
		PropertyReader reader = new PropertyReader();

		DriverManager manager = new DriverManager();
		WebDriver driver = manager.loadHomePage();
		manager.quitDriver(driver);
	}
}
