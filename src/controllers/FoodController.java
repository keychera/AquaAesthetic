package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Aquarium;
import models.Food;

public class FoodController implements SubController {
  private List<Food> foods;
  
  public FoodController() {
    foods = new ArrayList<>();
  }

  public List<Food> getFoods() {
    return foods;
  }

  @Override
  public void perform() {
    for(Food food : foods) {
      food.move();
      //TODO remove the food if it reach the bottom
    }
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
