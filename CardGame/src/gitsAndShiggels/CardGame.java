package gitsAndShiggels;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import simpleIO.Console;


public class CardGame extends Application {
	
	// TODO add more output ie text to show when something like a card moves or maybe make it an animation
	Scene scene;
	static Stage newStage;
	static final int GAP = 15;
	AbstractCard selectedCard;
	public static ArrayList<AbstractCard> 
		futurePile = new ArrayList<AbstractCard>(),
		Deck = new ArrayList<AbstractCard>(),
		extraPile = new ArrayList<AbstractCard>(),
		hand = new ArrayList<AbstractCard>(),
		discardPile = new ArrayList<AbstractCard>();
	
	ListView<AbstractCard> handShown;

	@Override
	public void start(Stage myStage) throws Exception {
		newStage = myStage;
		GridPane root = new GridPane();
		root.setHgap(GAP);
		root.setVgap(GAP);
		root.setPadding(new Insets(GAP, GAP, GAP, GAP));
				
		Zone zoneFuture = new Zone("Future");
		root.add(zoneFuture, 0, 0);
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
		for (int i = 0; i < 25; i++) {
			AbstractCard c = new AbstractCard(i + "", hand);
			c.setOnAction(event -> selectCard(c));
			hand.add(c);
		}
		
		
		handShown = new ListView<AbstractCard>();
		handShown.setOrientation(Orientation.HORIZONTAL);
		handShown.setPrefSize(150, 221);
		updateHand();
		root.add(handShown, 0, 2, 3, 1);
		
		zoneFuture.setOnAction(event -> selectZone(futurePile));
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
	
	public void selectZone (ArrayList<AbstractCard> a) {
		if (selectedCard != null) {
			selectedCard.move(a);
			Console.print("zone");
			selectedCard = null;
			updateHand();
		} else {
			changeScene(a);
		}
	}
	
	public void changeScene (ArrayList<AbstractCard> zoneToBe) {
		Menu root = new Menu(zoneToBe, newStage.getScene());
		
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
		newStage.setScene(_scene);
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	

}