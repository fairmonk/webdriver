package com.selenium.webdriver.basics.alerts;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.hamcrest.Matchers;

import com.seleniumsimplified.webdriver.manager.Driver;

public class LoginYahoo {
	public static WebDriver driver;
	
	@Before
	public void navigateWebPage()
	{
		driver = Driver.get("http://mail.yahoo.com");
	}
	
	@Test
	public void login()
	{
		String username = "dummy";
		String password = "dummy";
		
		
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.sendKeys(username);		
		WebElement userPasswordField = driver.findElement(By.id("passwd"));
		userPasswordField.sendKeys(password);
		
		driver.findElement(By.cssSelector("button[type='submit']")).click(); //hit submit button
		new WebDriverWait(driver, 10, 50).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[alt*='Mihai Avatar']")));
		
		assertTrue("Page title does not contain username!!!", driver.getTitle().contains(username));
	}
}
