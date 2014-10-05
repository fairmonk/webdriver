package com.selenium.webdriver.basics.manipulation;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.seleniumsimplified.webdriver.manager.Driver;

public class ManipulationFirstExampleTest {
	private static WebDriver driver;
	
	@Before
	public void setup()
	{
		driver = Driver.get("http://www.compendiumdev.co.uk/selenium/basic_ajax.html");
	}
	
	@Test
	public void myFirstManipulation()
	{
		// findElement <option value="3">Server</option>
		driver.findElement(By.cssSelector("option[value='3']")).click();
		
		new WebDriverWait(driver, 10, 50).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("option[value='23']")));
		
		// findElement <option value="23">Java</option>
		driver.findElement(By.cssSelector("option[value='3']")).click();
		
		// findElement name = submitbutton
		driver.findElement(By.name("submitbutton")).click();
		
		// <li id="_valuelanguage_id">23</li>
		
		assertThat(driver.findElement(By.cssSelector("#_valuelanguage_id")).getText(), is("20"));
	}

}
