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

public class signupandloginforguvi {
       
    
	   protected static String url="https://www.guvi.in/";
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
public void signupandlogin() throws InterruptedException, IOException {
	driver.findElement(By.xpath("(//*[.='Sign up'])[2]")).click();
	
	WebElement fullnamefield=driver.findElement(By.id("name"));
	fullnamefield.sendKeys("bhanu");
	
	WebElement emailfield=driver.findElement(By.id("email"));
	emailfield.sendKeys("bhanu@gmail.com");
	
	WebElement passwordfield=driver.findElement(By.id("password"));
	passwordfield.sendKeys("bhanu@123");
	
	WebElement mobilenumberfield=driver.findElement(By.id("mobileNumber"));
	mobilenumberfield.sendKeys("9876543210");
	
	WebElement signupbtn=driver.findElement(By.id("signup-btn"));
	signupbtn.click();
	
	Thread.sleep(3000);		
	
	System.out.println("user is logged in successfully");
	
	 Thread.sleep(2000);
     File que3screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(que3screenshot,new File("seleniumjatconcept//que3screenshot.png"));	    
     System.out.println("screenshot captured successfully...");
}


@AfterSuite
public void closechromebrowser() {
	  driver.quit();
}
}
