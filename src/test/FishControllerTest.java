package controllers;

import static org.junit.Assert.*;

import org.junit.Test;

public class FishControllerTest {

	@Test
	public void testGetFishes() {
		FishController fises = new FishController();
		assertEquals(0, fises.getNumberOfFish());
	}

}
