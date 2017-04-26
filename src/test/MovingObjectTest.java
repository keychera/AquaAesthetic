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
		MovingObject mo3 = new Fish();
		
		int x = Math.round(mo3.calcDistBetween(mo1, mo2));
		assertEquals(5,x);
		
	}

}
