package models;

public abstract class movingObject {
  int x;
  int y;

  public void move(float distance, float direction) {
    x += Math.round(distance * Math.cos(direction));
    y += Math.round(distance * Math.sin(direction));
  }
}
