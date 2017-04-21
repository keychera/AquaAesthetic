package models;



import java.awt.Color;
import java.awt.Image;
import java.util.Random;

public class Food extends movingObject {
	
	private int x,y;
	private Color colors;
	private Image img;
	
	public Food(int x, int y, Color colors){
		this.x = x;
		this.y = y;
		this.colors = colors;
	};
	
	public Color getColors(){
		return this.colors;
	};
	
	public void setColors(Color colors1){
		this.colors = colors1;
	}
	
	public void moveFood(){
		Random rand = new Random();
		int dis = rand.nextInt(10)+1;
		int dir = rand.nextInt(8)+1;
		int delay = rand.nextInt(10)+1;
		
		delayedMove(delay);
		move(dis,dir);
	};
	

}
