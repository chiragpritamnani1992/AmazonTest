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


	public static ExtentTest test;
	public static ExtentReports reports;

	public void onTestStart(ITestResult result) {
		
		test= reports.startTest(result.getMethod().getMethodName());
		log.info("Test Case Started"+ " " + result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "  "+ "test is started");
	
		
	}

	public void onTestSuccess(ITestResult result) {
		

	
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "  "+ "test is passed");
		log.info("TestCase Passed " + result.getMethod().getMethodName());
		
	}

	public void onTestFailure(ITestResult result) {
	

		// Failure - 2
		// Pass=1
		// Throwbale : If we want to print all the error and execption and Super class of error is throwable
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, "Test Case Failed is" +result.getMethod().getMethodName());
			test.log(LogStatus.FAIL, "Test Case Failed is" +result.getThrowable()); 
			String scpath= screenshot(driver, result.getMethod().getMethodName());
			
			test.log(LogStatus.FAIL, test.addScreenCapture(scpath));
			
		}

		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", result.getThrowable().getMessage());
		
		log.info("TestCase Failed " + result.getMethod().getMethodName());
		
		
	}
	public void onTestSkipped(ITestResult result) {
		
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
		log.info("TestCase Skipped " + result.getMethod().getMethodName());
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		
	}

	public void onStart(ITestContext context) {
		log.info("Test Case Started"+ " " + context.getName());

		String workingdir= System.getProperty("user.dir");
		String datename= new SimpleDateFormat("yyyy-MM-d-hh-mm-ss").format(new Date());
		reports=new ExtentReports(workingdir+"\\ExtentReports\\ExtentReportResults"+ " "+datename+".html",true);
		
		reports.addSystemInfo("Host Name", "Chirag");
		reports.addSystemInfo("Enviroment", "QA");
		
	}

	public void onFinish(ITestContext context) {
		log.info("TestCase Finished " + context.getName());
		reports.endTest(test);
	    reports.flush();
	    

	}
	
	public void log(String details)
	{
		
		
		test.log(LogStatus.INFO, details);
		
		
	}
	

	

}