package gitsAndShiggels;

import java.util.ArrayList;

import gitsAndShiggels.CardGameEnums.CardType;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public abstract class AbstractCard extends Button{
	
//https://stackoverflow.com/questions/27295505/javafx-button-with-multiple-text-lines

	protected int form, currentForm;
	protected final int FONT = 12;
	protected String name, clan, abilities, currentName, currentClan, currentAbilities;
	ArrayList<AbstractCard> location;
	protected CardType type;
	protected boolean canPlay, canDiscard;
	private Player player;

	public void move (ArrayList<AbstractCard> placeToBe) {
		location.remove(this);
		placeToBe.add(this);
		location = placeToBe;
	}
	
	public abstract void play();
		
	public void atTurnStart() {
		
	}
	
	public void atDrawStep() {
		
	}
	
	public void atRegenStep() {
		
	}
	
	public void atActionStart() {
		
	}
	
	public void atActionEnd() {
		
	}
	
	public void atEndOfTurn() {
		
	}
	
	public void setLocation(ArrayList<AbstractCard> location) {
		this.location = location;
	}
	
	public ArrayList<AbstractCard> getLocation() {
		return location;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public CardType getType() {
		return this.type;
	}

	public boolean canPlay() {
		return canPlay;
	}
	
	public boolean canDiscard() {
		return canDiscard;
	}
}