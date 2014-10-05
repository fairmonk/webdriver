package com.selenium.webdriver.basics.windows;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import com.seleniumsimplified.webdriver.manager.Driver;

public class WindowManageExample {
	
	@Test
	public void manageWindow()
	{
		WebDriver driver = Driver.get("http://www.compendiumdev.co.uk/selenium/frames");
		
		driver.manage().window().setPosition(new Point(10, 20));
		Point pos = driver.manage().window().getPosition();
		
		assertEquals(10, pos.getX());
		assertEquals(20, pos.getY());
		
		driver.manage().window().setSize(new Dimension(300, 450));
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		Dimension winSizes = driver.manage().window().getSize();
		
		assertEquals(300, winSizes.getWidth());
		assertEquals(450, winSizes.getHeight());
	}

}
