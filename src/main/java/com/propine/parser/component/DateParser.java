package com.propine.parser.component;

import com.propine.parser.utils.WebDriverActions;
import org.openqa.selenium.WebDriver;

public class DateParser implements IDateParser {

    // create driver object for DateParser
    private WebDriver driver;
    private WebDriverActions webDriverActions;

    // constructor to initiate driver object and get webdriver action instance
    public DateParser(WebDriver driver) {
        this.driver = driver;
        webDriverActions = WebDriverActions.getInstance();
    }

    @Override
    public void enterDate(String date) {
        webDriverActions.fillValue(driver, textbox_date, date);
    }

    @Override
    public boolean clickSubmitButton() {
        return webDriverActions.click(driver, button_submit);
    }

    @Override
    public String fetchResult() {
        return webDriverActions.getText(driver, label_resultOutput);
    }
}
