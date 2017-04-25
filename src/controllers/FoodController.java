package controllers;

import java.util.ArrayList;
import java.util.List;

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
    addNewEntity(50,-10);
  }

  @Override
  public void addNewEntity(int x, int y) {
    Food newFood = new Food(x,y);
    foods.add(newFood);
    
  }

	@Override
	public void deleteSpecificEntity(int x, int y) {
		Food food = new Food(x,y);
		foods.remove(food);
	}
}
