package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
  
  @Override
  public void addNewEntity() {
    Food newFood = new Food(50,-5);
    foods.add(newFood);
  }

  @Override
  public void addNewEntity(int aquariumWidth, int aquariumHeight) {
    Random random = new Random();
    int bound = aquariumWidth / 10;
    int randX = bound + random.nextInt(aquariumWidth - (2 * bound));
    int y = -5;
    Food newFood = new Food(randX,y);
    foods.add(newFood);
  }
}
