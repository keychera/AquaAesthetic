package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Fish;

public class FishController implements SubController {
  private List<Fish> fishes;
  
  public FishController() {
    fishes = new ArrayList<>();
  }

  public List<Fish> getFishes() {
    return fishes;
  }

  public void perform() {
    for (Fish fish : fishes) {
      fish.move();
    }
  }
  
  @Override
  public void addNewEntity() {
    Fish newFish = new Fish(30, 30);
    fishes.add(newFish);
  }

  @Override
  public void addNewEntity(int aquariumWidth, int aquariumHeight) {
    Random random = new Random();
    int bound = aquariumWidth / 10;
    int randX = bound + random.nextInt(aquariumWidth - (2 * bound));
    int randY = bound + random.nextInt(aquariumHeight - (2 * bound));
    Fish newFish = new Fish(randX, randY);
    fishes.add(newFish);
  }

  public void deleteSpecificEntity(int aquariumWidth, int aquariumHeight) {
	  Random random = new Random();  
	  int bound = aquariumWidth / 10;
	  int randX = bound + random.nextInt(aquariumWidth - (2 * bound));
	  int randY = bound + random.nextInt(aquariumHeight - (2 * bound));
	  Fish f = new Fish(randX, randY);
	  fishes.remove(f);
  }

  @Override
  public void deleteSpecificEntity() {
	Fish newFish = new Fish();
	fishes.remove(newFish);
  }
}
