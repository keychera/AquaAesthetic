package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import models.Fish;
import models.Food;

public class AquariumView extends JPanel {
  public static final int VIEWWIDTH = 400;
  public static final int VIEWHEIGHT = 400;
  private List<Fish> fishes;
  private List<Food> foods;

  public AquariumView(List<Fish> fishes, List<Food> foods) {
    this.fishes = fishes;
    this.foods = foods;
    setBackground(Color.DARK_GRAY);
    setPreferredSize(new Dimension(VIEWWIDTH, VIEWHEIGHT));
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
      g.fillOval(fish.getX(), fish.getY(), 20, 20);
    }
  }
}
