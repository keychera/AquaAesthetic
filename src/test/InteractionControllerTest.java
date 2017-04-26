package test;

import static org.junit.Assert.*;

import controllers.InteractionController;
import controllers.FishController;
import controllers.FoodController;

import org.junit.Test;

public class InteractionControllerTest {

	@Test
	public void test() {
		FishController fish = new FishController();
		FoodController food = new FoodController();
		
		InteractionController ic = new InteractionController(fish, food);
		ic.perform();
		
	}

}
