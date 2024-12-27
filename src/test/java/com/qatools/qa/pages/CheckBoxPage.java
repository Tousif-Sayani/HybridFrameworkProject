package com.qatools.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxPage {

	WebDriver ldriver;
	WebDriverWait wait;

	public CheckBoxPage(WebDriver rdriver) {
		ldriver = rdriver;
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath="//span[contains(text(),'Check Box')]")
	@CacheLookup
	WebElement checkBoxMenu;
	
	@FindBy(xpath="//h1[contains(text(),'Check Box')]")
	@CacheLookup
	WebElement checkBoxTitle;
	
	@FindBy(xpath="//span[@class='rct-checkbox']")
	WebElement checkBox;
	
	@FindBy(xpath="//span[contains(text(),'You have selected :')]")
	WebElement textValue;
	
	public void clickOnCheckBoxMenu() {
		checkBoxMenu.click();
	}
	
	public String getCheckBoxTitle() {
		return checkBoxTitle.getText();
	}
	
	public void clickOnCheckBox() {
		checkBox.click();
	}
	
	public String getTextValue() {
		return textValue.getText();
	}
}
