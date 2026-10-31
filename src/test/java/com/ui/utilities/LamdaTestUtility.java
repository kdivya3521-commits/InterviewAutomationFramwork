package com.ui.utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LamdaTestUtility {
	
	public static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
    private static final ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();
    private static final ThreadLocal<DesiredCapabilities> capabilitiesLocal = new ThreadLocal<DesiredCapabilities>();

    public static WebDriver intializeLambaTestSession(String browserName,String testName){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", "latest");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user","divyasaikandiboina");
        ltOptions.put("accessKey", "LT_dItYut0oFAMk6IrXrmICRAR2GSxXkhtaIF8KlRs7IzfkWtv");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "latest");
        capabilities.setCapability("LT:Options", ltOptions);
        capabilitiesLocal.set(capabilities);
        
        
        WebDriver driver = null;
        try {
			driver = new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driverLocal.set(driver);
        return driverLocal.get();
    }
    
    public static void quit() {
    	if(driverLocal.get()!=null) {
    	driverLocal.get().quit();
    	driverLocal.remove();
    	capabilitiesLocal.remove();
    	}
    }

}
