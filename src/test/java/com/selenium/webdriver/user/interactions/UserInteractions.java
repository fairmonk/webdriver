package com.selenium.webdriver.user.interactions;

import static org.junit.Assert.assertTrue;

import com.seleniumsimplified.webdriver.manager.Driver;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by misha on 9/28/2014.
 */
public class UserInteractions {
    public static WebDriver driver;

    @BeforeClass
    public static void setupDriver(){
        driver = Driver.get("http://compendiumdev.co.uk/selenium/gui_user_interactions.html");
    }

    @Before
    public void resetpage(){
        driver.navigate().refresh();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("canvas")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("keyeventslist")));

        driver.findElement(By.tagName("html")).click();
    }
    @Test
    public void moveDrag1ToDrop1(){
        WebElement element1 = driver.findElement(By.cssSelector("#draggable1"));
        WebElement element2 = driver.findElement(By.cssSelector("#droppable1"));

        Action clickAndDrag = new Actions(driver).dragAndDrop(element1, element2).build();
        clickAndDrag.perform();

        String elText = driver.findElement(By.cssSelector("#droppable1")).getText();
        String textOnElement2 = "Dropped!";

        assertTrue("Dragging of draggable1 failed onto droppable1", elText.equals(textOnElement2));
    }

}
