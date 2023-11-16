package gitsAndShiggels;

import java.util.ArrayList;

import gitsAndShiggels.decks.AbstractDeck;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class Player {
	
	private String name;
	private Board brdSuper;
	private Scene origionalScene;
	private AbstractCard selectedCard;

	private ArrayList<AbstractCard> 
	fate = new ArrayList<AbstractCard>(),
	Deck = new AbstractDeck(),
	extraPile = new ArrayList<AbstractCard>(),
	hand = new ArrayList<AbstractCard>(),
	discardPile = new ArrayList<AbstractCard>();
	
	public Player(String name, Scene origionalScene, Board brdSuper, AbstractDeck playersDeck) {
		this.name = name;
		this.origionalScene = origionalScene;
		this.brdSuper = brdSuper;
		this.Deck = playersDeck;
		
	}
	
	public void selectZone (ArrayList<AbstractCard> zone) {
		ArrayList<Button> list = new ArrayList<Button>();
		
		
		if (zone == Deck) {
			Button btnDraw = new Button("Draw");
			btnDraw.setOnAction(event -> {	
				draw();
				setScene(origionalScene);
			});
			list.add(btnDraw);
		}
		
		if (selectedCard != null) {
			Button btnMove = new Button("Move");
			btnMove.setOnAction(event -> {
				move(zone);
				setScene(origionalScene);
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
		
		Button back = new Button("Back");
		back.setOnAction(event -> setScene(origionalScene));
		list.add(back);
		
		ListView<Button> root = new ListView<Button>();
		for (Button b : list) {
			root.getItems().add(b);
		}
				
		Scene newScene = new Scene(root);
		setScene(newScene);
	}
	
	public void setScene (Scene _scene) {
		brdSuper.updateHand();
		CardGame.newStage.setScene(_scene);
	}
	
	public void selectCard (AbstractCard c) {
		selectedCard = c;
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
		Menu root = new Menu(toOpen, origionalScene);
		
		Scene newScene = new Scene(root);
		setScene(newScene);
	}

	public ArrayList<AbstractCard> getFate() {
		return fate;
	}

	public void setFate(ArrayList<AbstractCard> fate) {
		this.fate = fate;
	}

	public ArrayList<AbstractCard> getDeck() {
		return Deck;
	}

	public void setDeck(ArrayList<AbstractCard> deck) {
		Deck = deck;
	}

	public ArrayList<AbstractCard> getExtraPile() {
		return extraPile;
	}

	public void setExtraPile(ArrayList<AbstractCard> extraPile) {
		this.extraPile = extraPile;
	}

	public ArrayList<AbstractCard> getHand() {
		return hand;
	}

	public void setHand(ArrayList<AbstractCard> hand) {
		this.hand = hand;
	}

	public ArrayList<AbstractCard> getDiscardPile() {
		return discardPile;
	}

	public void setDiscardPile(ArrayList<AbstractCard> discardPile) {
		this.discardPile = discardPile;
	}
	
}
