package com.selenium.webdriver.basics.interrogation;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumsimplified.webdriver.manager.Driver;

public class FindElementByCssSelector {
	
	static WebDriver driver;
	@BeforeClass
	public static void createDriverAndVisitwebPage() {
		//driver = new FirefoxDriver()
		driver = Driver.get("http://www.compendiumdev.co.uk/" + 
										"selenium/find_by_playground.php");
	}
	
	@Test	
	public void findById() {
		WebElement element = driver.findElement(By.cssSelector("#p31"));
		
		assertEquals("pName31", element.getAttribute("name"));
	}
	

	@Test	
	public void findByName() {
		WebElement element = driver.findElement(By.cssSelector("[name=ulName1]"));
		
		assertEquals("ul1", element.getAttribute("id"));
	}

	@Test	
	public void className() {
		WebElement element = driver.findElement(By.cssSelector(".specialDiv"));
		
		assertEquals("div1", element.getAttribute("id"));
	}
	
	@Test	
	public void tagName() {
		WebElement element = driver.findElement(By.cssSelector("li"));
		
		assertEquals("liName1", element.getAttribute("name"));
	}
}
