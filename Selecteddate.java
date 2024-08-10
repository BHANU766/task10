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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selecteddate {
       
	   protected static String url="https://jqueryui.com/datepicker/";
	   WebDriver driver;

@BeforeSuite 
public void startchromebrowser() {
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
}	

@BeforeClass
public void openurl() {
	  driver.get(url);
}

@Test
public void dateselection() throws InterruptedException, IOException {
	//switch inside the frame
	driver.switchTo().frame(0);
	driver.findElement(By.id("datepicker")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[@title='Next']")).click();
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//table/tbody/tr/td/a[.='22']")).click();
	
	//capture the value and print in console 
	WebElement dateelement=driver.findElement(By.id("datepicker"));
	String date=dateelement.getAttribute("value");
	System.out.println(" the selected date is "+date);
	
	 Thread.sleep(2000);
     File que1screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(que1screenshot,new File("seleniumjatconcept//que1screenshot.png"));	    
     System.out.println("screenshot captured successfully...");
	
}

@AfterSuite
public void closechromebrowser() {
	  driver.quit();
}
}
