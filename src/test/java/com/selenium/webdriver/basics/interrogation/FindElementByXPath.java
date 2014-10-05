package com.selenium.webdriver.basics.interrogation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.Is.is;

import com.seleniumsimplified.webdriver.manager.Driver;

public class FindElementByXPath {
	static WebDriver driver;
	final static String pageTitle = "Welcome to the Find By Playground";
	
	@BeforeClass
	public static void createDriverAndVisitwebPage() {
		//driver = new FirefoxDriver()
		driver = Driver.get("http://www.compendiumdev.co.uk/" + 
										"selenium/find_by_playground.php");
	}
	
	@Test	
	public void findById() {
		WebElement element = driver.findElement(By.xpath("//div//p[contains(@id,'p31')]"));
		
		assertEquals("pName31", element.getAttribute("name"));
	}
	

	@Test	
	public void findByName() {
		WebElement element = driver.findElement(By.xpath("//ul[@name='ulName1']"));
		
		assertEquals("ul1", element.getAttribute("id"));
	}

	@Test	
	public void className() {
		WebElement element = driver.findElement(By.xpath("//div[@class='specialDiv']"));
		
		assertEquals("div1", element.getAttribute("id"));
	}
	
	@Test	
	public void tagName() {
		WebElement element = driver.findElement(By.xpath("//li"));
		
		assertEquals("liName1", element.getAttribute("name"));
		
		
	}
	
	@Test
//	@Override
	public void getTitle()
	{
		WebElement element = driver.findElement(By.tagName("title"));
		
		assertThat(pageTitle, is(element.getAttribute("text")));
		//return titleElement.getText();
	}
	
//	public static void main(String[] args)
//	{
//		FindElementByXPath el = new FindElementByXPath();
//		//System.out.println(el.getTitle() + "claro?");
//	}
}
