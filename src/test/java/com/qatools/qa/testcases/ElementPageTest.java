package com.qatools.qa.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qatools.qa.baseclass.BaseClass;
import com.qatools.qa.pages.ElementsPage;
import com.qatools.qa.pages.LandingPage;
import com.qatools.qa.utility.ReadExcelData;
import com.qatools.qa.utility.Utilities;

public class ElementPageTest extends BaseClass {
	LandingPage landingPage;
	Utilities utils;
	ElementsPage elementsPage;

	ReadExcelData excelData = new ReadExcelData("ElementsTab");

	@BeforeMethod
	public void setUp() {
		initializeBrowser(prop.getProperty("browserName"));
		logger.debug("Setup method initialized");
	}

	@Test(dataProvider = "data")
	public void verifyElementsPage(Object obj1) {
		try {
			HashMap<String, String> testData = (HashMap<String, String>) obj1;
			landingPage = new LandingPage(driver);
			utils = new Utilities(driver);
			utils.scrollToElementUsingJs(landingPage.elementsTab());
			logger.debug("scroll to element");
			landingPage.clickOnElementsTab();
			logger.debug("click on elementTab");
			Assert.assertEquals(landingPage.getElementPageTitle(), testData.get("ExpectedValue1"));
			logger.debug("Verify actual and expected");
			elementsPage = new ElementsPage(driver);
			elementsPage.clickOnTextBoxMenu();
			elementsPage.enterUserName(testData.get("FullName"));
			elementsPage.enterEmail(testData.get("Email"));
			utils.scrollToElementUsingJs(elementsPage.permanentAddField());
			elementsPage.enterCurrentAdd(testData.get("CurrentAddress"));
			elementsPage.enterPermanentAdd(testData.get("PermanentAddress"));
			utils.scrollToElementUsingJs(elementsPage.submitButton());
			elementsPage.clickOnSubmitButton();
			logger.debug("Click on submit button");
			Assert.assertEquals(elementsPage.getNameText(), testData.get("ExpectedValue2"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

		
	@DataProvider(name = "data")
	public Object[][] testDataProvider() {
		Object[][] obj = new Object[excelData.getRowCount()][1];
		for (int i = 1; i <= excelData.getRowCount(); i++) {
			HashMap<String, String> testData = excelData.getExcelData(i);
			obj[i - 1][0] = testData;
		}

		return obj;
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
