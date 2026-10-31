package com.ui.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browsers;
import com.ui.pages.HomePage;
import com.ui.utilities.BrowserUtility;
import com.ui.utilities.LamdaTestUtility;

public class TestBase {

	protected HomePage homePage;
	private boolean isLambdaTest;

	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "intializing the browser")
	public void setup(@Optional("chrome") String browser, @Optional("false") boolean isLambdaTest,
			@Optional("false") boolean isHeadless, ITestResult result) {
		this.isLambdaTest = isLambdaTest;
		if (isLambdaTest) {
			WebDriver lambdaDriver = LamdaTestUtility.intializeLambaTestSession(browser,
					result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);

		} else {
			homePage = new HomePage(Browsers.valueOf(browser.toUpperCase()), isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "teardown sessions")
	public void tearDown() {
		if (isLambdaTest) {
			LamdaTestUtility.quit();
		} else {
			homePage.quit();
		}
	}
}




