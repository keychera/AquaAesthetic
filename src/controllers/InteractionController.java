package controllers;

import java.util.List;

import models.Fish;
import models.Food;
import models.MovingObject;

public class InteractionController implements ISubController {
  private List<Fish> fishes;
  private List<Food> foods;

  public InteractionController(FishController fishController, FoodController foodController) {
    fishes = fishController.getFishes();
    foods = foodController.getFoods();
  }

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
