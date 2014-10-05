package com.selenium.webdriver.basics.interrogation;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import org.hamcrest.core.Is;

import static org.hamcrest.Matchers.*;

import com.seleniumsimplified.webdriver.manager.Driver;
import org.openqa.selenium.WebDriver;

public class DriverLevelInterrogation {
	private static WebDriver driver;
	
	@BeforeClass
	public static void createDriver() {
		driver = Driver.get();		
	}
	
	@Test
	public void navigateTo() throws MalformedURLException {
		String url = "http://www.compendiumdev.co.uk/selenium/basic_web_page.html";
		driver.navigate().to(url);
		
//		assertEquals(driver.getTitle(), "Basic Web Page Title");
		assertThat(driver.getTitle(), is("Basic Web Page Title"));
		assertEquals(driver.getCurrentUrl(), url);
		
		String pageSource = driver.getPageSource();
//		assertTrue(driver.getPageSource().contains("A paragraph of text"));
		assertThat(pageSource, containsString("A paragraph of text"));
		System.out.println(driver.getPageSource());
	}
	
	
	
}