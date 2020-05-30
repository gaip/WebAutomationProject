package com.propine.parser.component;

import org.openqa.selenium.By;

public interface IDateParser {

    // Page Elements
    By textbox_date = By.cssSelector("input[name='date']");
    By button_submit = By.cssSelector("input[type='submit']");
    By label_resultOutput = By.xpath(".//h3[text()='Results']/following-sibling::div");

    // Page Methods
    void enterDate(String date);

    boolean clickSubmitButton();

    String fetchResult();
}
