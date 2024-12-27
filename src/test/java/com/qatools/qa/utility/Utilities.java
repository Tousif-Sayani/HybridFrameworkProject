package com.qatools.qa.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qatools.qa.baseclass.BaseClass;

public class Utilities extends BaseClass {

	JavascriptExecutor js;
	public static final int IMPLICITWAIT = 10;
	public static final int PAGELOADTIME = 10;
	public static String screenShotPath;

	public Utilities(WebDriver driver) {
		js = (JavascriptExecutor) driver;
	}

	public void scrollToElementUsingJs(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clickOnElementUsingJs(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	public void enterTextUsingJs(String value, WebElement element) {
		js.executeScript("arguments[0].value='" + value + "';", element);
	}

	public static void captureScreenShot(String methodName) {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			File destination = new File(".\\ScreenShots\\" + methodName + ".png");
			String absolutePath = destination.getAbsolutePath();
			screenShotPath = absolutePath;
			FileUtils.copyFile(source, destination);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
	}

}
