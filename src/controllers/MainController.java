package controllers;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


// TODO: Auto-generated Javadoc
/**
 * The Class MainController.
 */
public class MainController {
  
  /** The fish controller. */
  // controller to control
  private static FishController fishController;
  
  /** The food controller. */
  private static FoodController foodController;
  
  /** The interaction controller. */
  private static InteractionController interactionController;
  
  /** The game loop controller. */
  private static GameLoopController gameLoopController;
  
  /** The game rule controller. */
  private static GameRuleController gameRuleController;

  /**
   * Instantiates a new main controller.
   */
  public MainController() {
    initializeControllers();
    initializeGui();
    runGameLoop();
  }

  /**
   * Initialize controllers.
   */
  private void initializeControllers() {
    fishController = new FishController();
    fishController.addNewEntity();
    foodController = new FoodController();
    interactionController = new InteractionController(fishController, foodController);
    gameRuleController = new GameRuleController(fishController, foodController);
  }

  /**
   * Initialize gui.
   */
  private void initializeGui() {
    // Initialize();
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new GuiController(gameRuleController);
      }
    });
  }

  /**
   * Run game loop.
   */
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
