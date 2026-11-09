package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ui.utilities.BrowserUtility;

public class MyAccountPage extends BrowserUtility {
	
	private static final By USERNAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]");
	private static final By SEARCH_BOX = By.id("search_query_top");
	private static final By ADD_MY_FIRST_ADDRESS_LOCATOR = By.xpath("//a[@title=\"Add my first address\"]");
	
	
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public String getUserName() {
		return getVisableText(USERNAME_LOCATOR);
	}
	
	public SearchPage searchProducts(String productName) {
		enterText(SEARCH_BOX,productName);
		enterKeys(SEARCH_BOX,Keys.ENTER);
		SearchPage searchPage = new SearchPage(getDriver());
		return searchPage;
	}
	
	public AddressPage goToCreateAdress() {
		clickOn(ADD_MY_FIRST_ADDRESS_LOCATOR);
		AddressPage addressPage = new AddressPage(getDriver());
		return addressPage;
	}
	
	

}
