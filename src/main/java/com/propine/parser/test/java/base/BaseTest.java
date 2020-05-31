/*
package com.propine.parser.test.java.base;

import com.propine.parser.component.DateParser;
import com.propine.parser.constants.BrowserConstants;
import com.propine.parser.constants.PathConstants;
import com.propine.parser.constants.PropertiesConstants;
import com.propine.parser.directoryManager.Directory;
import com.propine.parser.fileReader.excel.ExcelReader;
import com.propine.parser.fileReader.properties.PropertyReader;
import com.propine.parser.utils.Screenshot;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.NonNull;
import org.apache.commons.collections4.MapUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;

import java.util.LinkedHashMap;
import java.util.Map;

public class BaseTest {

    private Logger logger = LoggerFactory.getLogger(BaseTest.class);

    private WebDriver driver;
    protected DateParser dateParser;

    // To Load Properties file before execution
    private PropertyReader prop;

    // Maintaining testcase invocation to find current execution count
    private Map<String, Integer> testcaseInvocationCount = new LinkedHashMap<>();

    */
/*
     * Will create initial configurations for the execution
     *//*

    @BeforeSuite
    public void setPrerequisite() {

        // clean and create output directories
        Directory dir = new Directory();
        dir.createOutputDirectory();

        // Configure logger
        PropertyConfigurator.configure(PathConstants.LOG_PROPERTIES_FILE_PATH);

        logger.info("Start Execution");

*/
/*        // read properties
        prop = new PropertyReader();*//*


    }

    @AfterSuite
    public void executionEnd() {
        logger.info("Testcases Execution Completed.");
    }

    @BeforeClass
    public void createDriver() {
        // read properties
        prop = new PropertyReader();

        // fetch browser value
        String browser = prop.getProperty(PropertiesConstants.KEY_BROWSER).toUpperCase();

        // select browser and initialize driver
        switch (browser) {
            case BrowserConstants.BROWSER_CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
                logger.info("Testcase will be executed on Chrome Browser");
                break;
            case BrowserConstants.BROWSER_FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new EventFiringWebDriver(new FirefoxDriver(getFirefoxOptions()));
                logger.info("Testcase will be executed on Firefox Browser");
                break;
            default:
                throw new IllegalStateException("Incorrect Browser Value Provided. Value:: " + browser);
        }

        // maximize window
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    */
/*
     * Will launch new browser before every @Test method
     *//*

    @BeforeMethod
    public void launchBrowser() {
        String url = prop.getProperty(PropertiesConstants.KEY_URL);
        logger.info("Loading Page::" + url);
        driver.get(url);
        dateParser = new DateParser(driver);
    }


    */
/*
     * Will terminate browser after every @Test method
     *//*

    @AfterMethod
    public void captureResult(ITestResult testResult) {
        String executionStatus = "Pass";
        String methodName = testResult.getName();

        // update method invocation count
        updateInvocationCount(methodName);

        int invocationCount = testcaseInvocationCount.get(methodName);

        if (ITestResult.FAILURE == testResult.getStatus()) {
            Screenshot.capture(driver, methodName + "_" + invocationCount);
            executionStatus = "Fail";
        }

        logger.info("Execution completed for Testcase:: " + methodName + "| Invocation Count:: " + invocationCount + " | " +
                "Execution Status:: " + executionStatus);
    }

    @DataProvider(name = "testData")
    public Object[][] testData(){
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readFile();
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }

    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("disable-infobars");
        return options;
    }

    private void updateInvocationCount(@NonNull String testMethodName) {
        if (MapUtils.isNotEmpty(testcaseInvocationCount)) {
            if (testcaseInvocationCount.get(testMethodName) == null) {
                testcaseInvocationCount.put(testMethodName, 1);
            } else {
                int count = testcaseInvocationCount.get(testMethodName);
                testcaseInvocationCount.put(testMethodName, count + 1);
            }
        } else {
            testcaseInvocationCount.put(testMethodName, 1);
        }
    }
}
*/
