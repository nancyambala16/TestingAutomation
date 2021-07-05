package com.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.demo.ExtentReports.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class ITestListnerImpl extends BaseClass implements ITestListener{



	public void onStart(ITestContext context) {
		System.out.println("Onstart Method : "+context.getName()+" , "+ context.getPassedTests().getAllResults().size()+
				" , " +context.getSkippedTests().getAllResults().size()+" , "+context.getFailedTests().getAllResults().size()	
				);
	}


	public void onFinish(ITestContext context) {
		System.out.println("Onstart Method : "+context.getName()+" , "+ context.getPassedTests().getAllResults().size()+
				" , " +context.getSkippedTests().getAllResults().size()+" , "+context.getFailedTests().getAllResults().size()	
				);}


	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test suceess: "+result.getName());
		String filepath=generateScreenshot(result.getName(),driver); 
		test.log(LogStatus.PASS,result.getName());
		test.log(LogStatus.PASS, test.addScreenCapture(filepath));
		extent.endTest(test);
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Fail: "+result.getName()); 
		String  des=generateScreenshot(result.getName(),driver); 
		test.log(LogStatus.FAIL,result.getName());
		test.log(LogStatus.FAIL, result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(des)); 
		extent.endTest(test);

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("On Test skipped: "+result.getName());
	}

	public void onTestStart(ITestResult result) {
		test=extent.startTest(result.getName());
	}


	public void onTestFinish(ITestResult result) {
		// TODO Auto-generated method stub

		System.out.println("On Test Start: "+result.getName());

	}
}
