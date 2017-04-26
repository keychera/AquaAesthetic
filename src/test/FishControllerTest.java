package test;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.FishController;

public class FishControllerTest {

	@Test
	public void testGetFishes() {
		FishController fises = new FishController();
		assertEquals(0, fises.getNumberOfFish());
	}

}
