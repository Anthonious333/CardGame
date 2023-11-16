package gitsAndShiggels;

import java.util.ArrayList;

import gitsAndShiggels.WrathCards.Gorg;
import gitsAndShiggels.decks.testDeck1;
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
	//TODO make a "makeCard" method that makes the card and tells it where it is in one motion so you can make card during combat super easy
	Scene scene;
	static Stage newStage;

	ListView<AbstractCard> handShown;
	

	@Override
	public void start(Stage myStage) throws Exception {
		newStage = myStage;
		Board brd1 = new Board("Player 1", this.scene, new TestDeck1()); //TODO fix deck thing just to padd player deck to itself when it is made.
		Board brd2 = new Board("Player 2", this.scene, new TestDeck1());
		brd2.hide();
		
		GridPane root = new GridPane();
		root.add(brd1, 0, 0);
		root.add(brd2, 1, 0);
		scene = new Scene(root);
		
		myStage.setTitle("Card Game");
		myStage.setScene(scene);
		myStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	

}