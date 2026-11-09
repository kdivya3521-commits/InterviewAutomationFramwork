package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.DRESSSIZE;
import com.ui.pages.SearchPage;

public class ProductCheckoutTest extends TestBase {
	private static final String SEARCH_ITEM = "Printed Summer Dresss";
	private SearchPage searchResultPage;

	@BeforeMethod(description = "Logged into the system and searching for product")
	public void setup() {
		searchResultPage=	homePage.goToLoginPage().doLoginWith("fisewar445@pumpoly.com", "divya2019").searchProducts(SEARCH_ITEM);
	}

	@Test(description = "Verify the loggedin user able to buy a product", groups = { "e2e", "sanity" })
	public void checkout() {
		String result =searchResultPage.clickOnTheProductAt(1).changeSize(DRESSSIZE.L).AddToCart().proceedToCheckout().goToConfirmAddressPage()
		.goToShipment().goToPaymentPage().getPaymentModes();
		
		Assert.assertTrue(result.contains("No payment modules have been installed."));
	}

}
