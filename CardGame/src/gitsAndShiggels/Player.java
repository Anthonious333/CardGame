package gitsAndShiggels;

import java.util.ArrayList;

public class Player {
	
	private ArrayList<AbstractCard> 
	fate = new ArrayList<AbstractCard>(),
	Deck = new ArrayList<AbstractCard>(),
	extraPile = new ArrayList<AbstractCard>(),
	hand = new ArrayList<AbstractCard>(),
	discardPile = new ArrayList<AbstractCard>();
	
	public Player() {
		
	}
	
	
	

	public ArrayList<AbstractCard> getFate() {
		return fate;
	}

	public void setFate(ArrayList<AbstractCard> fate) {
		this.fate = fate;
	}

	public ArrayList<AbstractCard> getDeck() {
		return Deck;
	}

	public void setDeck(ArrayList<AbstractCard> deck) {
		Deck = deck;
	}

	public ArrayList<AbstractCard> getExtraPile() {
		return extraPile;
	}

	public void setExtraPile(ArrayList<AbstractCard> extraPile) {
		this.extraPile = extraPile;
	}

	public ArrayList<AbstractCard> getHand() {
		return hand;
	}

	public void setHand(ArrayList<AbstractCard> hand) {
		this.hand = hand;
	}

	public ArrayList<AbstractCard> getDiscardPile() {
		return discardPile;
	}

	public void setDiscardPile(ArrayList<AbstractCard> discardPile) {
		this.discardPile = discardPile;
	}
	
}
