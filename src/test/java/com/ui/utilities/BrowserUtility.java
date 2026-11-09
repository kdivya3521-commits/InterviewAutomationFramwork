package com.ui.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browsers;

public abstract class BrowserUtility {

	private Logger logger = LoggerUtililty.getLoger(getClass());
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static final int MAX_WAIT_TIME = 20;

	public BrowserUtility(WebDriver driver) {
		super();
		BrowserUtility.driver.set(driver);

	}

	public BrowserUtility(String browserName) {
		logger.info("Launching browser " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else {
			System.out.println("Invalid browser");
		}
	}

	public BrowserUtility(Browsers browserName) {
		logger.info("Launching browser " + browserName);

		if (browserName == Browsers.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browsers.EDGE) {
			driver.set(new EdgeDriver());
		}
	}

	public BrowserUtility(Browsers browserName, Boolean isHeadless) {
		logger.info("Launching browser " + browserName + " in Headless" + isHeadless);

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
	public void clickOnCheckBox(By locator) {
		getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
	}
	
	public void clickOn(WebElement element) {
		getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void enterText(By locator, String textToEnter) {
		getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(textToEnter);
	}

	public void enterKeys(By locator, Keys keys) {
		getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(keys);
		;
	}

	public String getVisableText(By locator) {
		return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}

	public String getVisableText(WebElement element) {
		return getWait().until(ExpectedConditions.visibilityOf(element)).getText();
	}

	public void selectFromDropdown(By locator, String optionToSelect) {
		// 1. Locate the dropdown element safely in the DOM
		WebElement dropdown = getWait().until(ExpectedConditions.presenceOfElementLocated(locator));

		// 2. Find all option tags inside the dropdown using pure Java
		List<WebElement> options = dropdown.findElements(By.tagName("option"));

		// 3. Loop through them and click the matching option
		for (WebElement option : options) {
			if (option.getText().trim().equals(optionToSelect)) {
				option.click();
				logger.info("Selected option '" + optionToSelect + "' from dropdown.");
				return;
			}
		}

	}

	public List<String> getVisableTextofAllElements(WebElement element) {
		List<WebElement> elements = new ArrayList<WebElement>();
		List<String> elementVisableText = new ArrayList<String>();

		elements = getWait().until(ExpectedConditions.visibilityOfAllElements(element));
		for (WebElement webelement : elements) {
			String text = webelement.getText();
			System.out.println(text);

			elementVisableText.add(text);
		}
		return elementVisableText;
	}

	public List<String> getVisableTextofAllElements(By locator) {
		List<WebElement> elements = new ArrayList<WebElement>();
		List<String> elementVisableText = new ArrayList<String>();

		elements = getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		for (WebElement webelement : elements) {
			String text = webelement.getText();
			System.out.println(text);
			elementVisableText.add(text);
		}
		return elementVisableText;
	}

	public List<WebElement> getAllElements(By locator) {
		List<WebElement> elementsList = new ArrayList<WebElement>();

		elementsList = getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

		return elementsList;
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
		File screenshotdata = takeScreenshots.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/" + timeStamp + screenshotName + ".png";
		File screenshotfile = new File(path);

		try {
			FileUtils.copyFile(screenshotdata, screenshotfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public WebDriver getDriver() {
		return driver.get();
	}

}
