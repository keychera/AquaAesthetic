package controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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

  private static final int FRAMEDELAY = 50;
  private Timer timer = null;
  private int aquariumWidth = 400;
  private int aquariumHeight = 500;
  protected List<SubController> subControllers;
  private JButton addFoodButton;

  public MainController() {
    // Main frame dimension
    setSize(aquariumWidth, aquariumHeight);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    subControllers = new ArrayList<SubController>();

    FishController fishController = new FishController();
    fishController.addNewEntity();
    subControllers.add(fishController);
    FoodController foodController = new FoodController();
    subControllers.add(foodController);
    aquariumPanel = new AquariumView(fishController.getFishes(),foodController.getFoods());

    timer = new Timer(FRAMEDELAY, new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        for (SubController sc : subControllers) {
          sc.perform();
        }
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
        fishController.addNewEntity(randX, randY);
      }
      
    });
    
    addFoodButton = new JButton("add food");
    addFoodButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        Random random = new Random();
        int bound = aquariumWidth / 10;
        int randX = bound + random.nextInt(aquariumWidth - (2 * bound));
        int y = -5;
        foodController.addNewEntity(randX, y);
        
      }
      
    });

    controlPanel = new JPanel();
    controlPanel.add(addFishButton);
    controlPanel.add(addFoodButton);

    setLayout(new BorderLayout());
    add(aquariumPanel, BorderLayout.CENTER);
    add(controlPanel, BorderLayout.PAGE_END);

    setVisible(true);
    timer.start();
  }
}
