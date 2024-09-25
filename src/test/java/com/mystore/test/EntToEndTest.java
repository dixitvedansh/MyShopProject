package com.mystore.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCart;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResult;
import com.mystore.pageobjects.ShippingPage;

public class EntToEndTest extends BaseClass {
	

	IndexPage indexPage;
	SearchResult searchResultPage;
	AddToCart addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;
	
	
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
	public void endToEndTest() throws Throwable {
		indexPage = new IndexPage();
		searchResultPage=indexPage.searchProduct("summer dress");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.selectSize("M");
		addToCartPage.enterQuantity("2");		
		addToCartPage.clickOnAddToCart();
		Assert.assertTrue(addToCartPage.validateAddtoCart());
		orderPage=addToCartPage.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummaryPage= paymentPage.clickOnPaymentMethod();
		orderConfirmationPage = orderSummaryPage.clickOnconfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMessage = "Your order on My Shop is complete." ;
		Assert.assertEquals(actualMessage, expectedMessage);
		
	}
	
	
	
	

}
