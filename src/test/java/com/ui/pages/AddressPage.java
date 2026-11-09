package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojos.AddressPojo;
import com.ui.utilities.BrowserUtility;

public class AddressPage extends BrowserUtility {

	private static final By COMPNAYNAME_LOCATOR = By.id("company");
	private static final By ADDRESS1_LOCATOR = By.id("address1");
	private static final By CITY_LOCATOR = By.id("city");
	private static final By POSTCODE_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_LOCATOR = By.id("phone");
	private static final By MOBILE_PHONE_LOCATOR = By.id("phone_mobile");
	private static final By ADDRESREF = By.id("alias");
	private static final By STATEDROPDOWN_LOCATOR = By.id("id_state");
	private static final By COUNTRY_DROPDOWN_LOCATOR = By.id("id_country");
	private static final By SUMBIT_BUTTON = By.id("submitAddress");
	private static final By ADDRESS_HEADING = By.tagName("h3");

	public AddressPage(WebDriver driver) {
		super(driver);
	}

	public String addAddress(AddressPojo adresProjo) {
		enterText(COMPNAYNAME_LOCATOR, adresProjo.getCompanyName());
		enterText(ADDRESS1_LOCATOR,adresProjo.getAdddress1() );
		enterText(CITY_LOCATOR,adresProjo.getCity() );
		enterText(POSTCODE_LOCATOR,adresProjo.getPostCode() );
		enterText(HOME_PHONE_LOCATOR,adresProjo.getHomePhone() );
		enterText(MOBILE_PHONE_LOCATOR, adresProjo.getMobilePhone());
		enterText(ADDRESREF,adresProjo.getAddressRef() );

		selectFromDropdown(COUNTRY_DROPDOWN_LOCATOR, adresProjo.getCoutry());
		selectFromDropdown(STATEDROPDOWN_LOCATOR, adresProjo.getState());

		clickOn(SUMBIT_BUTTON);
		String newAddress = getVisableText(ADDRESS_HEADING);
		return newAddress;
	}

}
