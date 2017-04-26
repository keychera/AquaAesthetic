package test;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Coin;

public class CoinTest {

	@Test
	public void test() {
		Coin c = new Coin(10,10);
		assertFalse(c.isTaken());
		c.hasBeenTaken();
		assertTrue(c.isTaken());
	}

}
