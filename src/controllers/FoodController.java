package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Aquarium;
import models.Fish;
import models.Food;

// TODO: Auto-generated Javadoc
/**
 * The Class FoodController.
 */
public class FoodController implements ISubController {

  /** The foods. */
  private List<Food> foods;

  /** The to remove. */
  private List<Food> toRemove;

  /**
   * Instantiates a new food controller.
   */
  public FoodController() {
    foods = new ArrayList<>();
    toRemove = new ArrayList<>();
  }

  /**
   * Gets the foods.
   *
   * @return the foods
   */
  public List<Food> getFoods() {
    return foods;
  }

  /*
   * (non-Javadoc)
   * 
   * @see controllers.ISubController#perform()
   */
  @Override
  public void perform() {
    removeObsoleteFoods();
    for (Food food : foods) {
      if (!(food.getY() > Aquarium.HEIGHT + 50)) {
        food.move();
      } else {
        toRemove.add(food);
      }
    }
  }

  /**
   * Removes the obsolete foods.
   */
  private void removeObsoleteFoods() {
    for (Food food : foods) {
      if (food.isOnRemoval()) {
        toRemove.add(food);
      }
    }
    if (!toRemove.isEmpty()) {
      for (Food food : toRemove) {
        foods.remove(food);
      }
    }
    toRemove.clear();
  }

  /**
   * Adds the new entity.
   */
  public void addNewEntity() {
    Random random = new Random();
    int bound = Aquarium.WIDTH / 10;
    int randX = bound + random.nextInt(Aquarium.WIDTH - (2 * bound));
    int y = -5;
    Food newFood = new Food(randX, y);
    foods.add(newFood);
  }
}
