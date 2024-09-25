package com.mystore.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResult;

public class SearchResultPageTest extends BaseClass {
	
	IndexPage indexPage;
	SearchResult searchResultPage;
	
	
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
	public void productAvailabilityTest() throws Throwable {
		indexPage = new IndexPage();
		searchResultPage= indexPage.searchProduct("summer dress");
		Assert.assertTrue(searchResultPage.isProductAvailable());;
		
	}
	
	
	
	
	
	
}
