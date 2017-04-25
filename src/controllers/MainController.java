package controllers;


import java.util.ArrayList;
import java.util.List;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MainController {
  // controller to control
  private FishController fishController;
  private FoodController foodController;
  private static GameLoopController gameLoopController;

  public MainController() {
    initializeControllers();
    initializeGui();
    runGameLoop();
  }

  private void initializeControllers() {
    fishController = new FishController();
    fishController.addNewEntity();

    foodController = new FoodController();
  }

  private void initializeGui() {
  //Initialize();
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new GuiController(fishController, foodController);
      }
    });
  }

  private void runGameLoop() {
    List<SubController> subControllers = new ArrayList<SubController>();
    subControllers.add(fishController);
    subControllers.add(foodController);
    gameLoopController = new GameLoopController(subControllers);
    gameLoopController.execute();
  }
}
