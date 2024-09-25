package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
	

	@FindBy(xpath="//span[text()='My addresses']")
	private WebElement myAddresses;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;

	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	public boolean validateMyAddresses() {
		return Action.isDisplayed(getDriver(), myAddresses);		
		
	}
	
	public boolean validateOrderHistory() {
		return Action.isDisplayed(getDriver(), orderHistory);
	}
	
	public String getCurrURL() {
		String homePageURL= getDriver().getCurrentUrl();
		return homePageURL;
	}
	
		
}
