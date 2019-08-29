package com.datatesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class DataProvider_Parameter {
ChromeDriver driver;
XSSFWorkbook workbook;
XSSFSheet sheet;
XSSFCell cell;
public static String emailWrong = "Please enter a valid email address.";
@BeforeTest
public void initCode() {
	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("http://www.linkedin.com/");
	 driver.manage().window().maximize();

}
	/*
	 * @Test(priority=0) public void DemoProject() throws IOException {
	 * System.out.println("This is a Data Driven code Selenium "); File src=new
	 * File(
	 * "C:\\Users\\shivanandbhad.padiy\\eclipse-workspace\\PracticeJ\\TestData\\TestData.xlsx"
	 * ); FileInputStream fin = new FileInputStream(src); workbook = new
	 * XSSFWorkbook(fin); sheet = workbook.getSheetAt(0); int l =
	 * sheet.getPhysicalNumberOfRows(); System.out.println(l);
	 * 
	 * for(int i=0; i< l;i++) { cell = sheet.getRow(i).getCell(0);
	 * 
	 * //System.out.println(cell);
	 * driver.findElement(By.name("session_key")).sendKeys(cell.getStringCellValue()
	 * ); driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); cell =
	 * sheet.getRow(i).getCell(1);
	 * driver.findElement(By.name("session_password")).sendKeys(cell.
	 * getStringCellValue());
	 * driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
	 * 
	 * String expWrong = driver.findElement(By.id("error-for-username")).getText();
	 * if(expWrong.endsWith(emailWrong)) { System.out.println(expWrong);
	 * driver.navigate().back(); driver.manage().timeouts().implicitlyWait(10,
	 * TimeUnit.SECONDS); // break; //Assert.assertEquals(expWrong, emailWrong); } }
	 * }
	 */

	  @DataProvider(name = "Authentication")
	  
	  public static Object[][] credentials() {
	 
	        return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_2", "Test@345" }};
	 
	  }
	  
	  
@Test(dataProvider = "Authentication", priority=0)
public void testc(String sUsername, String sPassword) {
	System.out.println("This is a dataprovider code: ");
	driver.get("http://www.linkedin.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.findElement(By.name("session_key")).sendKeys(sUsername);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.name("session_password")).sendKeys(sPassword);

}
@Test (priority = 1)

@Parameters({ "sUsername", "sPassword" })

public void test(String sUsername, String sPassword) {

	 driver.get("http://www.linkedin.com/");
	 driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.findElement(By.name("session_key")).sendKeys(sUsername);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.name("session_password")).sendKeys(sPassword);
}

@AfterTest
public void endTest() throws IOException {

driver.close();
driver.quit();
}
}


