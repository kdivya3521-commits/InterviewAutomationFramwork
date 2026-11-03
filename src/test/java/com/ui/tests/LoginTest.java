package com.ui.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojos.User;
import com.ui.utilities.LoggerUtililty;

//@Listeners({ com.ui.listeners.TestListener.class })
public class LoginTest extends TestBase {

	Logger logger = LoggerUtililty.getLoger(getClass());

	@Test(description = "Verifying with CSV valid creditionals ", groups = { "E2E", "Regression",
			"Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProviders.class, dataProvider = "Login Data CSV Provider")

	public void loginWithCSVTest(User user) {
		AssertJUnit.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"David Charles");
	}

	@Test(description = "Verifying with Excel valid Creditionals", groups = { "E2E", "Regression",
			"Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProviders.class, dataProvider = "Login Data Excel Provider")
	public void loginWithExcelTest(User user) {
		AssertJUnit.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"David Charles");
	}

	@Test(description = "Verifying with JSON valid Creditionals", groups = { "E2E", "Regression",
			"Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProviders.class, dataProvider = "Login Data JSON provider")
	public void loginWithJSONTest(User user) {
		AssertJUnit.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"David Charles");
	}

}
