package com.selenium.webdriver.basics.interrogation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumsimplified.webdriver.manager.Driver;

public class FindElementsExampleTest {
	@Test
	public void returnAListOfElementsByClassName() {
		WebDriver driver = Driver.get();
		List<WebElement> elements;
		elements = driver.findElements(By.className("normal"));
		
		Set<String> foundTags = new HashSet<>();
		
		for(WebElement e : elements){
			foundTags.add(e.getTagName());
		}
		
		assertTrue("expected p tag", foundTags.contains("p"));
		assertTrue("expected ul tag", foundTags.contains("ul"));
		assertTrue("expected li tag", foundTags.contains("li"));
		assertTrue("expected a tag", foundTags.contains("a"));
		assertFalse("did not expect div tag", foundTags.contains("div"));
	}


}
