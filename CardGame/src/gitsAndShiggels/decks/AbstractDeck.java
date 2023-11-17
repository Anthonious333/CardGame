package gitsAndShiggels.decks;

import java.util.ArrayList;

import gitsAndShiggels.AbstractCard;
import gitsAndShiggels.WrathCards.Gorg;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AbstractDeck extends ArrayList<AbstractCard>{

	public AbstractDeck () {
		//ADD CARDS HERE. 
		//Example:
//		this.add(new Gorg());
	}
	
	public void setLocation(ArrayList<AbstractCard> deck) {
		for (AbstractCard c : this) {
			c.setLocation(deck);
		}
	}
	

}
