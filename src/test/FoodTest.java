package test;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Food;

public class FoodTest {

	Food grass = new Food(0,0);
	@Test
	public void testFood() {
		assertFalse(grass.isOnRemoval());
	}

}
