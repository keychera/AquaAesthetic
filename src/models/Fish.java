package models;

import java.util.Random;

public class Fish extends MovingObject {
  private float distancePerStep = 2;
  private int nextDecisionTimer;
  private int currentTargetX;
  private int currentTargetY;
  private Food targetFood;
  private int hunger;

  public Fish() {
    this(0, 0);
  }

  public Fish(int x, int y) {
    super(x, y);
    nextDecisionTimer = -1;
    hunger = -99;
  }

  public void move() {
    if (isHungry() && targetFood != null) {
      setTarget(targetFood);
      moveDirection(distancePerStep,
          (float) Math.atan2(currentTargetY - this.y, currentTargetX - this.x));
      distancePerStep *= 1.001;
    } else {
      if (isTimeToDecideYet()) {
        Random rand = new Random();
        nextDecisionTimer = rand.nextInt(30) + 15;
        setTarget(rand.nextInt(Aquarium.WIDTH), rand.nextInt(Aquarium.HEIGHT));
        distancePerStep = rand.nextInt(10) + 1;
      } else {
        moveDirection(distancePerStep,
            (float) Math.atan2(currentTargetY - this.y, currentTargetX - this.x));
        nextDecisionTimer--;
      }
    }
    increaseHunger(distancePerStep);
  }

  private void setTarget(MovingObject mo) {
    setTarget(mo.x, mo.y);
  }

  private void setTarget(int x, int y) {
    this.currentTargetX = x;
    this.currentTargetY = y;
  }

  private boolean isHungry() {
    return hunger > 500;
  }

  public boolean isDeadByStarvation() {
    return hunger > 1000;
  }

  private void increaseHunger(float distanceTaken) {
    this.hunger += distancePerStep;
  }

  private boolean isTimeToDecideYet() {
    return (nextDecisionTimer < 0 || isNearTargetYet());
  }

  private boolean isNearTargetYet() {
    int dx = Math.abs(currentTargetX - this.x);
    int dy = Math.abs(currentTargetY - this.y);
    return (dx < 10 && dy < 10);
  }
  
  public int getHunger() {
    return hunger;
  }

  public void setTargetFood(Food targetFood) {
    this.targetFood = targetFood;
  }
}
