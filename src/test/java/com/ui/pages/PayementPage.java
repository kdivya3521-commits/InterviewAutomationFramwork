package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utilities.BrowserUtility;

public class PayementPage extends BrowserUtility{
	
	private static final By PAYMENT_MODE_NOTFOUND = By.xpath("//p[@class=\"alert alert-warning\"]");

	public PayementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getPaymentModes() {
		return getVisableText(PAYMENT_MODE_NOTFOUND);
	}

}
