package test;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Fish;

// TODO: Auto-generated Javadoc
/**
 * The Class FishTest.
 */
public class FishTest {
	
	/** The goldfish. */
	Fish goldfish = new Fish(10,10);

	/**
	 * Test fish.
	 */
	@Test
	public void testFish() {
		assertFalse(goldfish.isHungry());
		assertEquals(-99, goldfish.getHunger());
	}

	

}
