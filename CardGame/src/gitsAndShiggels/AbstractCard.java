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

	private int form, power, health;
	private final int FONT = 12;
	private String name, clan, abilities;
	ArrayList<AbstractCard> location;
	
	//TODO remake this whole class and use it insted of buttons where i use buttons in other classes
	//TODO make everything happen inside the CardGame not anywhere else. ie set on action method and setting should be in CardGame.
	
	public AbstractCard (String name, int form, String clan, String abilities, int power, int health, Aspects aspect) {
		this.name = name;
		this.form = form;
		this.clan = clan;
		this.abilities = abilities;
		this.power = power; 
		this.health = health;
		this.setPrefSize(150, 200);
		this.setGraphic(genCardGraphic());
		this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		
		if (aspect == Aspects.WRATH) {
			this.setStyle(CardGame.red);
		} else if (aspect == Aspects.SHREWD) {
			this.setStyle(CardGame.yellow);
		}else if (aspect == Aspects.MEEK) {
			this.setStyle(CardGame.purple);
		}else {
			this.setStyle(CardGame.white);
		}
	}
		
	public AnchorPane genCardGraphic() {
		Label txtName = new Label(name);
		txtName.setWrapText(true);
		txtName.setStyle("-fx-max-width : 135px");
		Label txtForm = new Label(form + "");
		Label txtClan = new Label(clan);
		Label txtAbilities = new Label(abilities);
		txtAbilities.setWrapText(true);
		txtAbilities.setStyle("-fx-max-width : 135px");
		Label lblPowerHealth = new Label(power + "/" + health);
		Label txtHealth = new Label(health + "");
		AnchorPane card = new AnchorPane(txtName, txtForm, txtClan, txtAbilities, lblPowerHealth);
		card.setMaxSize(150, 200);
		
		card.setTopAnchor(txtForm, 0.0);
		card.setLeftAnchor(txtClan, 15.0);
		card.setTopAnchor(txtName, 12.0);
		card.setBottomAnchor(txtAbilities, 12.0);
		card.setRightAnchor(lblPowerHealth, 0.0);
		card.setBottomAnchor(lblPowerHealth, 0.0);
		
		return card;
	}

	public void move (ArrayList<AbstractCard> placeToBe) {
		location.remove(this);
		placeToBe.add(this);
		location = placeToBe;
	}
	
	public void setLocation(ArrayList<AbstractCard> location) {
		this.location = location;
	}
}