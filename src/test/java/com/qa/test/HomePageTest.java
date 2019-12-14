package com.qa.test;

import java.io.FileNotFoundException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest {
	
	Logger log= LogManager.getLogger(HomePageTest.class);
	HomePage home;

public HomePageTest() throws FileNotFoundException {
	
	 home= new HomePage();
	
	}


@Test(priority=5)
public void clickonLink() throws InterruptedException
{
	
	home.clickonMobile();
	home.clickonLaptop();
	home.brands();
	home.Highprice();
	home.Star();
	home.sort();
}

}
