package base;

import com.propine.parser.constants.BrowserConstants;
import com.propine.parser.constants.PathConstants;
import com.propine.parser.constants.PropertiesConstants;
import com.propine.parser.directoryManager.Directory;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.LinkedHashMap;
import java.util.Map;

public class BaseTest {

    Logger logger = LoggerFactory.getLogger(BaseTest.class);

    public WebDriver driver;
    PropertyReader prop = null;
    Map<String, Integer> testcaseInvocationCount = new LinkedHashMap<>();

    /*
     * Will create initial configurations for the execution
     */
    @BeforeSuite
    public void configureDriver() {

        PropertyConfigurator.configure(PathConstants.LOG_PROPERTIES_FILE_PATH);

        // Configure logger
        logger.info("Start Execution");

        // clean and create output directories
        Directory dir = new Directory();
        dir.createOutputDirectory();

        // read properties
        prop = new PropertyReader();

        // fetch browser value
        String browser = prop.getProperty(PropertiesConstants.KEY_BROWSER).toUpperCase();

        // select browser and initialize driver
        switch (browser) {
            case BrowserConstants.BROWSER_CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
                break;
            case BrowserConstants.BROWSER_FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new EventFiringWebDriver(new FirefoxDriver(getFirefoxOptions()));
                break;
            default:
                break;
        }

        // maximize window
        driver.manage().window().maximize();
    }

    /*
     * Will launch new browser before every @Test method
     */
    @BeforeMethod
    public void launchBrowser() {
        String url = prop.getProperty(PropertiesConstants.KEY_URL);
        driver.get(url);
    }


    /*
     * Will terminate browser after every @Test method
     */
    @AfterMethod
    public void captureResult(ITestResult testResult) {
        String methodName = testResult.getName();

        // update method invocation count
        updateInvocationCount(methodName);

        if (ITestResult.FAILURE == testResult.getStatus()) {
            int invocationCount = testcaseInvocationCount.get(methodName);
            Screenshot.capture(driver, methodName + "_" + invocationCount);
        }
        tearDown();
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

    private void tearDown() {
        driver.quit();
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
