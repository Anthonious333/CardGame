package gitsAndShiggels;

import javafx.scene.control.Button;

public class AbstractCard extends Button{

	private int location, cardNumber, phase, attack, defence;
	
	public AbstractCard (int location, int cardNumber, int phase, int attack, int defence) {
		this.location = location;
		this.cardNumber = cardNumber;
		this.phase = phase;
		this.attack = attack;
		this.defence = defence; 
	}
}
