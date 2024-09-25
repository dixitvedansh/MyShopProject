package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AccountCreation extends BaseClass {
	

	@FindBy(xpath = "//h1[text()='Create an account']")
	WebElement formTitle;
	
	@FindBy(id = "uniform-id_gender1")
	WebElement mr;
	
	@FindBy(id = "id_gender2")
	WebElement mrs;

	@FindBy(name = "customer_firstname")
	WebElement firstName;

	@FindBy(name = "customer_lastname")
	WebElement lastName;

	@FindBy(name = "passwd")
	WebElement passWord;

	@FindBy(name = "days")
	WebElement days;

	@FindBy(name = "months")
	WebElement months;

	@FindBy(name = "years")
	WebElement years;

	@FindBy(name = "firstname")
	WebElement customerNirstName;

	@FindBy(name = "lastname")
	WebElement customerLastName;

	@FindBy(name = "company")
	WebElement companyName;

	@FindBy(name = "address1")
	WebElement address;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "id_state")
	WebElement state;

	@FindBy(name = "postcode")
	WebElement postCode;

	@FindBy(name = "id_country")
	WebElement country;

	@FindBy(name = "phone")
	WebElement phone;

	@FindBy(name = "phone_mobile")
	WebElement mobile;

	@FindBy(name = "alias")
	WebElement ref;

	@FindBy(name = "submitAccount")
	WebElement registerBtn;
	
	public AccountCreation() {
		PageFactory.initElements(getDriver() , this);
	}
	
	public boolean validateAccountCreationPage() {
		return Action.isDisplayed(getDriver(), formTitle);
	}
	
}
