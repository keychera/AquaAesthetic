package controllers;

import java.util.List;

import models.Aquarium;
import models.Fish;
import models.Food;

// TODO: Auto-generated Javadoc
/**
 * The Class GameRuleController.
 */
public class GameRuleController implements ISubController {
  
  /** The Constant FISHPRICE. */
  private static final int FISHPRICE = 200;
  
  /** The Constant FOODPRICE. */
  private static final int FOODPRICE = 20;
  
  /** The fish controller. */
  FishController fishController;
  
  /** The food controller. */
  FoodController foodController;

  /**
   * Instantiates a new game rule controller.
   *
   * @param fishController the fish controller
   * @param foodController the food controller
   */
  public GameRuleController(FishController fishController, FoodController foodController) {
    this.fishController = fishController;
    this.foodController = foodController;
  }

  /* (non-Javadoc)
   * @see controllers.ISubController#perform()
   */
  @Override
  public void perform() {
    Aquarium.money++;
  }

  /**
   * Handle add fish command.
   */
  public void handleAddFishCommand() {
    if (Aquarium.money > FISHPRICE) {
      fishController.addNewEntity();
      Aquarium.money -= FISHPRICE;
    }
  }

  /**
   * Handle add food command.
   */
  public void handleAddFoodCommand() {
    if (Aquarium.money > FOODPRICE) {
      foodController.addNewEntity();
      Aquarium.money -= FOODPRICE;
    }
  }

  /**
   * Gets the fishes.
   *
   * @return the fishes
   */
  // TODO these below, along with the whole design of GuiController seems like a bad choice
  public List<Fish> getFishes() {
    return fishController.getFishes();
  }

  /**
   * Gets the foods.
   *
   * @return the foods
   */
  public List<Food> getFoods() {
    // TODO Auto-generated method stub
    return foodController.getFoods();
  }

}
