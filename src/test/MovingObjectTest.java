package test;

import static org.junit.Assert.*;

import models.MovingObject;
import models.Fish;

import org.junit.Test;

public class MovingObjectTest {

	@Test
	public void test() {
		
		MovingObject mo1 = new Fish();
		MovingObject mo2 = new Fish(3,4);
		
		int x=Math.round(MovingObject.calcDistBetween(mo1, mo2));
		assertEquals(5,x);
		
	}

}
