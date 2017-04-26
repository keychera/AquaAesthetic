package views;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Aquarium;
import models.Fish;

// TODO: Auto-generated Javadoc
/**
 * The Class StatusPanelView.
 */
public class StatusPanelView extends JPanel {

  /** The fishes. */
  private List<Fish> fishes;

  /** The money status. */
  private JLabel moneyStatus;

  /** The fish number status. */
  private JLabel fishNumberStatus;

  /**
   * Instantiates a new status panel view.
   *
   * @param fishes the fishes
   */
  public StatusPanelView(List<Fish> fishes) {
    this.fishes = fishes;
    add(new JLabel("money : "));
    moneyStatus = new JLabel(Integer.toString(Aquarium.money));
    add(moneyStatus);
    add(new JLabel("fish alive : "));
    fishNumberStatus = new JLabel(Integer.toString(fishes.size()));
    add(fishNumberStatus);
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
   */
  @Override
  protected void paintComponent(Graphics g) {
    moneyStatus.setText(Integer.toString(Aquarium.money));
    fishNumberStatus.setText(Integer.toString(fishes.size()));
    super.paintComponent(g);
  }
}
