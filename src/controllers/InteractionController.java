package controllers;

import java.util.List;

import models.Fish;
import models.Food;
import models.MovingObject;

// TODO: Auto-generated Javadoc
/**
 * The Class InteractionController.
 */
public class InteractionController implements ISubController {
  
  /** The fishes. */
  private List<Fish> fishes;
  
  /** The foods. */
  private List<Food> foods;

  /**
   * Instantiates a new interaction controller.
   *
   * @param fishController the fish controller
   * @param foodController the food controller
   */
  public InteractionController(FishController fishController, FoodController foodController) {
    fishes = fishController.getFishes();
    foods = foodController.getFoods();
  }

  /* (non-Javadoc)
   * @see controllers.ISubController#perform()
   */
  @Override
  public void perform() {
    for (Fish fish : fishes) {
      fish.setTargetFood(GetClosestFoodFrom(fish));
      for (Food food : foods) {
        boolean eatingStatus = (MovingObject.calcDistBetween(fish, food) < 10);
        if (eatingStatus && fish.isHungry()) {
          fish.hasEaten();
          food.hasBeenEaten();
          break;
        }
      }
    }
  }

  /**
   * Gets the closest food from.
   *
   * @param fish the fish
   * @return the food
   */
  private Food GetClosestFoodFrom(Fish fish) {
    if (foods.isEmpty()) {
      return null;
    }
    Food closestFood = null;
    for (Food checkingFood : foods) {
      if (closestFood == null) {
        closestFood = checkingFood;
      } else if (MovingObject.calcDistBetween(closestFood, fish) > MovingObject
          .calcDistBetween(checkingFood, fish)) {
        closestFood = checkingFood;
      }
    }
    return closestFood;
  }
}
