package com.selenium.webdriver.basics.frames;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.seleniumsimplified.webdriver.manager.Driver;

public class FramesExercisesTest {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@Before
	public void setup()
	{
		driver = Driver.get("http://www.compendiumdev.co.uk/selenium/frames");
		wait = new WebDriverWait(driver, Driver.DEFAULT_TIMEOUT_SECONDS);
	}
	
	@Test
	public void loadTheGreenPage()
	{
		assertThat(driver.getTitle(), is("Frameset Example Title (Example 6)"));
		
		// load the green page
		driver.switchTo().frame("content");
		driver.findElement(By.cssSelector("a[href='green.html']")).click();
		
		wait.until(presenceOfElementLocated(By.cssSelector("h1[id='green']")));
		
		// click on "Back to original page"
		driver.findElement(By.cssSelector("a[href='content.html']")).click();
		
		WebElement h1 = wait.until(presenceOfElementLocated(By.xpath("//h1[.='Content']")));
		
		assertThat(h1.getText(), is("Content"));
	}
}
