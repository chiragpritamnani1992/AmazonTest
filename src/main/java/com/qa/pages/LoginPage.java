package com.qa.pages;

import java.io.FileNotFoundException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.utility.MasterData;

public class LoginPage extends TestBase{

Logger log= LogManager.getLogger(LoginPage.class);
public static MasterData m = new MasterData();


By menu=By.xpath("//a[@id='nav-hamburger-menu']");

By sigin= By.xpath("//div[@id='hmenu-customer-profile']");
	
By email= By.xpath("//input[@id='ap_email']");

By continuee= By.xpath("//input[@id='continue']");
	
By password= By.xpath("//input[@id='ap_password']");

By loginbtn= By.xpath("//input[@id='signInSubmit']");


public LoginPage() throws FileNotFoundException
{
	PageFactory.initElements(driver, this);
	
}
	
	
public String verifyPageTitle()
{
	return driver.getTitle();
	
}
public void clickLogin()
{
	driver.findElement(menu).click();
}

public void clickSignin()
{
	driver.findElement(sigin).click();
}


public  void enterLoginDetails(String username, String password1) throws Exception
{
	//driver.findElement(email).sendKeys(property.getProperty("Username"));
	
	
	//driver.findElement(password).sendKeys(property.getProperty("Password"));
	
	driver.findElement(email).sendKeys(username);
	driver.findElement(continuee).click();
	driver.findElement(password).sendKeys(password1);
	
	
	driver.findElement(loginbtn).click();
	
	log.info("Login button clicked");
	Thread.sleep(2000);
	driver.findElement(menu).click();
	driver.findElement(By.xpath("//div[contains(text(),'Sign Out')]")).click();
	//driver.close();
	//return new HomePage();
	
		
}
}