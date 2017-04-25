package controllers;

//TODO remove this ugliness
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import views.AquariumView;

public class GuiController extends JFrame implements ActionListener {
  // app dimension
  private int appWidth = 400;
  private int appHeight = 500;
  // app swing component
  private static JPanel aquariumPanel;
  private static JPanel controlPanel;
  private JButton addFishButton;
  private JButton pauseButton;
  private JButton addFoodButton;
  private FishController fishController;
  private FoodController foodController;

  public GuiController(FishController fishController, FoodController foodController) {
    setSize(appWidth, appHeight);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    this.fishController = fishController;
    this.foodController = foodController;
    aquariumPanel = new AquariumView(fishController.getFishes(), foodController.getFoods());

    controlPanel = new JPanel();
    addFishButton = new JButton("add fish");
    addButtonToControlPanel(addFishButton, "Add Fish");
    addFoodButton = new JButton("add food");
    addButtonToControlPanel(addFoodButton, "Add Food");
    pauseButton = new JButton("pause");
    addButtonToControlPanel(pauseButton, "Pause");

    setLayout(new BorderLayout());
    add(aquariumPanel, BorderLayout.CENTER);
    add(controlPanel, BorderLayout.PAGE_END);

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
    controlPanel.repaint();
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
    } else if (e.getActionCommand() == "add fish") {
      if (!GameLoopController.isAppPaused()) {
        fishController.addNewEntity();
      }
    } else if (e.getActionCommand() == "add food") {
      if (!GameLoopController.isAppPaused()) {
        foodController.addNewEntity();
      }
    }
  }
}
