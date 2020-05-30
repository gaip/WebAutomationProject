package com.propine.parser.component;

import com.propine.parser.utils.WebDriverActions;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DateParser {

    // create driver object for DateParser
    private WebDriver driver;
    WebDriverActions webDriverActions;

    // Page Elements
    private By textbox_date = By.cssSelector("input[name='date']");
    private By button_submit = By.cssSelector("input[type='submit']");
    private By label_results = By.xpath(".//h3[text()='Results']");
    private By label_resultOutput = By.xpath(".//h3[text()='Results']/following-sibling::div");

    // constructor to initiate driver object and get webdriver action instance
    public DateParser(WebDriver driver) {
        this.driver = driver;
        webDriverActions = WebDriverActions.getInstance();
    }

    public void enterDate(@NonNull String date) {
        webDriverActions.fillValue(driver, textbox_date, date);
    }

    public boolean clickSubmitButton() {
        return webDriverActions.click(driver, button_submit);
    }

    public String fetchResult() {
        return webDriverActions.getText(driver, label_resultOutput);
    }


}
