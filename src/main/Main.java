package main;

import java.util.List;
import java.util.ArrayList;

import models.Fish;
import views.MainView;

public class Main {
  static List<Fish> fishes;

  public static void main(String[] args) {
    //Initialize();
    new MainView();
  }

  public static void Initialize() {
    if (fishes != null) {
      fishes = new ArrayList<Fish>();
    }
    fishes.add(new Fish(0, 0, null));
  }

  private static boolean Run() {
    
    return true;
  }
}
