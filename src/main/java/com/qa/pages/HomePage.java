package com.qa.pages;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends LoginPage {
	
	Logger log= LogManager.getLogger(HomePage.class);
	static String amount;

	By menu=By.xpath("//a[@id='nav-hamburger-menu']");

	By Mobile= By.xpath("//div[contains(text(),'Mobiles, Computers')]");
	
	By laptop= By.xpath("//div[contains(text(),'Laptops')]");
	
	By applecheck= By.xpath("//input[@name='s-ref-checkbox-Apple']");
	
	By star= By.xpath("//section[@aria-label='4 Stars & Up']");
	
	//span [contains(text(),'4 Stars & Up')]
	public HomePage()  throws FileNotFoundException
	{
		PageFactory.initElements(driver, this);
	}

	
	public void clickonMobile()
	{
		driver.findElement(menu).click();
		log.info("Clicked on Menu button");
		driver.findElement(Mobile).click();
		log.info("Clicked on Mobile & Computers Link");
	}
	
	public void clickonLaptop() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(laptop).click();
		log.info("Clicked on Laptop Link");
	}
	
	public void brands()
	{
		driver.findElement(applecheck).click();
		log.info("Apple Brand Clicked");
	}
	
	public void Highprice()
	{
				Select sel= new Select(driver.findElement(By.xpath("//select[@id='s-result-sort-select']")));
				sel.selectByVisibleText("Price: High to Low");
				log.info("Clicked on High to low");
	}
	public void Star() throws InterruptedException
	{	
		Thread.sleep(2000);
		driver.findElement(star).click();
	}
	
	public void sort() throws InterruptedException
	{
		Thread.sleep(5000);
		List<WebElement> ele = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		System.out.println(ele.size());
		
		for(int i=0;i<ele.size();i++)
		{
			ele.get(0).click();
			break;
		}
		
		
	}
}
