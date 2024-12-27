package com.qatools.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsPage {

	WebDriver ldriver;
	WebDriverWait wait;
	
	public ElementsPage(WebDriver rdriver) {
		ldriver = rdriver;
		wait = new WebDriverWait(ldriver,Duration.ofSeconds(10));
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Text Box')]")
	@CacheLookup
	WebElement textBoxMenu;

	@FindBy(id = "userName")
	@CacheLookup
	WebElement fullNameInputField;

	@FindBy(id = "userEmail")
	@CacheLookup
	WebElement emailInputField;

	@FindBy(id = "currentAddress")
	@CacheLookup
	WebElement currentAddInputField;

	@FindBy(id = "permanentAddress")
	@CacheLookup
	WebElement permanentAddInputField;

	@FindBy(id = "submit")
	@CacheLookup
	WebElement submitButton;

	@FindBy(id="name")
	@CacheLookup
	WebElement nameText;
	
	public void clickOnTextBoxMenu() {
		wait.until(ExpectedConditions.visibilityOf(textBoxMenu)).click();
	}

	public void enterUserName(String userName) {
		fullNameInputField.sendKeys(userName);
	}

	public void enterEmail(String userEmail) {
		emailInputField.sendKeys(userEmail);
	}

	public void enterCurrentAdd(String enterCurrentAdd) {
		currentAddInputField.sendKeys(enterCurrentAdd);
	}

	public void enterPermanentAdd(String enterPermanentAdd) {
		permanentAddInputField.sendKeys(enterPermanentAdd);
	}

	public void clickOnSubmitButton() {
		submitButton.click();
	}
	
	public WebElement permanentAddField() {
		return permanentAddInputField;
	}
	
	public String getNameText() {
		return nameText.getText();
	}
	
	public WebElement submitButton() {
		return submitButton;
	}
}
