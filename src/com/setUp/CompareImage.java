package com.setUp;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.im4java.core.CompareCmd;
import org.im4java.core.IMOperation;
import org.im4java.process.ProcessStarter;
import org.im4java.process.StandardStream;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.RotatingDecorator;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;
import ru.yandex.qatools.ashot.shooting.ViewportPastingDecorator;
import ru.yandex.qatools.ashot.shooting.cutter.CutStrategy;
import ru.yandex.qatools.ashot.shooting.cutter.VariableCutStrategy;

public class CompareImage {
	static WebElement element;
static void processImage() throws IOException, InterruptedException {
WebDriver driver;
System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
driver.get(
"https://weather.com/en-US/weather/today/l/2fed15ede5b6d52dc97504c4eae63c29cb7c81d3ae3a56efb847e3b712421eab");
screenshot(driver);
String file1 = "D:\\Images\\image_3_8.png";
String file2 = "D:\\Images\\image_3_9.png";

Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
Image image2 = Toolkit.getDefaultToolkit().getImage(file2);

try {
PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);

int[] data1 = null;

if (grab1.grabPixels()) {
int width = grab1.getWidth();
int height = grab1.getHeight();
data1 = new int[width * height];
data1 = (int[]) grab1.getPixels();
}

int[] data2 = null;

if (grab2.grabPixels()) {
int width = grab2.getWidth();
int height = grab2.getHeight();
data2 = new int[width * height];
data2 = (int[]) grab2.getPixels();
}

System.out.println("Pixels equal: " + java.util.Arrays.equals(data1, data2));

} catch (InterruptedException e1) {
e1.printStackTrace();
}
}

public static void main(String args[]) throws IOException, InterruptedException {
processImage();
}

public static void screenshot(WebDriver driver) throws IOException, InterruptedException{
// WebElement element = driver.findElement(By.xpath("//img[@alt='The Weather
// Company']"));
Thread.sleep(15000);

//WebElement element = driver.findElement(By.xpath("//gwd-pagedeck[@id='pagedeck']"));
if(driver.findElement(By.xpath("(//iframe[contains(@id,'google_ads_iframe')])[1]")).isDisplayed())
{
 element = driver.findElement(By.xpath("(//iframe[contains(@id,'google_ads_iframe')])[1]"));
//div[@id='google-center-div']
 cropImage(driver,element);
 System.out.println("Inside 1");
} else if(driver.findElement(By.xpath("//img[@alt='advertisement']")).isDisplayed())
{
	 element = driver.findElement(By.xpath("//img[@alt='advertisement']"));
	//div[@id='google-center-div']
	 cropImage(driver,element);
	 System.out.println("Inside 2");
	}

else if(driver.findElement(By.xpath("//div[@id='google_image_div']")).isDisplayed())
{
	 element = driver.findElement(By.xpath("//div[@id='google_image_div']"));
	//div[@id='google-center-div']
	 cropImage(driver,element);
	 System.out.println("Inside 3");
	}
else if(driver.findElement(By.xpath("//gwd-pagedeck[@id='pagedeck']")).isDisplayed())
{
	 element = driver.findElement(By.xpath("//gwd-pagedeck[@id='pagedeck']"));
	//div[@id='google-center-div']
	 cropImage(driver,element);
	 System.out.println("Inside 4");
	}else if(driver.findElement(By.xpath("//img[@class='img_ad']")).isDisplayed())
	{
		 element = driver.findElement(By.xpath("//img[@class='img_ad']"));
		//div[@id='google-center-div']
		 cropImage(driver,element);
		 System.out.println("Inside 5");
		}


}

public static void cropImage(WebDriver driver, WebElement element) throws IOException, InterruptedException
{
	Actions a=new Actions(driver);
	a.moveToElement(element);
	a.build();
	Thread.sleep(3000);
	// Get entire page screenshot
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	BufferedImage  fullImg = ImageIO.read(screenshot);

	// Get the location of element on the page
	Point point = element.getLocation();

	// Get width and height of the element
	int eleWidth = element.getSize().getWidth();
	int eleHeight = element.getSize().getHeight();
	try{
	// Crop the entire page screenshot to get only element screenshot
	BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
	   eleWidth, eleHeight);

	ImageIO.write(eleScreenshot, "png", screenshot);
	}
	       catch(RasterFormatException ignoRasterFormatException)
	       {
	            System.out.println("Ignore Exception");
	       }
	// Copy the element screenshot to disk
	File screenshotLocation = new File("D:\\Images\\image_3_" + 9 + ".png");
	Files.copy(screenshot, screenshotLocation);
}


}
