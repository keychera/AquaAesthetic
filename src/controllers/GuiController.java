package controllers;

// TODO remove this ugliness
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import models.Aquarium;
import views.AquariumView;
import views.StatusPanelView;

public class GuiController extends JFrame implements ActionListener {
  // app dimension
  private int appWidth;
  private int appHeight;
  // app swing component
  private static JPanel aquariumPanel;
  private static JPanel controlPanel;
  private static JPanel statusPanel;
  private JButton addFishButton;
  private JButton addFoodButton;
  private JButton sellFishButton;
  private JButton pauseButton;
  private GameRuleController gameRuleController;

  public GuiController(GameRuleController gameRuleController) {
    appWidth = Aquarium.WIDTH;
    appHeight = Aquarium.HEIGHT + 100;
    setSize(appWidth, appHeight);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    this.gameRuleController = gameRuleController;
    aquariumPanel = new AquariumView(gameRuleController.getFishes(), gameRuleController.getFoods());

    controlPanel = new JPanel();
    addFishButton = new JButton("add fish");
    addButtonToControlPanel(addFishButton, "Add Fish");
    addFoodButton = new JButton("add food");
    addButtonToControlPanel(addFoodButton, "Add Food");
    sellFishButton = new JButton("sell fish");
    addButtonToControlPanel(sellFishButton, "Sell Fish");
    pauseButton = new JButton("pause");
    addButtonToControlPanel(pauseButton, "Pause");

    statusPanel = new StatusPanelView(gameRuleController.getFishes());

    setLayout(new BorderLayout());
    add(aquariumPanel, BorderLayout.CENTER);
    add(controlPanel, BorderLayout.PAGE_END);
    add(statusPanel, BorderLayout.PAGE_START);

    setVisible(true);
  }

  private void addButtonToControlPanel(JButton button, String label) {
    button.setActionCommand(button.getText());
    button.setText(label);
    button.addActionListener(this);
    controlPanel.add(button);
  }

  public static void staticRepaint() {
    aquariumPanel.repaint();
    statusPanel.repaint();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == "pause") {
      GameLoopController.togglePause();
      if (GameLoopController.isAppPaused()) {
        pauseButton.setText("unpause");
      } else {
        pauseButton.setText("pause");
      }
    } else if (e.getActionCommand() == "sell fish") {
      GameLoopController.togglePause();
      JOptionPane.showMessageDialog(this, "Selling fish is not implemented");
      GameLoopController.togglePause();
    } else if (e.getActionCommand() == "add fish") {
      if (!GameLoopController.isAppPaused()) {
        gameRuleController.handleAddFishCommand();
      }
    } else if (e.getActionCommand() == "add food") {
      if (!GameLoopController.isAppPaused()) {
        gameRuleController.handleAddFoodCommand();
      }
    }
  }
}
