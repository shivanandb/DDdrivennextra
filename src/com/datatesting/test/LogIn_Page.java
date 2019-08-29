package com.datatesting.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn_Page {
public static WebDriver driver;
	public static void enteruser(WebDriver driver, String uname){ 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys(uname);
		//return elm;
		 
		 }
	public static void enterpass(WebDriver driver,String pass){ 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(By.id("password")).sendKeys(pass);
		 }
	public static void clickbtn(WebDriver driver) {
		driver.findElement(By.xpath("//button[@class='btn__primary--large from__button--floating']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
}
