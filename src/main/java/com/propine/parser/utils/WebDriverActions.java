package com.propine.parser.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverActions {

    private static WebDriverActions webDriverActions = null;

    // Singleton class implementation
    public static WebDriverActions getInstance() {
        if (webDriverActions == null) {
            webDriverActions = new WebDriverActions();
        }

        return webDriverActions;
    }

    public void fillValue(WebDriver driver, By by, String value) {
        waitUntil(driver, by);

        // find element
        WebElement ele = driver.findElement(by);

        // fill values if it is in enabled state
        if (ele.isEnabled()) {
            ele.sendKeys(value);
        }


    }

    public boolean click(WebDriver driver, By by) {
        waitUntil(driver, by);

        // find element
        WebElement ele = driver.findElement(by);

        // click button if it is in enabled state
        if (ele.isEnabled()) {
            ele.click();
            return true;
        }
        return false;
    }

    public String getText(WebDriver driver, By by) {
        waitUntil(driver, by);

        // find element
        WebElement ele = driver.findElement(by);

        // to return text present in the field
        String output = null;

        // fetch value if it is displayed
        if (ele.isDisplayed()) {
            output = ele.getText().trim();
        }
        return output;
    }

    public void waitUntil(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
}
