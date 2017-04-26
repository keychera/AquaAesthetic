package test;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.GameRuleController;
import models.Aquarium;
import controllers.FishController;
import controllers.FoodController;
import models.Aquarium;

public class GameRuleControllerTest {

	@Test
	public void testHandleAddFishCommand() {
		FishController fi = new FishController();
		FoodController fo = new FoodController();
		
		GameRuleController gr = new GameRuleController(fi,fo);
		
		gr.perform();
		assertEquals(1001, Aquarium.money);
		gr.handleAddFishCommand();
		assertEquals(1, gr.getFishes().size());
		gr.handleAddFoodCommand();
		assertEquals(1, gr.getFoods().size());
		
		
	}

}
