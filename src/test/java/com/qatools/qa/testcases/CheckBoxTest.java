package com.qatools.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qatools.qa.baseclass.BaseClass;
import com.qatools.qa.pages.CheckBoxPage;
import com.qatools.qa.pages.LandingPage;
import com.qatools.qa.utility.Utilities;

public class CheckBoxTest extends BaseClass {
	LandingPage landingPage;
	CheckBoxPage checkBoxPage;
	Utilities utils;

	@BeforeMethod
	public void setUp() {
		initializeBrowser(prop.getProperty("browserName"));
	}

	@Test
	public void verifyCheckBox() {
		try {
			landingPage = new LandingPage(driver);
			utils = new Utilities(driver);
			checkBoxPage = new CheckBoxPage(driver);
			utils.scrollToElementUsingJs(landingPage.elementsTab());
			landingPage.clickOnElementsTab();
			Assert.assertEquals(landingPage.getElementPageTitle(),"Please select an item from left to start practice.");
			checkBoxPage.clickOnCheckBoxMenu();
			Assert.assertEquals(checkBoxPage.getCheckBoxTitle(), "Check Box");
			checkBoxPage.clickOnCheckBox();
			Assert.assertEquals(checkBoxPage.getTextValue(), "You have selected :");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
