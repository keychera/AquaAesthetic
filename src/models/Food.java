package models;

// TODO: Auto-generated Javadoc
/**
 * The Class Food.
 */
public class Food extends MovingObject {
  
  /** The remove flag. */
  private boolean removeFlag;

  /**
   * Instantiates a new food.
   *
   * @param x the x
   * @param y the y
   */
  public Food(int x, int y) {
    super(x,y);
    removeFlag = false;
  }
  
  /**
   * Checks if is on removal.
   *
   * @return true, if is on removal
   */
  public boolean isOnRemoval(){
    return removeFlag;
  }

  /* (non-Javadoc)
   * @see models.MovingObject#move()
   */
  /* method for moving food down the aquarium
   *
   */
  @Override
  public void move() {
    moveDirection(STANDARDDISTANCEPERSTEP / 5, (float) (0.5 * Math.PI));
  }

  /**
   * Checks for been eaten.
   */
  public void hasBeenEaten() {
    removeFlag = true;
  }
}