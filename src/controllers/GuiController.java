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

// TODO: Auto-generated Javadoc
/**
 * The Class GuiController.
 */
public class GuiController extends JFrame implements ActionListener {
  
  /** The app width. */
  private int appWidth;
  
  /** The app height. */
  private int appHeight;
  
  /** The aquarium panel. */
  private static JPanel aquariumPanel;
  
  /** The control panel. */
  private static JPanel controlPanel;
  
  /** The status panel. */
  private static JPanel statusPanel;
  
  /** The add fish button. */
  private JButton addFishButton;
  
  /** The add food button. */
  private JButton addFoodButton;
  
  /** The sell fish button. */
  private JButton sellFishButton;
  
  /** The pause button. */
  private JButton pauseButton;
  
  /** The game rule controller. */
  private GameRuleController gameRuleController;

  /**
   * Instantiates a new gui controller.
   *
   * @param gameRuleController the game rule controller
   */
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

  /**
   * Adds the button to control panel.
   *
   * @param button the button
   * @param label the label
   */
  private void addButtonToControlPanel(JButton button, String label) {
    button.setActionCommand(button.getText());
    button.setText(label);
    button.addActionListener(this);
    controlPanel.add(button);
  }

  /**
   * Static repaint.
   */
  public static void staticRepaint() {
    aquariumPanel.repaint();
    statusPanel.repaint();
  }

  /* action handler from GUI
   * @param e ActionEvent action listener param
   */
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
