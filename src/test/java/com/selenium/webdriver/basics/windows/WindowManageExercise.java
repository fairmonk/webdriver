package com.selenium.webdriver.basics.windows;

import static org.junit.Assert.assertTrue;

import java.awt.Toolkit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import com.seleniumsimplified.webdriver.manager.Driver;

public class WindowManageExercise {
	
	static private WebDriver driver;
	
	@Before
	public void setup()
	{
		driver = Driver.get("http://www.compendiumdev.co.uk/selenium/bounce.html");
	}
	
	@Test
	public void maximiseWindow()
	{
		
		driver.manage().window().maximize();
		Dimension fullScreenSize = driver.manage().window().getSize();
		
		java.awt.Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		String expected = "";
		
		expected = ((int)screenDimension.getWidth()) + "approx (90% tolerance)" + fullScreenSize.getWidth();
		assertTrue(expected, (screenDimension.getWidth()*0.9) < fullScreenSize.getWidth());
		
		expected = ((int)screenDimension.getHeight()) + "approx (90% tolerance)" + fullScreenSize.getHeight();
		assertTrue(expected, (screenDimension.getHeight()*0.9) < fullScreenSize.getHeight());
		
	}
	
	@Test
	public void reduceWindowToHalfSize()
	{
		
	}
	
	@Test
	public void moveWindowToCenter()
	{
		
	}
	
	@Test
	public void bounceWindowArroundScreen()
	{
		
	}

}
