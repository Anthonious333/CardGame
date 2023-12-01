package gitsAndShiggels;

import java.util.ArrayList;

import gitsAndShiggels.WrathCards.Gorg;
import gitsAndShiggels.decks.TestDeck1;
import gitsAndShiggels.decks.TestDeck1Ideals;
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
	public static final String grey = "-fx-background-color: #808080; ";

	
	// TODO add more output ie text to show when something like a card moves or maybe make it an animation
	//TODO make a "makeCard" method that makes the card and tells it where it is in one motion so you can make card during combat super easy
	static Scene scene;
	static Stage newStage;
	TestDeck1 player1Deck = new TestDeck1();
	TestDeck1 player2Deck = new TestDeck1();
	
	TestDeck1Ideals player1Ideals = new TestDeck1Ideals();
	TestDeck1Ideals player2Ideals = new TestDeck1Ideals();

	ListView<AbstractCard> handShown;
	

	@Override
	public void start(Stage myStage) throws Exception {
		newStage = myStage;
		Board brd1 = new Board("Player 1", player1Deck, player1Ideals); 
		Board brd2 = new Board("Player 2", player2Deck, player2Ideals);
		
		brd1.p.setOpponent(brd2.p);
		brd2.p.setOpponent(brd1.p);
		
		brd2.hide();
		
		GridPane root = new GridPane();
		root.add(brd1, 0, 0);
		root.add(brd2, 1, 0);
		scene = new Scene(root);
		
		myStage.setTitle("Card Game");
		myStage.setScene(scene);
		myStage.show();

	}
	
	public static void setScene() {
		newStage.setScene(scene);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	

}