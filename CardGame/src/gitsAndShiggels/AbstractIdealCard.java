package gitsAndShiggels;

import java.util.ArrayList;

import gitsAndShiggels.CardGameEnums.Aspects;
import gitsAndShiggels.CardGameEnums.CardType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public abstract class AbstractIdealCard extends AbstractCard{
	
	private int power, health, currentPower, currentHealth;
	private boolean isDead;
	
	public AbstractIdealCard (String name, int form, String abilities, String clan, int power, int health, Aspects aspect) {
		this.currentName = name;
		this.currentForm = form;
		this.currentAbilities = abilities;
		this.currentClan = clan;
		this.currentPower = power; 
		this.currentHealth = health;
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
		this.canPlay = true;
		this.canDiscard = true;
		this.setDead(false);
		

		
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
		
		Label txtName = new Label(this.currentName);
		txtName.setWrapText(true);
		txtName.setStyle("-fx-max-width : 120px");
		
		Label txtForm = new Label(this.currentForm + "");
		
		Label txtAbilities = new Label(this.currentAbilities);
		txtAbilities.setWrapText(true);
		txtAbilities.setStyle("-fx-max-width : 135px");
		
		Label txtClan = new Label(this.currentClan);
		
		Label lblPowerHealth = new Label(this.currentPower + "/" + this.currentHealth);
		
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
	
	public void takeDamage(int damageTaken) {
		this.currentHealth -= damageTaken;
		if(currentHealth < 1) {
			die();
		} else {
			this.setGraphic(genCardGraphic());
		}
		
		if (this.location == this.getPlayer().getIdeal()) {
			this.getPlayer().updateGraphics();
		}
	}
	
	public void die() {
		this.currentName += " (Dead)";
		this.isDead = true;
		this.currentHealth = 0;
		this.move(this.getPlayer().getFate());
		this.getPlayer().selectIdeal();
		this.setGraphic(genCardGraphic());
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
}
