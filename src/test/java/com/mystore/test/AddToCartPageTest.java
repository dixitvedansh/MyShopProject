package com.mystore.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCart;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResult;

public class AddToCartPageTest extends BaseClass {
	

	IndexPage indexPage;
	SearchResult searchResultPage;
	AddToCart addToCartPage;
	
	
	@Parameters("browser")
	@BeforeMethod(groups={"sanity","smoke","regression"})
	public void setup(String browser) {
		launchApp(browser);
		
	}
	
	@AfterMethod(groups={"sanity","smoke","regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(groups= {"regression","sanity"})
	public void addToCartTest() throws Throwable {
		indexPage = new IndexPage();
		searchResultPage=indexPage.searchProduct("summer dress");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.selectSize("M");
		addToCartPage.enterQuantity("2");		
		addToCartPage.clickOnAddToCart();
		
		Assert.assertTrue(addToCartPage.validateAddtoCart());
	}
	

}
