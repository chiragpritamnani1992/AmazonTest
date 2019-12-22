package com.qa.ExtentReports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	
	
	public static ExtentReports getReporter()
	{
		try {
			String workingdir= System.getProperty("user.dir");
			String datename= new SimpleDateFormat("yyyy-MM-d-hh-mm-ss").format(new Date());
			extent=new ExtentReports(workingdir+"\\ExtentReports\\ExtentReportResults"+ " "+datename+".html",true);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return extent;
		
	}

}
