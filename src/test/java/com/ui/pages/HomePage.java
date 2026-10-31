package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browsers;
import com.constants.ENV;
import com.ui.utilities.BrowserUtility;
import com.ui.utilities.JSONUtiltiy;
import com.ui.utilities.LoggerUtililty;

public class HomePage extends BrowserUtility {

	static final By SIGNIN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");

	Logger logger = LoggerUtililty.getLoger(getClass());

	public HomePage(Browsers browserName, Boolean isHeadless) {
		super(browserName, isHeadless);
		logger.info("Intializing the broweser");
		goToWebSite(JSONUtiltiy.readJSONFile(ENV.QA).getUrl());
	}

	public HomePage(WebDriver driverLocal) {
		super(driverLocal);
		goToWebSite(JSONUtiltiy.readJSONFile(ENV.QA).getUrl());

	}

	public LoginPage goToLoginPage() {
		logger.info("Click on singin link");
		clickOn(SIGNIN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

}
