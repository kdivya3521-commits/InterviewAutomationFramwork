package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utilities.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility{
	
	private static final By PROCEEDS_CHECKOUT_SUMMARY = By.xpath("//p[contains(@class,\"cart_navigation clearfix\")]/a[@title=\"Proceed to checkout\"]");

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ConfirmAddressPage goToConfirmAddressPage() {
		clickOn(PROCEEDS_CHECKOUT_SUMMARY);
		return new ConfirmAddressPage(getDriver());
	}

}
