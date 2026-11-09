package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utilities.BrowserUtility;

public class ConfirmAddressPage extends BrowserUtility{
	
	private static final By PROCEED_ADDRESS = By.name("processAddress");

	public ConfirmAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ShipmentPage goToShipment() {
		clickOn(PROCEED_ADDRESS);
		return new ShipmentPage(getDriver());
	}

}
