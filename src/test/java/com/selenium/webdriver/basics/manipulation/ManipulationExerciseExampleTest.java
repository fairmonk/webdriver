package com.selenium.webdriver.basics.manipulation;

import static org.junit.Assert.*;

import static org.hamcrest.core.IsNot.not;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumsimplified.webdriver.manager.Driver;

public class ManipulationExerciseExampleTest {
	static WebDriver driver;
	
	@BeforeClass
	public static void createDriverAndVisitWebPage()
	{
		driver = Driver.get("http://compendiumdev.co.uk/selenium/basic_html_form.html");
		
	}
	
	@Test
	public void AssertWebTitleChangesOnFormSubmit()
	{
		/*
		 * Submit form and assert page title changes
		 */
		createDriverAndVisitWebPage();
		String pageTitleBeforeSubmit = driver.getTitle();
		driver.findElement(By.cssSelector("input[value='submit']")).click();
		
		assertThat("PageTitle is the same, something went wrong", pageTitleBeforeSubmit, not(driver.getTitle()));
	}
	
	@Test
	public void ClearTypeCommentsSubmitFormAndCheckOutput()
	{
		
	}
	
	@Test
	public void SubmitFormWithRadio2Selected()
	{
		createDriverAndVisitWebPage();
		String pageTitleBeforeSubmit = driver.getTitle();
		
		driver.findElement(By.cssSelector("input[value='rd2']")).click();
		driver.findElement(By.cssSelector("input[value='submit']")).click();
		
		assertThat("PageTitle is the same, something went wrong", pageTitleBeforeSubmit, not(driver.getTitle()));
	}
	
	@Test
	public void SubmitFormWithCheckBox1Selected()
	{
		//Submit form with only checkbox 1 selected
		driver = Driver.get("http://compendiumdev.co.uk/selenium/basic_html_form.html");
		String pageTitleBeforeSubmit = driver.getTitle();	
		
		driver.findElement(By.cssSelector("input[value='cb1']")).click();
		driver.findElement(By.cssSelector("input[value='submit']")).click();
		
		assertThat("PageTitle is the same, something went wrong", pageTitleBeforeSubmit, not(driver.getTitle()));
	}
	
	@Test
	public void SubmitFormWithDropDownItem5Selected()
	{
		driver = Driver.get("http://compendiumdev.co.uk/selenium/basic_html_form.html");
		driver.findElement(By.cssSelector("[value='dd5']")).click();
		driver.findElement(By.cssSelector("input[value='submit']")).click();
		WebElement element = driver.findElement(By.xpath("//li[contains(.,'dd5')]"));
		assertEquals("dd5 Element not found", "dd5", element.getText());
	}
	
	@Test
	public void SubmitFormWithMultipleSelect123()
	{
		driver.findElement(By.cssSelector("option[value='ms1']")).click();
		driver.findElement(By.cssSelector("option[value='ms1']")).click();
	}

}
