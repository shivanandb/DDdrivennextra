package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VideoPlayselenium {
    public static JavascriptExecutor jse= null;
	public static WebDriver driver;
	public static String url = "https://www.w3.org/2010/05/video/mediaevents.html";
			//"https://docs.katalon.com/katalon-studio/videos/image_comparison.html";
	
	
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	WebElement elm = driver.findElement(By.xpath("//video/source"));
	String urlStr = elm.getAttribute("src");
	System.out.println("Video Url : " + urlStr);

	driver.navigate().to(urlStr);
	//Thread.sleep(4000);
	jse = (JavascriptExecutor) driver;
	//Click on play button
//	
	Thread.sleep(20000);
	jse.executeScript("jwplayer().pause()");
	Thread.sleep(12000);
	jse.executeScript("jwplayer().play();");
	
	
//	WebElement elm1 = driver.findElement(By.id("video"));
//	Actions builder = new Actions(driver);
//	
//	Action mouseMovement=builder.moveToElement(elm1).build();
//    mouseMovement.perform();
//	//WebElement element = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
////	JavascriptExecutor jes = ((JavascriptExecutor)driver);	
////	jes.executeScript("arguments[0].click;", element);
//	//int size = driver.findElements(By.tagName("iframe")).size();	
//	//System.out.println(size);
////	driver.switchTo().frame(0);
//	JavascriptExecutor jes = ((JavascriptExecutor)driver);	
//jes.executeScript("document.getElementById('mp4').play();");
////jes.executeScript("arguments[0].click();", elm1);
//	//driver.findElement(By.id("video")).click();
//	//driver.findElement(By.xpath("//div[@class='ytp-cued-thumbnail-overlay']")).click();
//	System.out.println("----------------------------");
//	
//	
//	//String mainWindow=driver.getWindowHandle();
//	
////	Set<String> set =driver.getWindowHandles();
//	
//	//Thread.sleep(5000);
////driver.close();
////driver.quit();

}
}
