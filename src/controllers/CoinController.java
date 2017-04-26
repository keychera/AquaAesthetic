package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Aquarium;
import models.Fish;
import models.Food;
import models.Coin;

public class CoinController implements ISubController {
	private List<Coin> coinTaken;
	private List<Coin> coinGenerated;
	
	public CoinController() {
		coinTaken = new ArrayList<>();
		coinGenerated = new ArrayList<>();
	}
	
	public List<Coin> getCoin() {
		return coinTaken;
	}
	
	public void takeCoin() {
		for(Coin coin : coinGenerated) {
			
		}
	}
	
	@Override
	public void perform() {
		// TODO Auto-generated method stub
		
	}

}
