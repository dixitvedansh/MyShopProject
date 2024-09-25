package com.mystore.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCart;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResult;

public class OrderPageTest extends BaseClass {
	
	IndexPage indexPage;
	SearchResult searchResultPage;
	AddToCart addToCartPage;
	OrderPage orderPage;
	
	@Parameters("browser")
	@BeforeMethod(groups={"sanity","smoke","regression"})
	public void setup(String browser) {
		launchApp(browser);
		
	}
	
	@AfterMethod(groups={"sanity","smoke","regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(groups="regression")
	public void verifyTotalPrice() throws Throwable {
		indexPage = new IndexPage();
		searchResultPage=indexPage.searchProduct("summer dress");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.selectSize("M");
		addToCartPage.enterQuantity("2");		
		addToCartPage.clickOnAddToCart();
		Assert.assertTrue(addToCartPage.validateAddtoCart());
		orderPage=addToCartPage.clickOnCheckOut();
		Double unitPrice = orderPage.getUnitPrice();
		Double totalPrice = orderPage.getTotalPrice();
		Double totalExpectedPrice = (unitPrice*2)+7;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		
		
		
	}
	
	
	
	

}
