package models;

// TODO: Auto-generated Javadoc
/**
 * The Class Coin.
 */
public class Coin extends MovingObject {
	
	/** The val. */
	private static int VAL = 10;
	
	/** The taken. */
	private boolean taken;
	
	/**
	 * Instantiates a new coin.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Coin(int x, int y) {
		super(x,y);
		taken = false;
	}
	
	/**
	 * Checks if is taken.
	 *
	 * @return true, if is taken
	 */
	public boolean isTaken() {
		return taken;
	}
	
	/* moving through the screen vertically.
	 * 
	 */
	@Override
	public void move() {
		moveDirection(STANDARDDISTANCEPERSTEP / 5, (float) (0.5 * Math.PI));
	}
	
	/**
	 * Checks for been taken.
	 */
	public void hasBeenTaken() {
	    taken = true;
	}
	
	/**
	 * Gets the val.
	 *
	 * @return the val
	 */
	public int getVal() {
		return VAL;
	}
}
