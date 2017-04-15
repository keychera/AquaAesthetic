package controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Timer;

import views.AquariumView;

public class MainController extends JFrame {
  JPanel aquariumPanel;
  JPanel controlPanel;
  JButton addFishButton;

  FishController fishController;

  private static final int FRAMEDELAY = 50;
  private Timer timer = null;
  private int aquariumWidth = 400;
  private int aquariumHeight = 500;

  public MainController() {
    // Main frame dimension
    setSize(aquariumWidth, aquariumHeight);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    fishController = new FishController();
    fishController.addFish();
    aquariumPanel = new AquariumView(fishController.getFishes());

    timer = new Timer(FRAMEDELAY, new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        fishController.perform();
        aquariumPanel.repaint();
      }

    });

    addFishButton = new JButton("add fish");
    addFishButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        Random random = new Random();
        int bound = aquariumWidth / 10;
        int randX = bound + random.nextInt(aquariumWidth - (2 * bound));
        int randY = bound + random.nextInt(aquariumHeight - (2 * bound));
        fishController.addFish(randX, randY);
      }
    });

    controlPanel = new JPanel();
    controlPanel.add(addFishButton);

    setLayout(new BorderLayout());
    add(aquariumPanel, BorderLayout.CENTER);
    add(controlPanel, BorderLayout.PAGE_END);

    setVisible(true);
    timer.start();
  }
}
