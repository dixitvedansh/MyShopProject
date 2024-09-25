package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;


public class BaseClass {
	
	
	public static Properties prop;
	
	//public static WebDriver driver;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	

	public static WebDriver getDriver() {
		return driver.get();
	}
			
	@BeforeSuite(groups={"sanity","smoke","regression"})
	public void loadCOnfig() {
		ExtentManager.setExtent();
		prop = new Properties();
		System.out.println("super constructor invoked");
		FileInputStream ip;
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+"//Configuration//config.properties");
			prop.load(ip);
			System.out.println("configuration loaded");
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		DOMConfigurator.configure("log4j.xml");
		
	}
	
			
	
	
	public static void launchApp(String browser) {
		//String browserName = prop.getProperty("browser");
		if (browser.equals("chrome")){
			driver.set(new ChromeDriver());
			System.out.println("Driver initialised : "+driver +"  Browser Setup by Thread : "+ Thread.currentThread().getId());
		}
		
		if (browser.equals("edge")){
			driver.set(new EdgeDriver());
			System.out.println("Driver initialised : "+driver+"  Browser Setup by Thread : "+ Thread.currentThread().getId());
		}
		if (browser.equals("firefox")){
			driver.set(new FirefoxDriver());
			System.out.println("Driver initialised : "+driver+"  Browser Setup by Thread : "+ Thread.currentThread().getId());
		}
		
		Action.implicitWait(getDriver(), 5);
		Action.pageLoadTimeOut(getDriver(), 20);
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		
		
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
		
	}

}
