package gitsAndShiggels;

import java.util.ArrayList;

import gitsAndShiggels.decks.AbstractDeck;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board extends GridPane{

	static final int GAP = 15;
	
//	final EventHandler<ActionEvent> FATE, DECK, EXTRA, DISCARD;
	private Zone zoneFate, zoneDeck, zoneExtra, zoneDiscard;
	private Rectangle topBlank;
	private GridPane botBlank;
	ListView<AbstractCard> handShown;
	Player p;
	
	public Board (String name, AbstractDeck playerDeck) {
	p = new Player(name, this, playerDeck);
		
	this.setHgap(GAP);
	this.setVgap(GAP);
	this.setPadding(new Insets(GAP, GAP, GAP, GAP));
		
	zoneFate = new Zone("Fate");
	zoneDeck = new Zone("Deck");
	zoneExtra = new Zone("Extra");
	zoneDiscard = new Zone("Discard");
	handShown = new ListView<AbstractCard>();
	handShown.setOrientation(Orientation.HORIZONTAL);
	handShown.setPrefSize(150, 221);
	topBlank = new Rectangle(200, 200, Color.WHITE);
	botBlank = new GridPane();
	Button btnHide = new Button("Hide");
	Button btnShow = new Button("Show");
	botBlank.add(btnShow, 0, 0);
	botBlank.add(btnHide, 0, 1);
	this.add(botBlank, 1, 1);

	zoneFate.setOnAction(event -> p.selectZone(p.getFate()));
	zoneDeck.setOnAction(event -> p.selectZone(p.getDeck()));
	zoneExtra.setOnAction(event -> p.selectZone(p.getExtraPile()));
	zoneDiscard.setOnAction(event -> p.selectZone(p.getDiscardPile()));
	
	this.show();
	
	btnHide.setOnAction(event -> hide());
	btnShow.setOnAction(event -> show());
	}
	
	public void disable() {
		zoneFate.setDisable(true);
		zoneDeck.setDisable(true);
		zoneExtra.setDisable(true);
		zoneDiscard.setDisable(true);
	}
	
	public void enable() {
		zoneFate.setDisable(false);
		zoneDeck.setDisable(false);
		zoneExtra.setDisable(false);
		zoneDiscard.setDisable(false);
	}
	
	public void hide() {
		this.getChildren().clear();
		this.add(botBlank, 1, 1);

	}
	
	public void show() {
		this.add(zoneFate, 0, 0);
		this.add(zoneDeck, 2, 0);
		this.add(zoneExtra, 0, 1);
		this.add(zoneDiscard, 2, 1);
		this.add(topBlank, 1, 0);
		this.add(handShown, 0, 2, 3, 1);
	}
	
	public void updateHand() {
		if (handShown != null) {
			handShown.getItems().clear();
		}
		for (int i = 0; i < p.getHand().size(); i++) {
			handShown.getItems().add(p.getHand().get(i));
		}
	}
	
	
}
