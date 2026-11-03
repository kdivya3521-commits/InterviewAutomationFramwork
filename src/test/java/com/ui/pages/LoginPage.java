package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utilities.BrowserUtility;

public class LoginPage extends BrowserUtility {

	private static final By EMAIL_TEXTBOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXTBOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
	private static final By INVALID_LOGIN_ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,\"alert alert-danger\")]/ol/li");

	public LoginPage(WebDriver driverLocal) {
		super(driverLocal);
	}

	public MyAccountPage doLoginWith(String email, String password) {
		enterText(EMAIL_TEXTBOX_LOCATOR, email);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;

	}
	
	public LoginPage doLoginWithInvalidCred(String email,String password) {
		enterText(EMAIL_TEXTBOX_LOCATOR, email);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	public String getErrorMessage() {
		return getVisableText(INVALID_LOGIN_ERROR_MESSAGE_LOCATOR);
	}

}
