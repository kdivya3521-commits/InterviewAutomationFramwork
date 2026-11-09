package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utilities.BrowserUtility;

public class ShipmentPage extends BrowserUtility{
	
	private static final By TERMS_CONDITIONS_CHECKBOX_LOCATOR = By.id("uniform-cgv");
	private static final By PROCEED_TO_CHECKOUT = By.name("processCarrier");
	

	public ShipmentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public PayementPage goToPaymentPage() {
		clickOnCheckBox(TERMS_CONDITIONS_CHECKBOX_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT);
		return new PayementPage(getDriver());
	}

}
