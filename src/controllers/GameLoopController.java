package controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

// TODO: Auto-generated Javadoc
/**
 * The Class GameLoopController.
 */
public class GameLoopController extends SwingWorker<String, Boolean> {

  /** The Constant FRAMEDELAY. */
  private static final long FRAMEDELAY = 25;

  /** The sub controllers. */
  private List<ISubController> subControllers;

  /** The is app running. */
  private static boolean isAppRunning;

  /** The is app paused. */
  private static boolean isAppPaused;

  /**
   * Instantiates a new game loop controller.
   *
   * @param subControllers the sub controllers
   */

  public GameLoopController(List<ISubController> subControllers) {
    isAppRunning = true;
    isAppPaused = false;
    this.subControllers = subControllers;
  }

  /**
   * Checks if is app paused.
   *
   * @return true, if is app paused
   */

  public static boolean isAppPaused() {
    return isAppPaused;
  }

  /**
   * Toggle pause.
   */
  public static void togglePause() {
    isAppPaused = !isAppPaused;
  }

  /*
   * method for running in background
   * 
   * @return String for indicating background running
   */
  @Override
  protected String doInBackground() throws InterruptedException {
    while (isAppRunning) {
      if (!isAppPaused) {
        Thread.sleep(FRAMEDELAY);
        for (ISubController subController : subControllers) {
          subController.perform();
        }
        publish(true);
      } else {
        publish(false);
      }
    }
    return "yes";
  }

  /*
   * process when running the aquarium
   * 
   * @param calculatedChanges list of changes in Aquarium
   */
  @Override
  protected void process(List<Boolean> calculatedChanges) {
    for (Boolean isAquariumRunning : calculatedChanges) {
      if (isAquariumRunning) {
        GuiController.staticRepaint();
      }
    }
  }

  /*
   * error handling for process
   * 
   */
  @Override
  protected void done() {
    try {
      System.out.println(get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
