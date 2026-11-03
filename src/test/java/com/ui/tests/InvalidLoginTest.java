package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.utilities.LoggerUtililty;

//@Listeners({ com.ui.listeners.TestListener.class })

public class InvalidLoginTest extends TestBase {

	private static final String INVALID_USER_NAME = "divya@gmail.com";
	private static final String INVALID_PASSWORD = "divya2019";

	Logger logger = LoggerUtililty.getLoger(getClass());

	@Test(description = "Verifying the Login with invalid creditionals", groups = { "E2E", "Sanity" })
	public void loginWithInvalidCred() {
		assertEquals(
				homePage.goToLoginPage().doLoginWithInvalidCred(INVALID_USER_NAME, INVALID_PASSWORD).getErrorMessage(),
				"Authentication failed.");
	}

}
