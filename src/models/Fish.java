package models;

import java.util.Random;

import views.AquariumView;

public class Fish extends MovingObject {
	private float distancePerStep = 2;
	private int nextDecisionTimer;
	private int currentTargetX;
	private int currentTargetY;

	public Fish() {
		this(0, 0);
	}

	public Fish(int x, int y) {
		super(x, y);
		nextDecisionTimer = -1;
	}

	public void move() {
		if (isTimeToDecideYet()) {
			Random rand = new Random();
			nextDecisionTimer = rand.nextInt(30) + 15;
			currentTargetX = rand.nextInt(AquariumView.VIEWWIDTH);
			currentTargetY = rand.nextInt(AquariumView.VIEWHEIGHT);
			//for option 2
			distancePerStep = rand.nextInt(10) + 1;
		} else {
			// option 1
			// moveTowards(currentTargetX, currentTargetY, nextDecisionTimer +
			// 1);
			// option 2
			moveDirection(distancePerStep, (float) Math.atan2(currentTargetY - this.y, currentTargetX - this.x));
			nextDecisionTimer--;
		}
	}

	private boolean isTimeToDecideYet() {
		return (nextDecisionTimer < 0 || isNearTargetYet());
	}

	private boolean isNearTargetYet() {
		int dx = Math.abs(currentTargetX - this.x);
		int dy = Math.abs(currentTargetY - this.y);
		return (dx < 10 && dy < 10);
	}

}
