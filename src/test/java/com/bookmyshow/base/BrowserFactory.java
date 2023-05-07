package com.bookmyshow.base;

import java.util.HashMap;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.bookmyshow.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	//Create webdriver object for given browser
	public WebDriver createBrowserInstance(String browserName) {
		WebDriver driver = null;
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("download.default_directory", Constants.DOWNLOADSFOLDER_PATH);
			DesiredCapabilities dCapablities=DesiredCapabilities.chrome();
//			dCapablities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//			dCapablities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			dCapablities.setCapability("applicationCacheEnabled", true);
			ChromeOptions cOptions = new ChromeOptions();
//			cOptions.addArguments("headless");
			cOptions.addArguments("--use-fake-ui-for-media-stream=1");
			cOptions.setExperimentalOption("prefs", chromePrefs);
			cOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			cOptions.addArguments("--incognito");
			cOptions.merge(dCapablities);
			cOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			cOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cOptions.setCapability("applicationCacheEnabled", true);
			driver = new ChromeDriver(cOptions);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fOptions = new FirefoxOptions();
			fOptions.addArguments("-private");
			driver = new FirefoxDriver(fOptions);
		}else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions eOptions = new EdgeOptions();
			driver = new EdgeDriver(eOptions);
		}
		return driver;
	}
	
}
