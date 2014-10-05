package com.selenium.webdriver.basics.interrogation;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumsimplified.webdriver.manager.Driver;

public class FindElementsExerciseTest {

	static WebDriver driver;
	@BeforeClass
	public static void createDriverAndVisitwebPage() {
		//driver = new FirefoxDriver()
		driver = Driver.get("http://www.compendiumdev.co.uk/" + 
										"selenium/find_by_playground.php");
	}
	
	@Test
	public void doesFindElementsThrowAnExceptionIfNoMatch() {
		List<WebElement> elements;
		elements = driver.findElements(By.tagName("Bob"));
		
		assertEquals(0, elements.size());				
	}
	
	@Test
	public void assertDivElementsCount() {

		List<WebElement> elements;		
		elements = driver.findElements(By.tagName("div"));
		
		assertEquals(19, elements.size());
	}
	
	@Test
	public void assert25LocalHrefLinks() {
		List<WebElement> elements;
		elements = driver.findElements(By.partialLinkText("jump to"));
		
		assertEquals(25, elements.size());
	}
	
	@Test
	public void assertNumberOfParagraphs() {
		List<WebElement> elements;
		elements = driver.findElements(By.tagName("p"));
		
		int nestedCount = 0;
		for(WebElement e : elements){
			if(e.getText().contains("nested")){
				nestedCount++;
			}
		}
		
		assertEquals(41, elements.size());
		assertEquals(16, nestedCount);
	}
	
	@Test
	public void chainingWithFindElement() {
		WebElement element = driver.findElement(By.id("div1")).findElement(By.name("pName3")).findElement(By.tagName("a"));
		
		assertEquals("Expected a different id", "a2", element.getAttribute("id"));
	}
	
//	@Test
	
	@AfterClass
	public static void closeBrowser() {
		//driver.quit();
	}
	
}

