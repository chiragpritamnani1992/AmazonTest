/*package com.qa.ExtentReports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
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
*/