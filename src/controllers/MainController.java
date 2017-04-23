package controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.JButton;
import javax.swing.Timer;

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
  // controller to control
  private FishController fishController;
  // app control
  protected boolean isAppRunning;
  protected boolean isAppPausing;

  private class MainWorker extends SwingWorker<Void, Boolean> {
    @Override
    protected Void doInBackground() throws Exception {
      while (isAppRunning) {
        if (!isAppPausing) {
          Thread.sleep(FRAMEDELAY);
          fishController.perform();
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
    initializeControlPanel();

    setVisible(true);

    initializeGameLoop();
  }

  private void initializeMainFrame() {
    setSize(appWidth, appHeight);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private void initializeAquariumPanel() {
    fishController = new FishController();
    fishController.addFish();
    fishController.addFish();
    fishController.addFish();
    aquariumPanel = new AquariumView(fishController.getFishes());
  }

  private void initializeControlPanel() {
    controlPanel = new JPanel();
    addButtonToControlPanel(addFishButton,"add fish");
    addButtonToControlPanel(pauseButton,"pause");

    setLayout(new BorderLayout());
    add(aquariumPanel, BorderLayout.CENTER);
    add(controlPanel, BorderLayout.PAGE_END);
  }

  private void addButtonToControlPanel(JButton button, String message) {
    addButtonToControlPanel(button, message, message);
  }

  private void addButtonToControlPanel(JButton button, String message, String label) {
    button = new JButton(label);
    button.setActionCommand(message);
    button.addActionListener(this);
    controlPanel.add(button);
  }


  private void initializeGameLoop() {
    isAppRunning = true;
    isAppPausing = false;
    runGameLoop();
  }

  private void runGameLoop() {
    MainWorker mainWorker = new MainWorker();
    mainWorker.execute();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == "add fish") {
      Random random = new Random();
      int bound = appWidth / 10;
      int randX = bound + random.nextInt(aquariumPanel.getWidth() - (2 * bound));
      int randY = bound + random.nextInt(aquariumPanel.getHeight() - (2 * bound));
      fishController.addFish(randX, randY);
    } else if (e.getActionCommand() == "pause") {
      isAppPausing = !isAppPausing;
      if (isAppPausing) {
        pauseButton.setText("unpause");
      } else {
        pauseButton.setText("pause");
      }
    }
  }
}
