package com.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.utility.XLUtils;

public class FBTEst {
	WebDriver driver;
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path="C:\\Users\\HP\\Java_Amazon\\AmazonTest\\src\\main\\java\\com\\qa\\data\\datasheet_1.xlsx";
		int rowNum= XLUtils.getRowCount(path, "sheet1");
		int colCount= XLUtils.getCellCount(path, "sheet1", 1);
		String loginData[][]=new String[rowNum][colCount];
		
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				// Array starts from 0 and excel sheet starts from1
				loginData[i-1][j]= XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		return loginData;
		
		
		
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jenkins\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
	}
	
	@Test(dataProvider="LoginData")
	public void Test(String Uname)
	{
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(Uname);
		
	}
	
	/*@AfterMethod
	public void tearDown()
	{
		driver.close();
	}*/
}
