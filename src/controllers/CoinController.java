package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Aquarium;
import models.Fish;
import models.Food;
import models.Coin;

// TODO: Auto-generated Javadoc
/**
 * The Class CoinController.
 */
public class CoinController implements ISubController {
	
	/** The coin taken. */
	private List<Coin> coinTaken;
	
	/** The coin generated. */
	private List<Coin> coinGenerated;
	
	/**
	 * Instantiates a new coin controller.
	 */
	public CoinController() {
		coinTaken = new ArrayList<>();
		coinGenerated = new ArrayList<>();
	}
	
	/**
	 * Gets the coin.
	 *
	 * @return the coin
	 */
	public List<Coin> getCoin() {
		return coinTaken;
	}
	
	/**
	 * Take coin.
	 */
	public void takeCoin() {
		for(Coin coin : coinGenerated) {
			if (coin.isTaken()) {
				coin.getVal();
			}
		}
	}
	
	/* implementing method perform from ISubController interface
	 * 
	 */
	@Override
	public void perform() {
		
	}
}
