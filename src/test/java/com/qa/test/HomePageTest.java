package com.qa.test;

import java.io.FileNotFoundException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.listener.TestNGListener;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest {
	
	Logger log= LogManager.getLogger(HomePageTest.class);
	HomePage home;
	public static TestNGListener test = new TestNGListener();
public HomePageTest() throws FileNotFoundException {
	
	 home= new HomePage();
	
	}


@Test(priority=5)
public void clickonLink() throws InterruptedException
{
	
	home.clickonMobile();
	test.log("Clicked on Mobile Link");
	
	home.clickonLaptop();
	test.log("Clicked on Laptop");
	home.brands();
	test.log("Clicked on Brands Link");
	home.Highprice();
	test.log("Clicked on High Price");
	home.Star();
	test.log("Clicked on Star");
	home.sort();
	test.log("Clicked on Sort");
}

}
