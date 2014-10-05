package com.selenium.webdriver.user.interactions;

import static org.junit.Assert.assertEquals;
    import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumsimplified.webdriver.manager.Driver;

public class SampleExercises {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setupDriver()
	{
		driver = Driver.get("http://compendiumdev.co.uk/selenium/gui_user_interactions.html");
	}
	
	@Before
	public void resetPage()
	{
		driver.navigate().refresh();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("canvas")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("keyeventslist")));
		
		//user interactions can be intermittent
		//so click on the html to force focus to the page
		
		driver.findElement(By.tagName("html")).click();	
	}
	
	@Test
	public void moveDrag1ToDrop1()
	{
		WebElement element1 = driver.findElement(By.cssSelector("#draggable1"));
		WebElement element2 = driver.findElement(By.cssSelector("#droppable1"));
		
		Action clickAndDrag = new Actions(driver).
				dragAndDrop(element1, element2).
				build();
		clickAndDrag.perform();
		
		String elText = driver.findElement(By.cssSelector("#droppable1")).getText();
		String textOnElement2 = "Dropped!";
		
		assertTrue("Dragging of draggable1 failed onto droppable1", elText.equals(textOnElement2));
		
	}
	
	@Test
	public void dragAndDropDraggable2ToDroppable1()
	{
		WebElement element1 = driver.findElement(By.cssSelector("#draggable2"));
		WebElement element2 = driver.findElement(By.cssSelector("#droppable1"));
		
		Action clickAndDrag = new Actions(driver).
				dragAndDrop(element1, element2).
				build();
		clickAndDrag.perform();
		
		String elText = driver.findElement(By.cssSelector("#droppable1")).getText();
		String textOnElement2 = "Get Off Me!";
		
		assertTrue("Dragging of draggable2 failed onto droppable1", elText.equals(textOnElement2));
	}
	
	@Test
	public void controlAndBwaHaHa()
	{
		/* when we issue a control + B draggable1 says "Bwa ha ha" */
		
		WebElement draggable1 = driver.findElement(By.id("draggable1"));
		
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys("b").keyUp(Keys.CONTROL).perform();
		
		assertEquals("Bwa! Ha! Ha!", draggable1.getText());
	}
	
	@Test
	public void drawSomethingOnCanvas()
	{
		WebElement canvas = driver.findElement(By.id("canvas"));
		WebElement eventList = driver.findElement(By.id("keyeventslist"));
		
		int eventCount = eventList.findElements(By.tagName("li")).size();
		
		new Actions(driver).
				// click doesn't do it, need to click and hold
				//click (canvas)
		
				clickAndHold(canvas).
				moveByOffset(10, 10).
				release().
				perform();
		
		assertTrue("we should have had some draw events", eventCount < eventList.findElements(By.tagName("li")).size());
	}
	
}
