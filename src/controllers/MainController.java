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
  private static GameRuleController gameRuleController;

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
    gameRuleController = new GameRuleController(fishController,foodController);
  }

  private void initializeGui() {
  //Initialize();
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new GuiController(gameRuleController);
      }
    });
  }

  private void runGameLoop() {
    List<ISubController> subControllers = new ArrayList<ISubController>();
    subControllers.add(fishController);
    subControllers.add(foodController);
    subControllers.add(interactionController);
    subControllers.add(gameRuleController);
    gameLoopController = new GameLoopController(subControllers);
    gameLoopController.execute();
  }
}
