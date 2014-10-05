package com.selenium.webdriver.basics.interrogation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

//import net.sourceforge.htmlunit.corejs.javascript.ast.Jump;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.By.ById;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumsimplified.webdriver.manager.Driver;

public class FirstFindByExercisesTest {
	
	static WebDriver driver;
	
	@BeforeClass
	public static void createDriverAndVisitWebPage() {
		driver = Driver.get("http://www.compendiumdev.co.uk/" + 
										"selenium/find_by_playground.php");
	}
	
	@Test
	public void noSuchElementException_thrownWhenLocatorWrong() {
		try{
			
			WebElement cParagraph = driver.findElement(By.id("p3Name"));
			fail("Expected NoSuchElementException");
			
		}catch(NoSuchElementException e){
			//ignore, we want to find an exception
		}
	}
	
	@Test(expected = NoSuchElementException.class)
	public void noSuchElementException_thrownWhenLocatorWrongExpected() {
		
		//id is p3, name is p3Name, this will fail
		WebElement cParagraph = driver.findElement(By.id("p3Name"));
	}
	
	@Test
	public void findByID() {
		WebElement cParagraph = driver.findElement(By.id("p3"));
		
		assertEquals("This is c paragraph text", cParagraph.getText());
	}
	
	@Test
	public void findByLinkTest() {
		//look for an <a> via the text
		WebElement jumpToPara0 = driver.findElement(By.linkText("jump to para 0"));
		
		assertEquals("a26", jumpToPara0.getAttribute("id"));
	}
	
	@Test
	public void findByName() {
		WebElement aParagraph = driver.findElement(By.name("pName1"));
		
		assertEquals("This is a paragraph text", aParagraph.getText());
	}
	
	@Test
	public void findByPartialLinkText() {
		//match an <a> using part of the link text
		
		//match beginning of the text
		WebElement jump_to = driver.findElement(By.partialLinkText("jump to"));
		assertEquals("jump to para 0", jump_to.getText());
		
		//match middle of text
		jump_to = null;
		WebElement jump_t = driver.findElement(By.partialLinkText("to"));
		assertEquals("jump to para 0", jump_t.getText());
	}
	
	@Test
	public void findByClassName() {
		//match an element's class attribute
		WebElement aDiv = driver.findElement(By.className("specialDiv"));
		assertEquals("mydivname", aDiv.getAttribute("name"));
	}
	
	@AfterClass
	public static void closeBrowser() {
		//driver.quit();
	}
}
