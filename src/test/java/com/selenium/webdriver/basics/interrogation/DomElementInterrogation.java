package com.selenium.webdriver.basics.interrogation;

import static org.junit.Assert.assertEquals;
import static  org.junit.Assert.assertThat;
//import static org.junit.Assert.assertTrue;
import static org.hamcrest.Matchers.is;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DomElementInterrogation {

	@Test
	public void WebElementInterrogationBasics() {
		final WebDriver driver;
		final String theTestWebPage = "http://www.compendiumdev.co.uk/" + 
										"/selenium//basic_web_page.html";
		
		driver = new FirefoxDriver();
		
		driver.navigate().to(theTestWebPage);
		
		WebElement para1 = driver.findElement(By.id("para1"));
		assertEquals(para1.getText(),"A paragraph of text");
		assertThat(para1.getText(), is("A paragraph of text"));
	}
}
