package controllers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Fish;

public class FishController {
  private static final int DISTANCEPERFRAME = 4;
  private List<Fish> fishes;
  
  public FishController() {
    fishes = new ArrayList<>();
  }

  public List<Fish> getFishes() {
    return fishes;
  }

  public void perform() {
    for (Fish fish : fishes) {
      fish.move(DISTANCEPERFRAME, "west");
    }
  }

  public void addFish() {
    addFish(10, 10);
  }

  public void addFish(int x, int y) {
    Fish f = new Fish(x, y, Color.BLACK);
    fishes.add(f);
  }
}
