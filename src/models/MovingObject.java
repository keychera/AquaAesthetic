package models;

public abstract class MovingObject {
	protected int x;
	protected int y;
	private float realX;
	private float realY;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public MovingObject(){
		this(0,0);
	}

	public MovingObject(float x, float y) {
		realX = x;
		realY = y;
		determinePosition();
	}

	public void moveDirection(float distance, float angle) {
		realX += distance * Math.cos(angle);
		realY += distance * Math.sin(angle);
		determinePosition();
	}
	
	public void moveTowards(float toX, float toY, float desiredStepTaken) {
		realX += (toX - this.realX)/desiredStepTaken;
		realY += (toY - this.realY)/desiredStepTaken;
		determinePosition();
	}

	private void determinePosition() {
		x = Math.round(realX);
		y = Math.round(realY);
	}
}
