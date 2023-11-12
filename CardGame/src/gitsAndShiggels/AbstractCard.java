package gitsAndShiggels;

import java.util.ArrayList;

import javafx.scene.control.Button;

public class AbstractCard extends Button{

	private int  cardNumber, phase, attack, defence;
	ArrayList<AbstractCard> location;
	
	//TODO remake this whole class and use it insted of buttons where i use buttons in other classes
	//TODO make everything happen inside the CardGame not anywhere else. ie set on action method and setting should be in CardGame.
	
	public AbstractCard (String s, ArrayList<AbstractCard> location) {
		super(s);
		this.location = location;
		this.setPrefSize(150, 200);
	}
		
	public void move (ArrayList<AbstractCard> placeToBe) {
		location.remove(this);
		placeToBe.add(this);
	}
}