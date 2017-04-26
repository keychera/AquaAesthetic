package models;

public class Coin extends MovingObject {
	private static final int COINVALDEF = 10;
	private boolean taken;
	
	public Coin(int x, int y) {
		super(x,y);
		taken = false;
	}
	
	public boolean isTaken() {
		return taken;
	}
	
	@Override
	public void move() {
		moveDirection(STANDARDDISTANCEPERSTEP / 5, (float) (0.5 * Math.PI));
	}
	
	public void hasBeenTaken() {
	    taken = true;
	}
}
