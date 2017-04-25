package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Fish;

public class FishController implements SubController {
  private List<Fish> fishes;
  private List<Fish> toRemove;
  
  public FishController() {
    fishes = new ArrayList<Fish>();
    toRemove = new ArrayList<Fish>();
  }

  public List<Fish> getFishes() {
    return fishes;
  }

  public void perform() {
    for (Fish fish : fishes) {
      if (!fish.isDeadByStarvation()) {
        fish.move();
      } else {
        toRemove.add(fish);
      }
    }
    removeFishes();
  }

  private void removeFishes() {
    if (!toRemove.isEmpty()) {
      for(Fish fish : toRemove) {
        fishes.remove(fish);
      }
    }
    toRemove.clear();
  }

  public void addNewEntity() {
    Fish newFish = new Fish(30, 30);
    fishes.add(newFish);
  }

  public void addNewEntity(int aquariumWidth, int aquariumHeight) {
    Random random = new Random();
    int bound = aquariumWidth / 10;
    int randX = bound + random.nextInt(aquariumWidth - (2 * bound));
    int randY = bound + random.nextInt(aquariumHeight - (2 * bound));
    Fish newFish = new Fish(randX, randY);
    fishes.add(newFish);
  }

  public int getNumberOfFish() {
    return fishes.size();
  }
}
