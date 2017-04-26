package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Aquarium;
import models.Fish;
import models.Food;

// TODO: Auto-generated Javadoc
/**
* FishController class
* managing fishes outside its behavior. 
*
*/
public class FishController implements ISubController {
  
  /** The fishes. */
  private List<Fish> fishes;
  
  /** The to remove. */
  private List<Fish> toRemove;
  
  /**
   * Instantiates a new fish controller.
   */
  public FishController() {
    fishes = new ArrayList<Fish>();
    toRemove = new ArrayList<Fish>();
  }

  /**
   * Gets the fishes.
   *
   * @return the fishes
   */
  public List<Fish> getFishes() {
    return fishes;
  }

  /* (non-Javadoc)
   * @see controllers.ISubController#perform()
   */
  /* implementing from ISubController interface method
   * 
   */
  @Override
  public void perform() {
    removeObsoleteFishes();
    for (Fish fish : fishes) {
      if (!fish.isDeadByStarvation()) {
        fish.move();
      } else {
        toRemove.add(fish);
      }
    }
  }

  /**
   * Removes the obsolete fishes.
   */
  private void removeObsoleteFishes() {
    for (Fish fish : fishes) {
      if (fish.isOnRemoval()) {
        toRemove.add(fish);
      }
    }
    if (!toRemove.isEmpty()) {
      for (Fish fish : toRemove) {
        fishes.remove(fish);
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
    int randY = bound + random.nextInt(Aquarium.HEIGHT - (2 * bound));
    Fish newFish = new Fish(randX, randY);
    fishes.add(newFish);
  }

  /**
   * Gets the number of fish.
   *
   * @return the number of fish
   */
  public int getNumberOfFish() {
    return fishes.size();
  }
}
