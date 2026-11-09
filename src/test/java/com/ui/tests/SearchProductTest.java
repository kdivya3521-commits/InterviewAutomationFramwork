package com.ui.tests;


import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

public class SearchProductTest extends TestBase{
	
	private MyAccountPage myAccountPage;
	private static final String SERACH_TERM ="Summer Dresses";
	
	@BeforeMethod(description = "Login into System")
	public void setup() {
		myAccountPage=homePage.goToLoginPage().doLoginWith("fisewar445@pumpoly.com","divya2019");
	}
	
	@Test(description = "Searching with productNames", groups = {"E2E","Sanity"})
	public void searchProducts() {
		//String productName ="Printed summer dresses";
		/*String headerText= myAccountPage.searchProducts(productName).getSearchHeaderText();
		Assert.assertTrue(headerText.contains("PRINTED SUMMER DRESSES"), 
			    "Search header text did not contain the expected product name!");*/
		
		boolean actualResult = myAccountPage.searchProducts(SERACH_TERM).isSearchTermPresentInProductList(SERACH_TERM);
		Assert.assertEquals(actualResult, true);
		}
	}
	


