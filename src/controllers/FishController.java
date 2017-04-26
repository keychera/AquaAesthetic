package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Aquarium;
import models.Fish;

public class FishController implements ISubController {
  private List<Fish> fishes;
  private List<Fish> toRemove;

  public FishController() {
    fishes = new ArrayList<Fish>();
    toRemove = new ArrayList<Fish>();
  }

  public List<Fish> getFishes() {
    return fishes;
  }

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


  private void removeObsoleteFishes() {
    if (!toRemove.isEmpty()) {
      for (Fish fish : toRemove) {
        fishes.remove(fish);
      }
    }
    toRemove.clear();
  }

  public void addNewEntity() {
    Random random = new Random();
    int bound = Aquarium.WIDTH / 10;
    int randX = bound + random.nextInt(Aquarium.WIDTH - (2 * bound));
    int randY = bound + random.nextInt(Aquarium.HEIGHT - (2 * bound));
    Fish newFish = new Fish(randX, randY);
    fishes.add(newFish);
  }

  public int getNumberOfFish() {
    return fishes.size();
  }
}
