package com.propine.parser.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DateParser {

    // create driver object for DateParset
    private WebDriver driver;

    // Page Elements
    private By textbox_date = By.cssSelector("input[name='date']");
    private By button_submit = By.cssSelector("input[type='submit']");
    private By label_results = By.xpath(".//h3[text()='Results']");
    private By label_resultOutput = By.xpath(".//h3[text()='Results']/following-sibling::div");

    // constructor to initiate driver object
    public DateParser(WebDriver driver) {
        this.driver = driver;
    }


}
