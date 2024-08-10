package com.task10;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draganddropoperation {
  
	protected static String url="https://jqueryui.com/droppable/";
	WebDriver driver;
 
  @BeforeSuite
  public void startchromebrowser() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
  }
  
  @Test
  public void draganddrop() throws InterruptedException, IOException {
	  driver.get(url);
	  
	  //switch to frame
	  driver.switchTo().frame(0);
	  
	  //locate an element of drag and drop box 
	  WebElement source=driver.findElement(By.id("draggable"));
	  WebElement destination=driver.findElement(By.id("droppable")); 
	  
	  //before dropping
	  String pretext=destination.getText();
	  String precolor=destination.getCssValue("background-color");
	  System.out.println(pretext);
	  System.out.println(precolor);
	  
	  //perform an action
	  Actions actions=new Actions(driver);
	  actions.dragAndDrop(source, destination).perform();
	  
	  Thread.sleep(2000);
	  
	  //after dropping
	  String aftertext=destination.getText();
	  String aftercolor=destination.getCssValue("background-color");
	  System.out.println(aftertext);
	  System.out.println(aftercolor);
	  
	  //validate
	  if(aftertext.equals("Dropped!") && aftercolor.equals("rgba(255, 250, 144, 1)")) 
	  {
		  System.out.println("drag and drop successfully done");
	  }else {
		  System.out.println("drag and drop are not done properly");
	  }
	  
	   Thread.sleep(2000);
	   File que2screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(que2screenshot,new File("seleniumjatconcept//que2screenshot.png"));	    
	   System.out.println("screenshot captured successfully...");
		
  }	  
  
  @AfterSuite
  public void closechromebrowser() {
	  driver.quit();
  }
  
}
