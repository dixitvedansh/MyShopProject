package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResult extends BaseClass{
	
	@FindBy(xpath="(//div[@class='product-image-container']/a[@class='product_img_link']/img)[1]")
	WebElement productResult;
	
	
	@FindBy(xpath="(//span[text()='More'])[1]")
	WebElement productDetail;
	
	
	public SearchResult() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCart clickOnProduct() {

		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		new Actions(getDriver()).moveToElement(productResult).build().perform();
		Action.click(getDriver(), productDetail);
		return new AddToCart();
	}
	
	
	
	

}
