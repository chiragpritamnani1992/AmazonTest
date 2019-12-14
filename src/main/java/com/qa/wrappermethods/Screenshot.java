package com.qa.wrappermethods;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static WebDriver driver;
	/*public String screenshot(WebDriver driver,String methodname)
	{
		
		
		try
		{   
			TakesScreenshot sc = (TakesScreenshot)driver;
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
	}*/
}
