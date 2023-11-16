package gitsAndShiggels.decks;

import java.util.ArrayList;

import gitsAndShiggels.AbstractCard;
import gitsAndShiggels.WrathCards.Gorg;

public class testDeck1 extends ArrayList<AbstractCard>{

	public testDeck1 (ArrayList<AbstractCard> deck) {
		//ADD CARDS HERE. 
		//Example:
//		this.add(new Gorg());
		
		
		setLocation(deck);
	}
	
	public void setLocation(ArrayList<AbstractCard> deck) {
		for (AbstractCard c : this) {
			c.setLocation(deck);
		}
	}
}
