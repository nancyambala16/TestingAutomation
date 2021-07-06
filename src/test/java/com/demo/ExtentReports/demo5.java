package com.demo.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo5 {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void init()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	@Test(invocationCount = 10)
	public void correctTitle()
	{
		driver.get("https://www.google.com");
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, "Google");
	}
	
	@Test(enabled=false)
	public void incorrectTitle()
	{
		driver.get("https://www.google.com");
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, "Goooogle");
	}
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
