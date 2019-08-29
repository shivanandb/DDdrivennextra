package com.definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBaseSetup {
//https://www.seleniumeasy.com/selenium-tutorials/simple-page-object-model-framework-example
	public static WebDriver driver;
	static String driverPath = "C:\\drivers\\chromedriver.exe";
	public static String browserType;
	public static String appURL;
	public WebDriver getDriver() {
		return driver;
	}
	
	private void setDriver(String browserType, String appURL) {
		switch(browserType) {
		case "Chrome": 
			initChromeDriver(appURL);
		default:
			System.out.println("The driver are invalid");
		}}
	
	public static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching the drivers-----------");
		System.setProperty("webdriver.com.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
		return driver;
                
	}
	
	@Parameters({"browserType","appURL"})
	@BeforeClass
	public void initializeTestBaseSetup() {
		try {
			setDriver(browserType, appURL);
		}catch(Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	}

