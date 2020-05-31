package com.propine.parser.component;

import com.propine.parser.bo.TestcaseBO;
import com.propine.parser.utils.Screenshot;
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
	public void enterDate(TestcaseBO testcaseBO, String date) {
		webDriverActions.fillValue(driver, textbox_date, date);
		Screenshot.capture(driver, testcaseBO.getScreenShotNamePrefix() + "After Filling Value");
	}

	@Override
	public boolean clickSubmitButton(TestcaseBO testcaseBO) {
		boolean flag = webDriverActions.click(driver, button_submit);
		Screenshot.capture(driver, testcaseBO.getScreenShotNamePrefix() + "After Clicking Submit");
		return flag;
	}

	@Override
	public String fetchResult(TestcaseBO testcaseBO) {
		return webDriverActions.getText(driver, label_resultOutput);
	}
}
