package controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.JButton;
import views.AquariumView;

public class MainController extends JFrame implements ActionListener {
  // app fields
  private static final int FRAMEDELAY = 50;
  private int appWidth = 400;
  private int appHeight = 500;
  // app swing component
  private JPanel aquariumPanel;
  private JPanel controlPanel;
  private JButton addFishButton;
  private JButton pauseButton;
  private JButton addFoodButton;
  // controller to control
  private List<SubController> subControllers;
  private FishController fishController;
  private FoodController foodController;
  // app control
  private boolean isAppRunning;
  private boolean isAppPausing;

  private class MainWorker extends SwingWorker<Void, Boolean> {
    @Override
    protected Void doInBackground() throws Exception {
      while (isAppRunning) {
        if (!isAppPausing) {
          Thread.sleep(FRAMEDELAY);
          for (SubController subController : subControllers) {
            subController.perform();
          }
          publish(true);
        } else {
          publish(false);
        }
      }
      return null;
    }

    @Override
    protected void process(List<Boolean> calculatedChanges) {
      for (Boolean isAquariumRunning : calculatedChanges) {
        if (isAquariumRunning) {
          aquariumPanel.repaint();
        }
      }
    }
  }

  public MainController() {
    initializeMainFrame();
    initializeAquariumPanel();

    setVisible(true);

    runGameLoop();
  }

  private void initializeMainFrame() {
    setSize(appWidth, appHeight);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private void initializeAquariumPanel() {
    subControllers = new ArrayList<SubController>();

    fishController = new FishController();
    fishController.addNewEntity();
    subControllers.add(fishController);

    foodController = new FoodController();
    subControllers.add(foodController);

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
  }

  private void addButtonToControlPanel(JButton button, String label) {
    button.setActionCommand(button.getText());
    button.setText(label);
    button.addActionListener(this);
    controlPanel.add(button);
  }

  private void runGameLoop() {
    isAppRunning = true;
    isAppPausing = false;
    MainWorker mainWorker = new MainWorker();
    mainWorker.execute();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == "pause") {
      isAppPausing = !isAppPausing;
      if (isAppPausing) {
        pauseButton.setText("unpause");
      } else {
        pauseButton.setText("pause");
      }
    } else if (e.getActionCommand() == "add fish") {
      Random random = new Random();
      int bound = aquariumPanel.getWidth() / 10;
      int randX = bound + random.nextInt(aquariumPanel.getWidth() - (2 * bound));
      int randY = bound + random.nextInt(aquariumPanel.getHeight() - (2 * bound));
      fishController.addNewEntity(randX, randY);
    } else if (e.getActionCommand() == "add food") {
      Random random = new Random();
      int bound = aquariumPanel.getWidth() / 10;
      int randX = bound + random.nextInt(aquariumPanel.getWidth() - (2 * bound));
      int y = -5;
      foodController.addNewEntity(randX, y);
    }
  }
}
