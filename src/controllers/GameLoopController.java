package controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

public class GameLoopController extends SwingWorker<String, Boolean> {
  private static final long FRAMEDELAY = 25;
  private List<ISubController> subControllers;
  private static boolean isAppRunning;
  private static boolean isAppPaused;
  
  public GameLoopController(List<ISubController> subControllers) {
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
  protected String doInBackground() throws InterruptedException  {
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

  @Override
  protected void process(List<Boolean> calculatedChanges) {
    for (Boolean isAquariumRunning : calculatedChanges) {
      if (isAquariumRunning) {
        GuiController.staticRepaint();
      }
    }
  }

  @Override
  protected void done() {
    try {
      System.out.println(get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}