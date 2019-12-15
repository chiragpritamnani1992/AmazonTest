package com.qa.pages;

import java.io.FileNotFoundException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;




public class LoginPage extends TestBase{

Logger log= LogManager.getLogger(LoginPage.class);

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


public  HomePage enterLoginDetails() throws FileNotFoundException
{
	driver.findElement(email).sendKeys(property.getProperty("Username"));
	
	driver.findElement(continuee).click();
	
	driver.findElement(password).sendKeys(property.getProperty("Password"));
	
	driver.findElement(loginbtn).click();
	
	log.info("Login button clicked");

	return new HomePage();
	
		
}
}