package com.qa.test;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;


public class LoginTest extends TestBase{

	public static LoginPage login;
	Logger log= LogManager.getLogger(LoginTest.class);
	public SoftAssert asse= new SoftAssert();

	HomePage homepage;
	
	public LoginTest() throws FileNotFoundException {
	
		super();
	
	}

	
	@BeforeTest 
	public void Browserinitlization() throws FileNotFoundException, InterruptedException
	{
		
		initlization();
		login= new LoginPage();
		homepage= new HomePage();
		
		log.info("Browser Intiliazed");

		Thread.sleep(4000);
	}
	
	@Test(priority=1)
	public void verifyTitle() throws InterruptedException
	{

	
		
		String title= login.verifyPageTitle();
		try {
			log.info("Title of the Page is" + " " + title);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(5000);
		asse.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		//asse.assertAll();
		/*asse.assertEquals(actual, expected);
		asse.assertEqualsNoOrder(actual, expected);
		asse.assertNotEquals(actual, expected);
		asse.assertNotNull(object);
		asse.assertNotSame(actual, expected);
		asse.assertSame(actual, expected);
		asse.assertNull(object, message);
		asse.assertTrue(condition, message);
		
		*/
		
	}
	
	@Test(priority=2)
	public void menuclick() throws FileNotFoundException
	{
		
		login.clickLogin();
		log.info("Clicked on Menu Button");
		
	}
	
	@Test(priority=3)
	public void signin()
	{
		
		login.clickSignin();
		log.info("Clicked on SignIn Link");
	}
	
	
	@Test(priority=4)
	public void login() throws FileNotFoundException
	{
		
		homepage=login.enterLoginDetails();
		log.info("Username and Password Entered");
		
		
	}
	
	
	
}
