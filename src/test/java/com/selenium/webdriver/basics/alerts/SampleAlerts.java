package com.selenium.webdriver.basics.alerts;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumsimplified.webdriver.manager.Driver;

public class SampleAlerts {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void getDriver()
	{
		driver = Driver.get("http://compendiumdev.co.uk/selenium/alerts.html");
	}
	
	@Test
	public void basicAlertHandlingExample()
	{
		WebElement alertButton;
		alertButton = driver.findElement(By.cssSelector("#alertexamples"));
		alertButton.click();
		
		String alertMessage = "I am an alert box!";
		
		assertEquals(alertMessage, driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void basicAlertHandlingDismissTest()
	{
		WebElement alertButton;
		alertButton = driver.findElement(By.cssSelector("#alertexamples"));
		alertButton.click();
		
		String alertMessage = "I am an alert box!";
		
		assertEquals(alertMessage, driver.switchTo().alert().getText());
		
		driver.switchTo().alert().dismiss();
	}
	
	@Test
	public void basicConfirmHandlingAcceptTest()
	{
		WebElement confirmButton;
		WebElement confirmResult;
		
		confirmButton = driver.findElement(By.cssSelector("#confirmexample"));
		confirmResult = driver.findElement(By.id("confirmreturn"));
		
		assertEquals("cret", confirmResult.getText());
		confirmButton.click();
				
		String alertMessage = "I am a confirm alert";
		
		Alert confirmAlert = driver.switchTo().alert();
		
		assertEquals(alertMessage, confirmAlert.getText());
		
		confirmAlert.accept();
	}

	@Test
	public void basicPromptHandlingExample()
	{
		WebElement alertButton;
		alertButton = driver.findElement(By.cssSelector("#promptexample"));
		alertButton.click();
		
		String alertMessage = "I prompt you";
		
		assertEquals(alertMessage, driver.switchTo().alert().getText());
		
		
		driver.switchTo().alert().sendKeys("come on!");
		driver.switchTo().alert().accept();
		
		assertEquals("come on!", driver.findElement(By.id("promptreturn")).getText());
	
	}
}
