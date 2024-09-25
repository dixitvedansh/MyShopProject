package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;


public class OrderConfirmationPage extends BaseClass {
	
	
	@FindBy(xpath="//p[contains(text(),'Your order on My Shop is complete.')]")
	public WebElement confirmMessag;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver() , this);
	}
	
	public String validateConfirmMessage() {
		String confirmMsg=confirmMessag.getText();
		return confirmMsg;
	}
	
	
}
