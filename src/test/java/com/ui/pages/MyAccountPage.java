package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utilities.BrowserUtility;

public class MyAccountPage extends BrowserUtility {
	private static final By USERNAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]");

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public String getUserName() {
		return getVisableText(USERNAME_LOCATOR);
	}

}
