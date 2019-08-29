package com.setUp;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.im4java.core.CompareCmd;
import org.im4java.core.IMOperation;
import org.im4java.process.ProcessStarter;
import org.im4java.process.StandardStream;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakScrn {
	
public static WebDriver driver;
	public static final long serialVersionUID = 1L; 
    public static void main(String[] args) throws IOException 
    { 
    	SalvarImagemFileOnSite();
    	//subimage();
        try { 
            Thread.sleep(120); 
            Robot r = new Robot(); 
  
            // It saves screenshot to desired path 
            String path = "D://Shot.jpg"; 
  
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            System.out.println("ScreenSize : " + screenSize);
            Rectangle captureRect = new Rectangle(0, 728, 1366, 40); // taskbar
                                                                        // zone

            BufferedImage screenFullImage = r.createScreenCapture(captureRect);
            ImageIO.write(screenFullImage, "jpg", new File(path)); 
            System.out.println("Screenshot saved"); 
        } 
        catch (AWTException | IOException | InterruptedException ex) { 
            System.out.println(ex); 
        } 
    } 
    public static void SalvarImagemFileOnSite() {
    
    			
    	  try {
    	    System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
    	    driver = new ChromeDriver();
    	     driver.get("http://agiletesters.com.br");
    	     
    	     WebElement logo = driver.findElement(By.xpath("//a[@class='navbar-brand forum-logo ']"));
    	     String logoSRC = logo.getAttribute("src");
    	     System.out.println(logoSRC);
    	     URL imageURL = new URL(logoSRC);
    	     BufferedImage saveImage = ImageIO.read(imageURL);
    	     
    	     ImageIO.write(saveImage, "png", new File("logo-forum.png"));
    	     
    	     } catch (Exception e) {
    	        e.printStackTrace();
    	     } finally {
    	        driver.close();
    	     }
    }
public static void subimage() throws IOException{
	 System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	driver.get("http://www.google.com");
	WebElement ele = driver.findElement(By.id("hplogo"));

	// Get entire page screenshot
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	BufferedImage  fullImg = ImageIO.read(screenshot);

	// Get the location of element on the page
	org.openqa.selenium.Point point = ele.getLocation();

	// Get width and height of the element
	int eleWidth = ele.getSize().getWidth();
	int eleHeight = ele.getSize().getHeight();

	// Crop the entire page screenshot to get only element screenshot
	BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
	    eleWidth, eleHeight);
	ImageIO.write(eleScreenshot, "png", screenshot);

	// Copy the element screenshot to disk
	File screenshotLocation = new File("C:\\images\\GoogleLogo_screenshot.png");
	FileUtils.copyFile(screenshot, screenshotLocation);
}

}
