/*package com.qa.ExtentReports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.IReporter;
import com.relevantcodes.extentreports.LogStatus;

import com.relevantcodes.extentreports.model.Test;


public abstract class ExtentReportListerners {


	
	
	
	public static ExtentHtmlReporter htmlreporter; //builds a new report using the html template 
	public static ExtentReports extent;
	 protected static ExtentReports reports;
	 protected static ExtentTest test;
    
  
    public void startReport()
	{
		
			String workingdir= System.getProperty("user.dir");
			String datename= new SimpleDateFormat("yyyy-MM-d-hh-mm-ss").format(new Date());
			htmlreporter= new ExtentHtmlReporter(workingdir+"\\ExtentReports\\ExtentReportResults"+ " "+datename+".html");
			
			 extent = new ExtentReports();
		     extent.attachReporter(htmlreporter);
	}
    
    public void report()
    {
    	String workingdir= System.getProperty("user.dir");
		String datename= new SimpleDateFormat("yyyy-MM-d-hh-mm-ss").format(new Date());
		reports=new ExtentReports(workingdir+"\\ExtentReports\\ExtentReportResults"+ " "+datename+".html",true);
    }
}
}*/