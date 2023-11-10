package gitsAndShiggels;

import java.util.ArrayList;

import javafx.scene.control.Button;

public class AbstractCard extends Button{

	private int location, cardNumber, phase, attack, defence;
	
	//TODO remake this whole class and use it insted of buttons where i use buttons in other classes
	//TODO make everything happen inside the CardGame not anywhere else. ie set on action method and setting should be in CardGame.
	public AbstractCard (int location, int cardNumber, int phase, int attack, int defence) {
		this.location = location;
		this.cardNumber = cardNumber;
		this.phase = phase;
		this.attack = attack;
		this.defence = defence; 
	}
		
	public void move (ArrayList<AbstractCard> placeToBe, ArrayList<AbstractCard> whereIAm) {
		whereIAm.remove(this);
		placeToBe.add(this);
	}
}