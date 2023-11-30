package gitsAndShiggels;

import java.util.ArrayList;

import gitsAndShiggels.CardGameEnums.Aspects;
import gitsAndShiggels.CardGameEnums.CardType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public abstract class AbstractIdealCard extends AbstractCard{
	
	private int power, health;
	
	public AbstractIdealCard (String name, int form, String abilities, String clan, int power, int health, Aspects aspect) {
		this.name = name;
		this.form = form;
		this.abilities = abilities;
		this.clan = clan;
		this.power = power; 
		this.health = health;
		this.setPrefSize(150, 200);
		this.setGraphic(genCardGraphic());
		this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		this.type = CardType.IDEAL;
		
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
	
	public abstract void play();

	
	public AnchorPane genCardGraphic() {
		
		Label txtName = new Label(this.name);
		txtName.setWrapText(true);
		txtName.setStyle("-fx-max-width : 120px");
		
		Label txtForm = new Label(this.form + "");
		
		Label txtAbilities = new Label(this.abilities);
		txtAbilities.setWrapText(true);
		txtAbilities.setStyle("-fx-max-width : 135px");
		
		Label txtClan = new Label(this.clan);
		
		Label lblPowerHealth = new Label(this.power + "/" + this.health);
		
		AnchorPane card = new AnchorPane(txtName, txtForm, txtClan, txtAbilities, lblPowerHealth);
		card.setMaxSize(150, 200);
		
		card.setTopAnchor(txtForm, 0.0);
		card.setLeftAnchor(txtName, 15.0);
		card.setBottomAnchor(txtAbilities, 12.0);
		card.setBottomAnchor(txtClan, 0.0);
		card.setRightAnchor(lblPowerHealth, 0.0);
		card.setBottomAnchor(lblPowerHealth, 0.0);
		
		return card;
	}
}
