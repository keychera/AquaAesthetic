package controllers;

import java.util.ArrayList;
import java.util.List;
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

  public void addNewEntity() {
    addNewEntity(30, 30);
  }

  public void addNewEntity(int x, int y) {
    Fish f = new Fish(x, y);
    fishes.add(f);
  }
}
