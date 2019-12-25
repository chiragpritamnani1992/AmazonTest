package com.qa.base;



import java.io.File;
import java.io.FileInputStream;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Parameters;

import com.qa.listener.WebEventList;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class TestBase {
	
	public static Properties property;
	public static WebDriver driver;
	public static EventFiringWebDriver event;
	public static WebEventList list;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public TestBase()
	{

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
	
	
	//@Parameters("browser")
	public static void initlization() 
	{
		
		String browsername = property.getProperty("Browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Jenkins\\drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			event= new EventFiringWebDriver(driver);
			list= new WebEventList();
		    event.register(list);
			driver=event;
		
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Jenkins\\drivers\\geckodriver.exe");
			driver= new FirefoxDriver();
			event= new EventFiringWebDriver(driver);
			list= new WebEventList();
		    event.register(list);
			driver=event;
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.get(property.getProperty("Url"));
		
	
	}
	

	public String screenshot(WebDriver driver, String methodname)
	{
		String dateName=  new SimpleDateFormat("dd-mm-yyyy-dd-hh-ss").format(new Date());
		
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
	
	
	
}
