package gitsAndShiggels;

import java.util.ArrayList;

import gitsAndShiggels.WrathCards.Gorg;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import simpleIO.Console;


public class CardGame extends Application {
	
	//public colors
	public static final String lightBlue = "-fx-background-color: #ADD8E6; ";
	public static final String yellow = "-fx-background-color: #F0E68C; ";
	public static final String purple = "-fx-background-color: #DA70D6; ";
	public static final String white = "-fx-background-color: #F8F8FF; ";
	public static final String red = "-fx-background-color: #E9967A; ";

	
	// TODO add more output ie text to show when something like a card moves or maybe make it an animation
	Scene scene;
	static Stage newStage;
	static final int GAP = 15;
	AbstractCard selectedCard;
	public static ArrayList<AbstractCard> 
		fate = new ArrayList<AbstractCard>(),
		Deck = new ArrayList<AbstractCard>(),
		extraPile = new ArrayList<AbstractCard>(),
		hand = new ArrayList<AbstractCard>(),
		discardPile = new ArrayList<AbstractCard>();
	
	ListView<AbstractCard> handShown;
	
	Button back = new Button("Back");

	@Override
	public void start(Stage myStage) throws Exception {
		newStage = myStage;
		GridPane root = new GridPane();
		root.setHgap(GAP);
		root.setVgap(GAP);
		root.setPadding(new Insets(GAP, GAP, GAP, GAP));
				
		Zone zoneFate = new Zone("Fate");
		root.add(zoneFate, 0, 0);
		Rectangle topBlank = new Rectangle(200, 200, Color.WHITE);
		root.add(topBlank, 1, 0);
		Zone zoneDeck = new Zone("Deck");
		root.add(zoneDeck, 2, 0);
		Zone zoneExtra = new Zone("Extra");
		root.add(zoneExtra, 0, 1);
		Rectangle botBlank = new Rectangle(200, 200, Color.WHITE);
		root.add(botBlank, 1, 1);
		Zone zoneDiscard = new Zone("Discard");
		root.add(zoneDiscard, 2, 1);
		
		//testing
		for (int i = 0; i < 5; i++) {
			AbstractCard c = new Gorg(Deck);
			c.setOnAction(event -> selectCard(c));
			Deck.add(c);
		}
		
		
		handShown = new ListView<AbstractCard>();
		handShown.setOrientation(Orientation.HORIZONTAL);
		handShown.setPrefSize(150, 221);
		updateHand();
		root.add(handShown, 0, 2, 3, 1);
		
		zoneFate.setOnAction(event -> selectZone(fate));
		zoneDeck.setOnAction(event -> selectZone(Deck));
		zoneExtra.setOnAction(event -> selectZone(extraPile));
		zoneDiscard.setOnAction(event -> selectZone(discardPile));
		
		scene = new Scene(root);
		
		myStage.setTitle("Card Game");
		myStage.setScene(scene);
		myStage.show();
	}
	
	public void selectCard (AbstractCard c) {
		selectedCard = c;
	}
	
	public void selectZone (ArrayList<AbstractCard> zone) {
		ArrayList<Button> list = new ArrayList<Button>();
		
		if (zone == Deck) {
			Button btnDraw = new Button("Draw");
			btnDraw.setOnAction(event -> {	
				draw();
				setScene(this.scene);
			});
			list.add(btnDraw);
		}
		
		if (selectedCard != null) {
			Button btnMove = new Button("Move");
			btnMove.setOnAction(event -> {
				move(zone);
				setScene(this.scene);
			});
			list.add(btnMove);
		}
		
		if (!zone.isEmpty()) {
			Button btnOpen = new Button("Open");
			btnOpen.setOnAction(event -> {
				open(zone);
			});
			list.add(btnOpen);
		}
		
		back.setOnAction(event -> setScene(this.scene));
		list.add(back);
		
		ListView<Button> root = new ListView<Button>();
		for (Button b : list) {
			root.getItems().add(b);
		}
				
		Scene newScene = new Scene(root);
		setScene(newScene);
	}
	
	public void updateHand() {
		if (handShown != null) {
			handShown.getItems().clear();
		}
		for (int i = 0; i < hand.size(); i++) {
			handShown.getItems().add(hand.get(i));
		}
	}
	
	public void setScene (Scene _scene) {
		updateHand();
		newStage.setScene(_scene);
	}
	
	public void draw() {
		if (Deck.isEmpty()) {
			//TODO make discard shuffle into deck
		}
		Deck.get(0).move(hand);
	}
	
	public void move(ArrayList<AbstractCard> a) {
		selectedCard.move(a);
	}
	
	public void open (ArrayList<AbstractCard> toOpen) {
		Menu root = new Menu(toOpen, this.scene);
		
		Scene newScene = new Scene(root);
		setScene(newScene);
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	

}