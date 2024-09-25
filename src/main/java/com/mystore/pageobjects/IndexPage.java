package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	@FindBy(xpath = "//a[@class='login']") 
	public WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	public WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	public WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	public WebElement searchButton;
	
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() {
		Action.fluentWait(getDriver(), signInBtn, 10);
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		return Action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		
		return getDriver().getTitle();
		
	}
	
	public SearchResult searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), searchButton);
		return new SearchResult();
	}
}
