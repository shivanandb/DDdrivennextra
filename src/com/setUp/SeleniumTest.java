package com.setUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

public static String URL="";
public static WebDriver driver;


private void setDriver(String browserType, String appURL) {
	switch (browserType) {
	case "chrome":
		//driver = initChromeDriver();
		break;
	case "firefox":
		driver = initFirefoxDriver(appURL);
		break;
	default:
		System.out.println("browser : " + browserType
				+ " is invalid, Launching Firefox as browser of choice..");
		driver = initFirefoxDriver(appURL);
	}
}
private WebDriver initFirefoxDriver(String URL) {
	System.out.println("No Firefox available, Use Chrome Driver instead");
	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to(URL);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
}

public static WebDriver initChromeDriver() {
	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	
}
public static WebDriver closeChromeDriver() {
	driver.close();
	driver.quit();
	
	return driver;
}
public static WebDriver printstat(String stat) {
	System.out.println("This is the session " + stat);
	return driver;
}

public static WebDriver webtable(String path) {
	 //Here we are storing the value from the cell in to the string variable
	 String sCellValue = driver.findElement(By.xpath(path)).getText();
	 System.out.println(sCellValue);
	return driver;
}


}


