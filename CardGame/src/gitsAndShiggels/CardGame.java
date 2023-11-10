package gitsAndShiggels;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class CardGame extends Application {
	
	static final int GAP = 15;
	Scene scene;
	static Stage newStage;
	public static ArrayList<AbstractCard> 
		futurePile = new ArrayList<AbstractCard>(),
		Deck = new ArrayList<AbstractCard>(),
		extraPile = new ArrayList<AbstractCard>(),
		discardPile = new ArrayList<AbstractCard>();

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
		
		zoneFuture.setOnAction(event -> changeScene(futurePile));
		zoneDeck.setOnAction(event -> changeScene(Deck));
		zoneExtra.setOnAction(event -> changeScene(extraPile));
		zoneDiscard.setOnAction(event -> changeScene(discardPile));
		
		scene = new Scene(root);
		
		myStage.setTitle("Card Game");
		myStage.setScene(scene);
		myStage.show();
	}
	

	public void changeScene (ArrayList<AbstractCard> zoneToBe) {
		Menu root = new Menu(zoneToBe, newStage.getScene());
		
		Scene newScene = new Scene(root);
		setScene(newScene);
	}
	
	public void cardClicked (AbstractCard c) {
		
	}
	
	public void setScene (Scene _scene) {
		newStage.setScene(_scene);
	}

	public void main(String[] args) {
		launch(args);
	}
	
	

}