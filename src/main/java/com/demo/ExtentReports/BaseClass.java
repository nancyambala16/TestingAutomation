package com.demo.ExtentReports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest 
	public void reportSetUp()
	{ 
		extent=new ExtentReports(System.getProperty("user.dir")+"\\test-output\\ExtentReport_"+System.currentTimeMillis()+".html"); 
		extent.addSystemInfo("environment", "QA"); 
		extent.addSystemInfo("user name", "nancy"); }

	@AfterTest public void onTestComplete() { 
		extent.flush();
		extent.close();
	}

	public static String generateScreenshot(String Filename,WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Src=ts.getScreenshotAs(OutputType.FILE);
		String des=System.getProperty("user.dir")+"\\Screenshot\\"+Filename+"_"+System.currentTimeMillis()+".png";
		try {
			FileUtils.copyFile(Src,new File(des));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return des;
	}
}
