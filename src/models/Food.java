package models;

public class Food extends MovingObject {
  public Food(int x, int y) {
    super(x,y);
  }

  @Override
  public void move() {
    moveDirection(STANDARDDISTANCEPERSTEP / 5, (float) (0.5 * Math.PI));
  }
}