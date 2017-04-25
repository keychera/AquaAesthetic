package controllers;


import java.util.ArrayList;
import java.util.List;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MainController {
  // controller to control
  private static FishController fishController;
  private static FoodController foodController;
  private static InteractionController interactionController;
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
    interactionController = new InteractionController(fishController,foodController);
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
    subControllers.add(interactionController);
    gameLoopController = new GameLoopController(subControllers);
    gameLoopController.execute();
  }
}
