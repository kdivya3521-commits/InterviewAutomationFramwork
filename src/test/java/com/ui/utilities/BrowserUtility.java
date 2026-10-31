package com.ui.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browsers;

public abstract class BrowserUtility {
	
	Logger logger = LoggerUtililty.getLoger(getClass());
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static final int MAX_WAIT_TIME = 10;

	public BrowserUtility(WebDriver driver) {
		super();
		BrowserUtility.driver.set(driver);

	}

	public BrowserUtility(String browserName) {
		logger.info("Launching browser "+browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else {
			System.out.println("Invalid browser");
		}
	}

	public BrowserUtility(Browsers browserName) {
		logger.info("Launching browser "+browserName);

		if (browserName == Browsers.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browsers.EDGE) {
			driver.set(new EdgeDriver());
		}
	}

	public BrowserUtility(Browsers browserName, Boolean isHeadless) {
		logger.info("Launching browser "+browserName +" in Headless"+isHeadless);

		if (browserName == Browsers.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}
		} else if (browserName == Browsers.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
			}
		}
	}

	public WebDriverWait getWait() {
		return new WebDriverWait(driver.get(), Duration.ofSeconds(MAX_WAIT_TIME));
	}

	public void goToWebSite(String url) {
		driver.get().get(url);
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public void enterText(By locator, String textToEnter) {
		getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(textToEnter);
	}

	public String getVisableText(By locator) {
		return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}

	public void quit() {
		logger.info("Terminating driver session");
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}
	public String takeScreenshot(String screenshotName) {
		logger.info("Taking screenshot ");
		TakesScreenshot takeScreenshots = (TakesScreenshot) driver.get();
		File screenshotdata =takeScreenshots.getScreenshotAs(OutputType.FILE);
		Date date =new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp =format.format(date);
		String path = "./screenshots/"+timeStamp+screenshotName+".png";
		File screenshotfile = new File(path);
		
		try {
			FileUtils.copyFile(screenshotdata, screenshotfile);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	public WebDriver getDriver() {
		return driver.get();
	}

}
