package com.selenium.webdriver.basics.manipulation;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumsimplified.webdriver.manager.Driver;

public class ManipulationExerciseCheckboxTest {
	
	private static WebDriver driver;
	
	@Before
	public void setup()
	{
		driver = Driver.get("http://compendiumdev.co.uk/selenium/basic_html_form.html");
	}
	
	@Test
	public void submitFormWithOnlyCheckbox1SelectedFindElementException(){
		
		WebElement checkBox1;
		WebElement checkBox3;
		
		checkBox1 = driver.findElement(By.cssSelector("input[value='cb1']"));
		checkBox3 = driver.findElement(By.cssSelector("input[value='cb3']"));
		
		checkBox1.click();
		
		if(checkBox3.isSelected())
		{
			checkBox3.click();
		}
		
		clickSubmitButton();
		
		assertCheckBoxResults();
	}
	
	private void assertCheckBoxResults()
	{
		WebElement checkbox1Result;
		WebElement checkbox3Result = null;
		
		checkbox1Result = driver.findElement(By.id("_valuecheckboxes0"));
		
		try{
			checkbox3Result = driver.findElement(By.id("_valuecheckboxes2"));
		}catch(NoSuchElementException e){
			//expected missing element
		}
		
		assertTrue("expected to find checkbox 1", checkbox1Result != null);
		assertTrue("expected not to find checkbox 3", checkbox3Result == null);
	}
	
	private void clickSubmitButton()
	{
		WebElement submitButton;
		submitButton = driver.findElement(By.cssSelector("input[type='submit'][name='submitbutton']"));
		
		submitButton.click();
	}
}
