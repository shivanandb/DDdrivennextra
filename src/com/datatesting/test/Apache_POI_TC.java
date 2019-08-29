package com.datatesting.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import com.datatesting.test.SignIn_Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Utility.Constant;
import com.Utility.ExcelUtils;

@Test
public class Apache_POI_TC extends Constant{
public static String sUsername=null;
public static String sPassword=null;
public static WebDriver driver;
@BeforeTest
public void startd() {
	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to(Constant.URL);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}    

@Test
public void begintest() throws Exception {
		//This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
        ExcelUtils.setExcel(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // String  sUsername1 = ExcelUtils.getCell(1, 1);
    //	String sPassword1 = ExcelUtils.getCell(1, 2);
        SignIn_Action.Execute(driver);
    	//System.out.println(sUsername1 + sPassword1);
    //	driver.findElement(By.id("username")).sendKeys("hi");
    	//driver.findElement(By.id("password")).sendKeys(sPassword1);
    	//SignIn_Action.Execute(driver);
    	System.out.println("Login Successfully, now it is the time to Log Off buddy.");
        //Home_Page.lnk_LogOut(driver).click(); 
      //  driver.quit();
        //This is to send the PASS value to the Excel sheet in the result column.
        ExcelUtils.setCell("Pass", 1, 3);
		}
@AfterTest
public void endTest() {
	
	driver.quit();
}
}
