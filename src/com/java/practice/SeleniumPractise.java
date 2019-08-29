package com.java.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.setUp.SeleniumTest;

public class SeleniumPractise extends SeleniumTest {
	public static WebDriver driver;
	public static String prnt = "ABCD";
	public static String url ="http://toolsqa.com/automation-practice-table/";
	public static String path = ".//*[@id='content']/table/tbody/tr[1]/td[2]";
public static void main(String[] args) {
	driver =initChromeDriver();
	driver.navigate().to(url);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	//closeChromeDriver();
	driver = printstat(prnt);
	driver =webtable(path);
	

    
    
}

}
