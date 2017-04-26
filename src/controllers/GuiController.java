package controllers;

// TODO remove this ugliness
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
  private SellDialog sellDialog;
  private JPanel sellPanel;
  private GameRuleController gameRuleController;
  
  private class SellDialog extends JDialog implements ActionListener{
    public SellDialog(JFrame frame, String string, boolean b) {
      super(frame,string,b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      dispose();      
    }
    
  }

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
    
    sellDialog = new SellDialog(this, "Sell", true);
    sellDialog.setResizable(false);
    sellDialog.getContentPane().add(createRootPane());
    sellDialog.setVisible(false);
    sellDialog.setLocation(this.getWidth()/3, this.getHeight()/5);
    

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
      sellPanel = new JPanel();
      sellPanel.setLayout(new BorderLayout());
      sellPanel.add(new JLabel("hey"), BorderLayout.CENTER);
      JButton finishButton = new JButton("hey");
      finishButton.addActionListener(sellDialog);
      sellPanel.add(finishButton, BorderLayout.PAGE_END);
      sellDialog.getContentPane().add(sellPanel);
      sellDialog.setSize(this.getWidth()/3, this.getHeight()/6);
      sellDialog.setVisible(true);
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
