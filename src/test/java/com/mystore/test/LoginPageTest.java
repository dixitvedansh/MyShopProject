package com.mystore.test;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups={"sanity","smoke","regression"})
	public void setup(String browser) {
		launchApp(browser);
		
	}
	
	@AfterMethod(groups={"sanity","smoke","regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(dataProvider="Credentials",dataProviderClass=DataProviders.class , groups = {"sanity", "smoke"} )
	public void loginTest(String uname,String pw) throws InterruptedException  {
		
		Log.startTestCase("Login Test");
		indexPage = new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage = loginPage.login(uname,pw);
		Log.info("Username and Password entered and submitted");
		Thread.sleep(2000);
		String actualURL=homePage.getCurrURL();
		String expectedURL= "http://www.automationpractice.pl/index.php?controller=my-account";
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login Test Successful");
		Log.endTestCase("Login Test");
		
	}
	

}
