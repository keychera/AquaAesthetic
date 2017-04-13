package main;

import java.util.List;
import java.util.ArrayList;

import Models.Fish;

public class Main {
  static List<Fish> fishes;

  public static void main(String[] args) {
    Initialize();
    while (Run()) {
    }
  }

  public static void Initialize() {
    if (fishes != null) {
      fishes = new ArrayList<Fish>();
    }
    fishes.add(new Fish());
  }

  private static boolean Run() {
    
    return true;
  }
}
