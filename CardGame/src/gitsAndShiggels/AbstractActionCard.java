package gitsAndShiggels;

import gitsAndShiggels.CardGameEnums.Aspects;
import gitsAndShiggels.CardGameEnums.CardType;
import gitsAndShiggels.CardGameEnums.Speeds;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public abstract class AbstractActionCard extends AbstractCard{

	private Speeds speed;
	private int actionCost;
	
	public AbstractActionCard(String name, int form, String abilities, Speeds speed, int actionCost, String clan, Aspects aspect) {
		this.name = name;
		this.form = form;
		this.abilities = abilities;
		this.speed = speed;
		this.actionCost = actionCost;
		this.clan = clan;
		this.setPrefSize(150, 200);
		this.setGraphic(genCardGraphic());
		this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		this.type = CardType.ACTION;
		this.canPlay = true;
		this.canDiscard = true;
		
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
		txtName.setStyle("-fx-max-width : 135px");
		
		Label txtForm = new Label(this.form + "");
		
		Label txtAbilities = new Label(this.abilities);
		txtAbilities.setWrapText(true);
		txtAbilities.setStyle("-fx-max-width : 135px");
		
		Label lblSpeed = new Label();
		if (this.speed == Speeds.FAST) {
			lblSpeed.setText("Fast");
		} else if (this.speed == Speeds.SLOW) {
			lblSpeed.setText("Slow");
		} else {
			lblSpeed.setText("ERROR / genCardGraphic");
		}
		
		Label lblActionCost = new Label(this.actionCost + "");
		
		Label txtClan = new Label(this.clan);
		
		
		AnchorPane card = new AnchorPane(txtName, txtForm, txtClan, txtAbilities, lblSpeed, lblActionCost);
		card.setMaxSize(150, 200);
		
		card.setTopAnchor(txtForm, 0.0);
		card.setLeftAnchor(txtName, 12.0);
		card.setBottomAnchor(txtAbilities, 12.0);
		card.setBottomAnchor(lblSpeed, 0.0);
		card.setBottomAnchor(lblActionCost, 0.0);
		card.setLeftAnchor(lblActionCost, 28.0);
		card.setBottomAnchor(txtClan, 0.0);
		card.setLeftAnchor(txtAbilities, 12.0);
		card.setLeftAnchor(lblSpeed, 0.0);
		card.setLeftAnchor(txtClan, 38.0);
		

		
		return card;
	}
	
}
