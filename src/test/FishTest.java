package test;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Fish;

public class FishTest {
	
	Fish goldfish = new Fish(10,10);

	@Test
	public void testFish() {
		assertFalse(goldfish.isHungry());
		assertEquals(-99, goldfish.getHunger());
	}

	

}
