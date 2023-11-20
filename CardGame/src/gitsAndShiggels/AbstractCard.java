package gitsAndShiggels;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class AbstractCard extends Button{
	
//https://stackoverflow.com/questions/27295505/javafx-button-with-multiple-text-lines

	protected int form;
	protected final int FONT = 12;
	protected String name, clan, abilities;
	ArrayList<AbstractCard> location;

	public void move (ArrayList<AbstractCard> placeToBe) {
		location.remove(this);
		placeToBe.add(this);
		location = placeToBe;
	}
	
	public void setLocation(ArrayList<AbstractCard> location) {
		this.location = location;
	}
	

}