package base;

import com.propine.parser.constants.BrowserConstants;
import com.propine.parser.constants.PropertiesConstant;
import com.propine.parser.fileReader.properties.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    WebDriver driver;
    PropertyReader prop = null;

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
                driver = new ChromeDriver();
                break;
            case BrowserConstants.BROWSER_FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                break;
        }
    }

    @BeforeMethod
    public void launchBrowser() {
        String url = prop.getProperty(PropertiesConstant.KEY_URL);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
