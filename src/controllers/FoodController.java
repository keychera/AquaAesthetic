package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Aquarium;
import models.Fish;
import models.Food;

public class FoodController implements ISubController {
  private List<Food> foods;
  private List<Food> toRemove;
  
  public FoodController() {
    foods = new ArrayList<>();
    toRemove = new ArrayList<>();
  }

  public List<Food> getFoods() {
    return foods;
  }

  @Override
  public void perform() {
    removeObsoleteFoods();
    for(Food food : foods) {
      if (!(food.getY() > Aquarium.HEIGHT + 50)) {
        food.move();
      } else {
        toRemove.add(food);
      }
    }
  }

  private void removeObsoleteFoods() {
    for(Food food : foods) {
      if (food.isOnRemoval()) {
        toRemove.add(food);
      }
    }
    if (!toRemove.isEmpty()) {
      for(Food food : toRemove) {
        foods.remove(food);
      }
    }
    toRemove.clear();
  }

  public void addNewEntity() {
    Random random = new Random();
    int bound = Aquarium.WIDTH / 10;
    int randX = bound + random.nextInt(Aquarium.WIDTH - (2 * bound));
    int y = -5;
    Food newFood = new Food(randX,y);
    foods.add(newFood);
  }
}
