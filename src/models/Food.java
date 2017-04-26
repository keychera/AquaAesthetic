package models;

public class Food extends MovingObject {
  private boolean removeFlag;

  public Food(int x, int y) {
    super(x, y);
    removeFlag = false;
  }

  public boolean isOnRemoval() {
    return removeFlag;
  }

  @Override
  public void move() {
    moveDirection(STANDARDDISTANCEPERSTEP / 5, (float) (0.5 * Math.PI));
  }

  public void hasBeenEaten() {
    removeFlag = true;
  }
}
