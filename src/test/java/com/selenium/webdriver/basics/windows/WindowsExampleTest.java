package com.selenium.webdriver.basics.windows;

import com.seleniumsimplified.webdriver.manager.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByCssSelector;

import java.util.Iterator;
import java.util.Set;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
public class WindowsExampleTest {
	
@SuppressWarnings("deprecation")
@Test
public void switchToNewWindow()
{
// Current bug open with chrome driver
// http://code.google.com/p/chromedriver/issues/detail?id=107
	WebDriver driver = Driver.get("http://www.compendiumdev.co.uk/selenium/frames");
	
	String framesWindowHandle = driver.getWindowHandle();
	assertEquals("Expected only 1 current window", 1, driver.getWindowHandles().size());
	
	driver.switchTo().frame("content");
	driver.findElement(By.cssSelector("a[href='http://www.seleniumsimplified.com']")).click();
	assertEquals("Expected a New Window opened", 2, driver.getWindowHandles().size());
	
	Set<String> myWindows = driver.getWindowHandles();
	String newWindowHandle="";
	
	for(String aHandle : myWindows)
	{
		if(!framesWindowHandle.contentEquals(aHandle))
		{
			newWindowHandle = aHandle; break;
		}
	}
	driver.switchTo().window(newWindowHandle);
	assertTrue("Expected Selenium Simplified site",
			driver.getTitle().contains("Selenium Simplified"));
}

@SuppressWarnings("deprecation")
@Test
public void switchBetweenWindows()
{
	Driver.quit();
	WebDriver driver = Driver.get("http://compendiumdev.co.uk/selenium/frames/");
	
	String framesWindowHandle = driver.getWindowHandle();
	
	driver.switchTo().frame("content");
	driver.findElement(By.cssSelector("a[href='http://www.seleniumsimplified.com']")).click();
	
	String newWindowHandle = framesWindowHandle;
	
	Iterator<String> aHandle = driver.getWindowHandles().iterator();
	int size =  driver.getWindowHandles().size();
	
	while(newWindowHandle.equals(framesWindowHandle))
	{
		
			newWindowHandle = aHandle.next();	
		
		
	}
	
	driver.switchTo().window(newWindowHandle);
	assertTrue("Expected Selenium Simplified Site", driver.getTitle().contains("Selenium Simplified"));
	
	driver.switchTo().window(framesWindowHandle);
	assertTrue("Expected frames window", driver.getTitle().contains("Frameset Example"));
}

@SuppressWarnings("deprecation")
@Test
public void switchToByName()
{
	Driver.quit();
	WebDriver driver = Driver.get("http://compendiumdev.co.uk/selenium/frames");
	
	String framesWindowHandle = driver.getWindowHandle();
	
	driver.switchTo().frame("content");
	driver.findElement(By.cssSelector("a[id='goevil']")).click();
	driver.findElement(By.cssSelector("a[target='compdev']")).click();
	
	driver.switchTo().window("compdev");
	assertTrue("Expected Software Testing", driver.getTitle().contains("Software Testing"));
	
	driver.switchTo().window("evil");
	assertTrue("Expected Evil Tester", driver.getTitle().contains("EvilTester"));
	
	driver.switchTo().window(framesWindowHandle);
	assertTrue("Expected Frames site", driver.getTitle().contains("Frameset Example"));
	
	driver.switchTo().window("compdev");
	driver.close();
	assertEquals("Expected 2 windows left", 2, driver.getWindowHandles().size());
	
	driver.switchTo().window("evil");
	driver.close();
	assertEquals("Expected 1 windows left", 1, driver.getWindowHandles().size());
}

}