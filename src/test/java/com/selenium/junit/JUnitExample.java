package com.selenium.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JUnitExample {

	@Test
	public void twoPlusTwoEqualsFour(){
		assertEquals("2+2=4", 4, 2+2);
	}
	
}
