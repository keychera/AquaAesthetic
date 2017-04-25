package views;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Aquarium;
import models.Fish;
import models.Food;

public class StatusPanelView extends JPanel {
  private List<Fish> fishes;
  private JLabel moneyStatus;
  private JLabel fishNumberStatus;

  public StatusPanelView(List<Fish> fishes) {
    this.fishes = fishes;
    add(new JLabel("money : "));
    moneyStatus = new JLabel(Integer.toString(Aquarium.money));
    add(moneyStatus);
    add(new JLabel("fish alive : "));
    fishNumberStatus = new JLabel(Integer.toString(fishes.size()));
    add(fishNumberStatus);
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    moneyStatus.setText(Integer.toString(Aquarium.money));
    fishNumberStatus.setText(Integer.toString(fishes.size()));
    super.paintComponent(g);
  }
}
