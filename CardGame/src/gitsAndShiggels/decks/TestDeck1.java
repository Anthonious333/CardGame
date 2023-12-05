package gitsAndShiggels.decks;

import java.util.ArrayList;

import gitsAndShiggels.AbstractCard;
import gitsAndShiggels.WrathCards.Gorg;
import gitsAndShiggels.WrathCards.PotOfGreed;
import gitsAndShiggels.WrathCards.SakeOfLife;
import gitsAndShiggels.WrathCards.blankCard;

public class TestDeck1 extends AbstractDeck{

	public TestDeck1 () {
		//ADD CARDS HERE. 
		//Example:
		this.add(new PotOfGreed());
		this.add(new SakeOfLife());
		for (int i = 0; i < 20; i++) {
			this.add(new blankCard());
		}
	}
	
}
