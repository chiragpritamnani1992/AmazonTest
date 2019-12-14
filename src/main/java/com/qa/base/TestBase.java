package com.qa.base;


import java.beans.EventHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.qa.listener.TestNGListener;
import com.qa.listener.WebEventList;

public class TestBase {
	
	public static Properties property;
	public static WebDriver driver;
	public static EventFiringWebDriver event;
	public static WebEventList list;

	public TestBase()
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
	
	
	public static void initlization() 
	{
		
		String browsername = property.getProperty("Browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "../Amazon_Exe/src/main/java/com/qa/drivers/chromedriver.exe");
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

	public String screenshot(String methodname)
	{
		
		
		try
		{   
			TakesScreenshot sc = ((TakesScreenshot) driver);
			File src= sc.getScreenshotAs(OutputType.FILE);
			String dest = "./Screenshots/"+ methodname+"_"+System.currentTimeMillis()+ ".png";
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
