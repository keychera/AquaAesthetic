package models;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Fish.
 */
public class Fish extends MovingObject {

  /** The distance per step. */
  private float distancePerStep = 2;

  /** The next decision timer. */
  private int nextDecisionTimer;

  /** The current target X. */
  private int currentTargetX;

  /** The current target Y. */
  private int currentTargetY;

  /** The target food. */
  private Food targetFood;

  /** The hunger. */
  private int hunger;

  /** The growth. */
  private int growth;
  private boolean removeFlag;

  /**
   * Instantiates a new fish.
   */
  public Fish() {
    this(0, 0);
  }

  /**
   * Instantiates a new fish.
   *
   * @param x the x
   * @param y the y
   */
  public Fish(int x, int y) {
    super(x, y);
    nextDecisionTimer = -1;
    hunger = 0;
    growth = 0;
    removeFlag = false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see models.MovingObject#move()
   */
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
        distancePerStep = rand.nextInt(5) + STANDARDDISTANCEPERSTEP / 2;
      } else {
        moveDirection(distancePerStep,
            (float) Math.atan2(currentTargetY - this.y, currentTargetX - this.x));
        nextDecisionTimer--;
      }
    }
    increaseHunger(distancePerStep);
  }

  /**
   * Sets the target.
   *
   * @param mo the new target
   */
  private void setTarget(MovingObject mo) {
    setTarget(mo.x, mo.y);
  }

  /**
   * Sets the target.
   *
   * @param x the x
   * @param y the y
   */
  private void setTarget(int x, int y) {
    this.currentTargetX = x;
    this.currentTargetY = y;
  }

  /**
   * Checks if is hungry.
   *
   * @return true, if is hungry
   */
  public boolean isHungry() {
    return hunger > 500;
  }

  /**
   * Checks if is dead by starvation.
   *
   * @return true, if is dead by starvation
   */
  public boolean isDeadByStarvation() {
    return hunger > 1000;
  }

  /**
   * Increase hunger.
   *
   * @param distanceTaken the distance taken
   */
  private void increaseHunger(float distanceTaken) {
    this.hunger += distancePerStep;
  }

  /**
   * Checks if is time to decide yet.
   *
   * @return true, if is time to decide yet
   */
  private boolean isTimeToDecideYet() {
    return (nextDecisionTimer < 0 || isNearTargetYet());
  }

  /**
   * Checks if is near target yet.
   *
   * @return true, if is near target yet
   */
  private boolean isNearTargetYet() {
    int dx = Math.abs(currentTargetX - this.x);
    int dy = Math.abs(currentTargetY - this.y);
    return (dx < 10 && dy < 10);
  }


  /**
   * Gets the hunger.
   *
   * @return the hunger
   */
  public int getHunger() {
    return hunger;
  }

  /**
   * Gets the growth.
   *
   * @return the growth
   */
  public int getGrowth() {
    return growth;
  }

  /**
   * Sets the target food.
   *
   * @param targetFood the new target food
   */
  public void setTargetFood(Food targetFood) {
    this.targetFood = targetFood;
  }

  /**
   * Checks for eaten.
   */
  public void hasEaten() {
    this.hunger = 0;
    this.growth += 5;
  }

  public boolean isOnRemoval() {
    return removeFlag;
  }

  public void hasBeenSold() {
    removeFlag = true;
  }

  public int value() {
    return growth * 20;
  }
}
