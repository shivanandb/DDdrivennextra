package com.datatesting.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Utility.*;
public class SignIn_Action extends Constant{
	public static WebDriver driver;
	public static String sUsername=null;
	public static String sPassword=null;
public static WebDriver Execute(WebDriver driver) throws Exception{
	 sUsername = ExcelUtils.getCell(1, 1);
	 sPassword = ExcelUtils.getCell(1, 2);
	System.out.println(sUsername + sPassword);
	
	//driver.findElement(By.id("username")).sendKeys(sUsername);
	//driver.findElement(By.id("password")).sendKeys(sPassword);
	LogIn_Page.enteruser(driver, sUsername);
	LogIn_Page.enterpass(driver, sPassword);
	LogIn_Page.clickbtn(driver);
	return driver;
	
}
}
