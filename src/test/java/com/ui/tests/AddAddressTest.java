package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojos.AddressPojo;
import com.ui.utilities.FakeAddressUtiltiy;
import com.ui.utilities.LoggerUtililty;

public class AddAddressTest extends TestBase{
	
	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	Logger logger = LoggerUtililty.getLoger(getClass());
	private AddressPojo address ;
	
	@BeforeMethod(description ="Login with valid cred")
	public void setup() {
		myAccountPage=homePage.goToLoginPage().doLoginWith("fisewar445@pumpoly.com", "divya2019");
		address = FakeAddressUtiltiy.getAddress();
	}
	
	@Test(description ="Verifying adding new Address")
	public void addAddress() {
		logger.info("Click on the Add address");
		String newAddress = myAccountPage.goToCreateAdress().addAddress(address);
		Assert.assertEquals(newAddress, address.getAddressRef().toUpperCase());
	}

}
