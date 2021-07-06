package com.demo.ExtentReports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReportGeneration2 extends BaseClass{

	

	@Test
	public void correctTitle()
	{
		System.out.println(System.getProperty("user.dir")+"\\test-output\\ExtentReport_"+System.currentTimeMillis()+".html");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		test=extent.startTest("correctTitle");
		driver.get("https://www.google.com");
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, "Google");
	
	}

	
	@Test
	public void incorrectTitle() 
	{ 
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver(); 
	test=extent.startTest("incorrectTitle");
	driver.get("https://www.google.com"); 
	String actualTitle=driver.getTitle();
	Assert.assertEquals(actualTitle, "Googleeeee"); }


	@AfterMethod
	public void tearDown(ITestResult result)
	{
		
		  if(result.getStatus()==ITestResult.FAILURE)
		  { 
			  String  des=generateScreenshot(result.getName(),driver); 
			  test.log(LogStatus.FAIL,result.getName());
			  test.log(LogStatus.FAIL, result.getThrowable());
			  test.log(LogStatus.FAIL, test.addScreenCapture(des)); 	
		  }
		 	 
		 
		if(result.getStatus()==ITestResult.SUCCESS) { 
			String filepath=generateScreenshot(result.getName(),driver); 
			test.log(LogStatus.PASS,result.getName());
			test.log(LogStatus.PASS, test.addScreenCapture(filepath));
		}
		  extent.endTest(test);
          driver.quit();
	}
}
