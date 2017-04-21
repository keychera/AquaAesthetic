package models;

import java.awt.Color;
import java.util.Random;

import views.AquariumView;

public class Fish {
  private static final int POSOFFSET = 10;
  private int x, y;
  private Color colors;
  private int delay;
  private int dis;
  private int dir;

  public Fish(int x, int y, Color colors) {
    this.x = x;
    this.y = y;
    this.colors = colors;
    this.delay = -1;
    this.dis = 1;
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

  public void move(int distance, String direction) {
    switch (direction) {
      case "north":
        this.y -= distance;
        break;
      case "north east":
        this.y -= distance;
        this.x += distance;
        break;
      case "east":
        this.x += distance;
        break;
      case "south east":
        this.x += distance;
        this.y += distance;
        break;
      case "south":
        this.y += distance;
        break;
      case "south west":
        this.x -= distance;
        this.y += distance;
        break;
      case "west":
        this.x -= distance;
        break;
      case "north west":
        this.x -= distance;
        this.y -= distance;
        break;
    }
  };

  public void move(int distance, int direction) {
    switch (direction) {
      case 1:
        this.y -= distance;
        break;
      case 2:
        this.y -= distance;
        this.x += distance;
        break;
      case 3:
        this.x += distance;
        break;
      case 4:
        this.x += distance;
        this.y += distance;
        break;
      case 5:
        this.y += distance;
        break;
      case 6:
        this.x -= distance;
        this.y += distance;
        break;
      case 7:
        this.x -= distance;
        break;
      case 8:
        this.x -= distance;
        this.y -= distance;
        break;
    }
  };

  public void delayedMove() {
    delay -= 1;
  };

  public void move() {
    Random rand = new Random();
    if (delay < 0) {
      dis = rand.nextInt(9) % 2;
      dir = rand.nextInt(8) + 1;
      delay = rand.nextInt(20) + 10;
    }

    delayedMove();
    move(dis, dir);
    if (x > AquariumView.VIEWWIDTH + POSOFFSET) {
      x = x % AquariumView.VIEWWIDTH - POSOFFSET;
    } else if (x < -POSOFFSET) {
      x += AquariumView.VIEWWIDTH + POSOFFSET;
    }
    if (y > AquariumView.VIEWWIDTH + POSOFFSET) {
      y = y % AquariumView.VIEWHEIGHT - POSOFFSET;
    } else if (y < -POSOFFSET) {
      y += AquariumView.VIEWHEIGHT + POSOFFSET;
    }
  };


}
