package com.java.practice;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class POMExample {
	public static WebDriver driver;
@BeforeTest
public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();

	
}

@Test
public void testClickJS() throws Exception {
	driver.navigate().to("http://www.amazon.com/");
	WebElement searchTextBox=driver.findElement(By.id("twotabsearchtextbox"));
	searchTextBox.sendKeys("Mobiles");
	WebDriverWait wa = new WebDriverWait(driver, 10);
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement goButton = driver.findElement(By.xpath("//input[@type='submit']"));
//goButton.click();
//wa.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-color-state a-text-bold']")));
safeJavaScriptClick(goButton);
}

@AfterTest
public void tesrdown() {
	driver.close();
	
}

public void safeJavaScriptClick(WebElement element) throws Exception {
	try {if(element.isDisplayed() && element.isEnabled()){
		System.out.println("Element getting clicked");
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	} else {
		System.out.println("Unable to click");
	}
	}
	catch (StaleElementReferenceException e) {
		System.out.println("Element is not attached to the page document "+ e.getStackTrace());
	} catch (NoSuchElementException e) {
		System.out.println("Element was not found in DOM "+ e.getStackTrace());
	} catch (Exception e) {
		System.out.println("Unable to click on element "+ e.getStackTrace());
	}
}}
