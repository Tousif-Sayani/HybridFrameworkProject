package com.qatools.qa.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	WebDriver ldriver;
	WebDriverWait wait;
	Logger logger;
	
	public LandingPage(WebDriver rdriver) {
		ldriver = rdriver;
		wait = new WebDriverWait(ldriver,Duration.ofSeconds(10));
		logger = LogManager.getLogger("QA_TOOLS");
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath = "//h5[contains(text(),'Elements')]")
	@CacheLookup
	WebElement elementsTab;

	@FindBy(xpath = "//h5[contains(text(),'Forms')]")
	@CacheLookup
	WebElement formsTab;

	@FindBy(xpath = "//h5[contains(text(),'Alerts, Frame & Windows')]")
	@CacheLookup
	WebElement alertFrameWindowTab;

	@FindBy(xpath = "//h5[contains(text(),'Widgets')]")
	@CacheLookup
	WebElement widgetsTab;

	@FindBy(xpath = "//h5[contains(text(),'Interactions')]")
	@CacheLookup
	WebElement interactionsTab;

	@FindBy(xpath = "//h5[contains(text(),'Book Store Application')]")
	@CacheLookup
	WebElement booksTab;

	@FindBy(xpath="//div[contains(text(),'Please select an item from left to start practice.')]")
	@CacheLookup
	WebElement elementsPageTitle;
	
	public void clickOnElementsTab() {
		wait.until(ExpectedConditions.visibilityOf(elementsTab)).click();
		logger.debug("clickOnElementsTab Method initilized");
	}

	public void clickOnFormsTab() {
		formsTab.click();
	}

	public void clickOnAlertFramWindowTab() {
		alertFrameWindowTab.click();
	}

	public void clickOnWidgetsTab() {
		widgetsTab.click();
	}

	public void clickOnInteractionTab() {
		interactionsTab.click();
	}

	public void clickOnBookTab() {
		booksTab.click();
	}

	public WebElement elementsTab() {
		return elementsTab;
	}

	public WebElement formsTab() {
		return formsTab;
	}

	public WebElement alertFrameWindowTab() {
		return alertFrameWindowTab;
	}

	public WebElement widgetsTab() {
		return widgetsTab;
	}

	public WebElement interactionsTab() {
		return interactionsTab;
	}

	public WebElement booksTab() {
		return booksTab;
	}

	public String getElementPageTitle() {
		return elementsPageTitle.getText();
	}
	
}
