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
	//TODO make a "makeCard" method that makes the card and tells it where it is in one motion so you can make card during combat super easy
	Scene scene;
	static Stage newStage;
//	static final int GAP = 15;
	AbstractCard selectedCard;

	ListView<AbstractCard> handShown;
	
	Button back = new Button("Back");

	@Override
	public void start(Stage myStage) throws Exception {
		newStage = myStage;
		Player p = new Player();
		Board brd1 = new Board(
				event -> selectZone(p.getFate()), 
				event -> selectZone(p.getDeck()), 
				event -> selectZone(p.getExtraPile()), 
				event -> selectZone(p.getDiscardPile()));
		
		Player p2 = new Player();
		Board brd2 = new Board(
				event -> selectZone(p2.getFate()), 
				event -> selectZone(p2.getDeck()), 
				event -> selectZone(p2.getExtraPile()), 
				event -> selectZone(p2.getDiscardPile()));
		brd2.hide();
		//TODO populate deck with the testDeck you made.
		GridPane root = new GridPane();
		root.add(brd1, 0, 0);
		root.add(brd2, 1, 0);
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
		
		if (zone == AbstractDeck) {
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
		if (AbstractDeck.isEmpty()) {
			//TODO make discard shuffle into deck
		}
		AbstractDeck.get(0).move(hand);
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