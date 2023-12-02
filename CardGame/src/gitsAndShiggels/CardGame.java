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
	//TODO make the deaks cheak if they are the right size.
	//TODO do all the things for grades ie cant play some card at some times
	//TODO fix ideals zone on action, its just the default rn
	//TODO make a face down pile in each zone by giving cards a isFaceDown property that is ckeacked when making a menu and a "Face Down" button to open that menu (the back button sould lead to the board not the last menu)
	//TODO similar to one above make it so there is a players turn and a turn counter for each player, here also add the action counter.
	//TODO ^make it so one player 1's turn player two's hand is hidden and vis a versa
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