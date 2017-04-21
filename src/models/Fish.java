package models;

import java.awt.Color;
import java.util.Random;

import views.AquariumView;

public class Fish extends movingObject {
  public static final int FISHDIMENSION = 10;
  private static final float MAXDISTANCE = 1;
  private Color colors;

  private int delayUntilNewDecision;
  private float dis;
  private float dir;

  public Fish(int x, int y, Color colors) {
    this.x = x;
    this.y = y;
    this.colors = colors;
    this.delayUntilNewDecision = -1;
    this.dis = 1;
    this.dir = (float) (Math.PI * (new Random().nextFloat() * 2));
  };

  public int getX() {
    return this.x;
  };

  public int getY() {
    return this.y;
  };

  public Color getColors() {
    return this.colors;
  };

  public void setX(int x1) {
    this.x = x1;
  };

  public void setY(int y1) {
    this.y = y1;
  };

  public void setColors(Color colors1) {
    this.colors = colors1;
  };

  public void delayDecision() {
    delayUntilNewDecision -= 1;
  };

  public boolean timeToDecide() {
    return (delayUntilNewDecision < 0);
  }

  public void move() {
    Random rand = new Random();
    if (timeToDecide()) {
      if (rand.nextInt(2) == 0) {
        dir = dir + (float) (Math.PI * rand.nextFloat());
      } else {
        dir = dir + (float) (Math.PI * rand.nextFloat());
      }
      delayUntilNewDecision = rand.nextInt(10) + 15;
    }

    delayDecision();
    move(dis, dir);
    fixPosition();
  };

  public void fixPosition() {
    if (x > AquariumView.VIEWWIDTH + FISHDIMENSION) {
      x = x % AquariumView.VIEWWIDTH - FISHDIMENSION;
    } else if (x < -FISHDIMENSION) {
      x += AquariumView.VIEWWIDTH + FISHDIMENSION;
    }
    if (y > AquariumView.VIEWWIDTH + FISHDIMENSION) {
      y = y % AquariumView.VIEWHEIGHT - FISHDIMENSION;
    } else if (y < -FISHDIMENSION) {
      y += AquariumView.VIEWHEIGHT + FISHDIMENSION;
    }
  }
}
