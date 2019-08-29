package com.setUp;

import java.awt.Image;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.Toolkit;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
public class Test21 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
	

	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

	// open Chrome browser and let Katalon Studio to use it
	driver = new ChromeDriver();
	driver.get("https://weather.com/en-US/weather/today/l/2fed15ede5b6d52dc97504c4eae63c29cb7c81d3ae3a56efb847e3b712421eab");
	driver.manage().window().maximize();

	// Take screenshot and store as a file format
	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
	 // now copy the  screenshot to desired location using copyFile //method
	FileUtils.copyFile(src, new File("C:\\Users\\shivanandbhad.padiy\\Downloads\\21\\username3.PNG"));
	}
	 
	catch (IOException e)
	 {
	  System.out.println(e.getMessage());
	 
	 }

	//DriverFactory.changeWebDriver(driver);

	String file1 = "C:\\Users\\shivanandbhad.padiy\\Downloads\\21\\username.PNG";
	String file2 = "C:\\Users\\shivanandbhad.padiy\\Downloads\\21\\username3.PNG";

	Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
	Image image2 = Toolkit.getDefaultToolkit().getImage(file2);

	PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
	PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);

	int[] data1 =new int[3];

	if (grab1.grabPixels())
	{
	int width = grab1.getWidth();
	int height = grab1.getHeight();
	data1 = new int [width * height];
	data1 = (int[]) grab1.getPixels();
	}
	 
	int[] data2= null;
	 
	if (grab2.grabPixels())
	  {
	  int width = grab2.getWidth();
	  int height = grab2.getHeight();
	  data2 = new int [width * height];
	  data2 = (int[]) grab2.getPixels();
	  }
	//KeywordLogger logger = new KeywordLogger()
	if(java.util.Arrays.equals(data1, data2)== true){
	//logger.logPassed("Both Match")
		System.out.println("Both Match");
	} else {
	System.out.println("Both Dont Match");
	}
	 driver.close();
	 driver.quit();
	}


}
