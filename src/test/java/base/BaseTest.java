package base;

import com.propine.parser.constants.BrowserConstants;
import com.propine.parser.constants.PropertiesConstant;
import com.propine.parser.fileReader.properties.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public WebDriver driver;
    PropertyReader prop = null;

    /*
     * Will create initial configurations for the execution
     */
    @BeforeSuite
    public void configureDriver() {

        // read properties
        prop = new PropertyReader();

        // fetch browser value
        String browser = prop.getProperty(PropertiesConstant.KEY_BROWSER).toUpperCase();

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
        String url = prop.getProperty(PropertiesConstant.KEY_URL);
        driver.get(url);
    }


    /*
     * Will terminate browser after every @Test method
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
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
}
