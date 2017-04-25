package controllers;

import java.util.List;

import javax.swing.SwingWorker;

public class GameLoopController extends SwingWorker<Void, Boolean> {
  private static final long FRAMEDELAY = 25;
  private List<SubController> subControllers;
  private static boolean isAppRunning;
  private static boolean isAppPaused;
  
  public GameLoopController(List<SubController> subControllers) {
    isAppRunning = true;
    isAppPaused = false;
    this.subControllers = subControllers;
  }
  
  public static boolean isAppPaused() {
    return isAppPaused;
  }
  
  public static void togglePause() {
    isAppPaused = !isAppPaused;
  }

  @Override
  protected Void doInBackground() throws Exception {
    while (isAppRunning) {
      if (!isAppPaused) {
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
        GuiController.staticRepaint();
      }
    }
  }
}