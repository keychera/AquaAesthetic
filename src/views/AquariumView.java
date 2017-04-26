package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import models.Aquarium;
import models.Fish;
import models.Food;

public class AquariumView extends JPanel {
  private List<Fish> fishes;
  private List<Food> foods;

  public AquariumView(List<Fish> fishes, List<Food> foods) {
    this.fishes = fishes;
    this.foods = foods;
    setBackground(Color.MAGENTA);
    setPreferredSize(new Dimension(Aquarium.WIDTH, Aquarium.HEIGHT));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Food food : foods) {
      g.setColor(Color.WHITE);
      g.fillRect(food.getX(), food.getY(), 5, 5);
    }
    for (Fish fish : fishes) {
      g.setColor(Color.WHITE);
      g.fillOval(fish.getX(), fish.getY(), 20 + fish.getGrowth(), 20 + fish.getGrowth());
    }
  }
}
