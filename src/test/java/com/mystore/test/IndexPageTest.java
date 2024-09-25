package com.mystore.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

public class IndexPageTest extends BaseClass {
	IndexPage indexPage;
	
	@Parameters("browser")
	@BeforeMethod(groups={"sanity","smoke","regression"})
	public void setup(String browser) {
		launchApp(browser);
		
	}
	
	@AfterMethod(groups={"sanity","smoke","regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(groups="smoke")
	public void verifyLogo() {
		
		Log.startTestCase("VerifyLogo");
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
		Log.info("Logo found");
	}
	
	@Test(groups="smoke")
	public void verifyTitle() {
		
		String actualTitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(actualTitle, "My Shop");
		Log.info("Title found");
	
	}
}
