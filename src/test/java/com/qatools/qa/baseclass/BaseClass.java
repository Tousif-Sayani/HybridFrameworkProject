package com.qatools.qa.baseclass;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qatools.qa.utility.Utilities;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static Logger logger;
	
	public BaseClass() {
		try {
			prop = new Properties();
			fis = new FileInputStream(".\\src\\test\\java\\com\\qatools\\qa\\confiq\\config.properties");
			prop.load(fis);
			logger = LogManager.getLogger("QA_TOOLS");
		} catch (Exception e) {
			logger.error("Error in BaseClass Constructor");
		}
	}

	public WebDriver initializeBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Enter valid Browser Name");
		}
		
		logger.info("Browser has launched");
		driver.manage().deleteAllCookies();
		logger.info("Deleting all cookies");
		driver.manage().window().maximize();
		logger.info("Browser window has maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICITWAIT));
		logger.info("Implicity wait initialized");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGELOADTIME));
		logger.info("Pageload has initialized");
		driver.get(prop.getProperty("url"));
		logger.info("Url has launched");
		
		return driver;

	}

}
