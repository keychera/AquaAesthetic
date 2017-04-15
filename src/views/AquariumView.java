package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import models.Fish;

public class AquariumView extends JPanel {
  private static final int VIEWWIDTH = 400;
  private static final int VIEWHEIGHT = 400;
  private List<Fish> fishes;

  public AquariumView(List<Fish> fishes) {
    this.fishes = fishes;
    setBackground(Color.CYAN);
    setPreferredSize(new Dimension(VIEWWIDTH, VIEWHEIGHT));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Fish fish : fishes) {
      g.setColor(fish.getColors());
      g.fillOval(fish.getX(), fish.getY(), 20, 20);
    }
  }
}
