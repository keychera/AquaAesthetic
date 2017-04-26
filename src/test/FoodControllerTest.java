package controllers;

import static org.junit.Assert.*;

import org.junit.Test;

public class FoodControllerTest {

	@Test
	public void test() {
		
		FoodController fd = new FoodController();
		fd.addNewEntity();
		assertEquals(1,fd.getFoods().size());
	}

}
