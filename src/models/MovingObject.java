package models;

// TODO: Auto-generated Javadoc
/**
 * The Class MovingObject.
 */
public abstract class MovingObject {

  /** The Constant STANDARDDISTANCEPERSTEP. */
  protected final static int STANDARDDISTANCEPERSTEP = 10;

  /** The x. */
  protected int x;

  /** The y. */
  protected int y;

  /** The real X. */
  private float realX;

  /** The real Y. */
  private float realY;

  /**
   * Gets the x.
   *
   * @return the x
   */
  public int getX() {
    return x;
  }

  /**
   * Sets the x.
   *
   * @param x the new x
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Gets the y.
   *
   * @return the y
   */
  public int getY() {
    return y;
  }

  /**
   * Sets the y.
   *
   * @param y the new y
   */
  public void setY(int y) {
    this.y = y;
  }

  /**
   * Instantiates a new moving object.
   */
  public MovingObject() {
    this(0, 0);
  }

  /**
   * Instantiates a new moving object.
   *
   * @param x the x
   * @param y the y
   */
  public MovingObject(float x, float y) {
    realX = x;
    realY = y;
    determinePosition();
  }

  /**
   * Move.
   */
  abstract public void move();

  /**
   * Move direction.
   *
   * @param distance the distance
   * @param angle the angle
   */
  public void moveDirection(float distance, float angle) {
    realX += distance * Math.cos(angle);
    realY += distance * Math.sin(angle);
    determinePosition();
  }

  /**
   * Move towards.
   *
   * @param toX the to X
   * @param toY the to Y
   * @param desiredStepTaken the desired step taken
   */
  public void moveTowards(float toX, float toY, float desiredStepTaken) {
    realX += (toX - this.realX) / desiredStepTaken;
    realY += (toY - this.realY) / desiredStepTaken;
    determinePosition();
  }

  /**
   * Determine position.
   */
  private void determinePosition() {
    x = Math.round(realX);
    y = Math.round(realY);
  }

  /**
   * Calc dist between.
   *
   * @param o1 the o 1
   * @param o2 the o 2
   * @return the float
   */
  public static Float calcDistBetween(MovingObject o1, MovingObject o2) {
    return (float) Math.sqrt(Math.pow(o1.realX - o2.realX, 2) + Math.pow(o1.realY - o2.realY, 2));
  }
}
