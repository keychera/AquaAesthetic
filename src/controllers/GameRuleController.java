package controllers;

import java.util.List;

import models.Aquarium;
import models.Fish;
import models.Food;

public class GameRuleController implements ISubController {
  private static final int FISHPRICE = 200;
  private static final int FOODPRICE = 20;
  FishController fishController;
  FoodController foodController;

  public GameRuleController(FishController fishController, FoodController foodController) {
    this.fishController = fishController;
    this.foodController = foodController;
  }

  @Override
  public void perform() {
    Aquarium.money++;
  }

  public void handleAddFishCommand() {
    if (Aquarium.money > FISHPRICE) {
      fishController.addNewEntity();
      Aquarium.money -= FISHPRICE;
    }
  }

  public void handleAddFoodCommand() {
    if (Aquarium.money > FOODPRICE) {
      foodController.addNewEntity();
      Aquarium.money -= FOODPRICE;
    }
  }

  // TODO these below, along with the whole design of GuiController seems like a bad choice
  public List<Fish> getFishes() {
    return fishController.getFishes();
  }

  public List<Food> getFoods() {
    // TODO Auto-generated method stub
    return foodController.getFoods();
  }

}
