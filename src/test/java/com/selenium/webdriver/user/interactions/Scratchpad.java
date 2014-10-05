package com.selenium.webdriver.user.interactions;

import com.seleniumsimplified.webdriver.manager.Driver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by misha on 9/21/2014.
 */
public class Scratchpad {
    private static WebDriver driver;

    @BeforeClass
    public static void setupDriver()
    {
        driver = Driver.get("http://compendiumdev.co.uk/selenium/basic_html_form.html");
    }

    @Test
    public void mystyf(){
        new Actions(driver).click(driver.findElement(By.cssSelector("input[value='cb1']"))).perform();


    }
}
