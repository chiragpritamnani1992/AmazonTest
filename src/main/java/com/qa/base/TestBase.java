package com.qa.base;


import java.beans.EventHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.qa.listener.TestNGListener;
import com.qa.listener.WebEventList;
import com.qa.test.LoginTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	
	public static Properties property;
	public static WebDriver driver;
	public static EventFiringWebDriver event;
	public static WebEventList list;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public TestBase()
	{
		Logger log= LogManager.getLogger(TestBase.class);
		{
			try{
				property= new Properties();
				FileInputStream fis = new FileInputStream("C:\\Users\\HP\\workspace\\Amazon_Exe\\src\\main\\java\\com\\qa\\config\\config.properties");
				property.load(fis);
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
	}
	
	

	public static void initlization() 
	{
		
		String browsername = property.getProperty("Browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Java_Amazon\\AmazonTest\\src\\main\\java\\com\\qa\\drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			event= new EventFiringWebDriver(driver);
			list= new WebEventList();
		    event.register(list);
			driver=event;
		
		}
		else
		{
			System.out.println("No Such Browser");
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.get(property.getProperty("Url"));
		
	
	}
	

	public String screenshot(WebDriver driver, String methodname)
	{
		String dateName=  new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		
		try
		{   TakesScreenshot sc = ((TakesScreenshot) driver);
			File src= sc.getScreenshotAs(OutputType.FILE);
			String dest =System.getProperty("user.dir")+"./Screenshots/"+ methodname+"_"+dateName+ ".png";
			
			File destination = new File(dest);
			
			FileUtils.copyFile(src, destination);
			System.out.println("Screenshot taken");
			return dest;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception wile taking Screenshots" + e.getMessage());
			return e.getMessage();
		}
	}
	/*
	@BeforeSuite
	public void ExtentReport()
	{
		String workingdir= System.getProperty("user.dir");
		String datename= new SimpleDateFormat("yyyy-MM-d-hh-mm-ss").format(new Date());
		reports=new ExtentReports(workingdir+"\\ExtentReports\\ExtentReportResults"+ " "+datename+".html",true);
	}
	*/
	
	/*@AfterSuite
	public void tearDownSuite(ITestResult result) {
	    
	   
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
			test.log(LogStatus.FAIL, "TestCase Failed");
		}
		
		reports.flush();
	   
	}*/
	 
	/* public void setUp(String method) throws Exception {
	     test = reports.startTest(method);
	     test.assignAuthor("Chirag");
	 //Rest code will be generic for browser initiliazion.

	 }*/
}
