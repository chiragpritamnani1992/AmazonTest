package com.qa.listener;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.base.TestBase;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestNGListener extends TestBase implements ITestListener{
	Logger log= LogManager.getLogger(TestNGListener.class);

	 protected static ExtentReports reports;
	 protected static ExtentTest test;
	 
	 TestBase sc = new TestBase();
	public void onTestStart(ITestResult result) {
		
		

		  test = reports.startTest(result.getMethod().getMethodName());
		  test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
		
	}

	public void onTestSuccess(ITestResult result) {
		

	
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "  "+ "test is passed");
		
	}

	public void onTestFailure(ITestResult result) {
	
		screenshot(result.getMethod().getMethodName());
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", result.getThrowable().getMessage());  
		
		
		
	}
	public void onTestSkipped(ITestResult result) {
		
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
		
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		
	}

	public void onStart(ITestContext context) {
		log.info("Test Case Started"+ " " + context.getName());
		
		String workingdir= System.getProperty("user.dir");
		String datename= new SimpleDateFormat("yyyy-MM-d-hh-mm-ss").format(new Date());
		reports=new ExtentReports(workingdir+"\\ExtentReports\\ExtentReportResults"+ " "+datename+".html",true);
		
		
	}

	public void onFinish(ITestContext context) {
		
		test.log(LogStatus.INFO, context.getName() + "Test Case Finished");
		
		reports.endTest(test);
		reports.flush();

	}
	
	




	

}