package test;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Food;

// TODO: Auto-generated Javadoc
/**
 * The Class FoodTest.
 */
public class FoodTest {

	/** The grass. */
	Food grass = new Food(0,0);
	
	/**
	 * Test food.
	 */
	@Test
	public void testFood() {
		assertFalse(grass.isOnRemoval());
	}

}
