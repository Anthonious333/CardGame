package gitsAndShiggels;

import java.util.ArrayList;

import gitsAndShiggels.CardGameEnums.CardType;
import gitsAndShiggels.CardGameEnums.Phases;
import gitsAndShiggels.decks.AbstractDeck;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class Player {
	
	private String name;
	private Board brdSuper;
	private Scene origionalScene;
	private AbstractCard selectedCard;
	private Phases currentPhase;
	private GridPane boardBtnBar;
	private Player opponent;

	private ArrayList<AbstractCard> 
	fate = new ArrayList<AbstractCard>(),
	Deck = new AbstractDeck(),
	extraPile = new ArrayList<AbstractCard>(),
	hand = new ArrayList<AbstractCard>(),
	discardPile = new ArrayList<AbstractCard>(), 
	ideal = new ArrayList<AbstractCard>();
	
	
	public Player(String name, Board brdSuper, AbstractDeck playersDeck, AbstractDeck playersIdeals) {
		this.name = name;
		this.brdSuper = brdSuper;
		this.Deck = playersDeck;
		playersDeck.setLocation(Deck);
		this.fate = playersIdeals;
		playersIdeals.setLocation(fate);
		boardBtnBar = ((GridPane) brdSuper.getChildren().get(6));
		setCardsUp();
		
	}
	
	public void selectZone (ArrayList<AbstractCard> zone) {
		ArrayList<Button> list = new ArrayList<Button>();
		
		
		if (zone == Deck) {
			Button btnDraw = new Button("Draw");
			btnDraw.setOnAction(event -> {	
				draw();
				CardGame.setScene();
				brdSuper.updateHand();
			});
			list.add(btnDraw);
		}
		
		if (selectedCard != null) {
			Button btnMove = new Button("Move");
			btnMove.setOnAction(event -> {
				move(zone);
				CardGame.setScene();
				brdSuper.updateHand();
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
		back.setOnAction(event -> CardGame.setScene());
		list.add(back);
		
		ListView<Button> root = new ListView<Button>();
		for (Button b : list) {
			root.getItems().add(b);
		}
				
		Scene newScene = new Scene(root);
		setScene(newScene);
	}
	
	public void setScene (Scene _scene) {
		CardGame.newStage.setScene(_scene);
		brdSuper.updateHand();
	}
	
	public void selectCard (AbstractCard c) {
		selectedCard = c;
		updateGraphics();
	}
	
	public void draw() {
		draw(1);
	}
	
	public void draw(int amount) {
		if (Deck.isEmpty()) {
			//TODO make discard shuffle into deck
		}
		for (int i = 0; i < amount; i++) {
			selectedCard = Deck.get(0);
			selectedCard.move(hand);
		}
	}
	
	public void move(ArrayList<AbstractCard> a) {
		selectedCard.move(a);
	}
	
	public void open (ArrayList<AbstractCard> toOpen) {
		open(toOpen, true);
	}
	
	public void open (ArrayList<AbstractCard> toOpen, boolean back) {
		Menu root = new Menu(toOpen, (event -> CardGame.setScene()), back);
		
		Scene newScene = new Scene(root);
		setScene(newScene);
	}
	
	//TODO rn this only play the card it has no restrictions to when you can play ideals
	
	public void play() {
		if (selectedCard != null && selectedCard.canPlay() && selectedCard.getLocation() == hand && selectedCard.getType() == CardType.ACTION) {
			selectedCard.move(discardPile);
			selectedCard.play();
			selectedCard = null;
			brdSuper.updateHand();
			updateGraphics();
		} 
	}
	
	public void discard() {
		if (selectedCard != null && selectedCard.canDiscard && selectedCard.getLocation() == hand && selectedCard.getType() == CardType.ACTION) {
			selectedCard.move(discardPile);
			selectedCard = null;
			brdSuper.updateHand();
			updateGraphics();
		}
	}
	
	public void setCardsUp () {
		for (AbstractCard c : Deck) {
			c.setOnAction(event -> selectCard(c));
			c.setPlayer(this);
		}
		if (Deck.size() < 20 || Deck.size() > 30) {
			System.out.print(name + "Deck size not between 20-30. Size:" + Deck.size() + "\n");
			Platform.exit();
		}
		for (AbstractCard c : fate) {
			c.setOnAction(event -> {
				if (ideal.isEmpty() && !((AbstractIdealCard) c).isDead()) {
					c.move(ideal);
					updateGraphics();
					CardGame.setScene();					
				}
			});
			c.setPlayer(this);
		}
		if (fate.size() < 20 || fate.size() > 30) {
			System.out.print(name + "Fate size not between 0-4. Size:" + fate.size() + "\n");
			Platform.exit();
		}
	}
	
	//TODO ask what happens if two there are two objects the override a method and that method is called at the same time
	public void nextPhase(Phases phase) {
		//TODO call card onNextPhase
		this.currentPhase = phase;
		updateGraphics();
	}
	
	public void updateGraphics() {
		//play button
		if (this.currentPhase == Phases.ACTIONSTEP && this.selectedCard != null && this.selectedCard.canPlay) {
			boardBtnBar.getChildren().get(2).setDisable(false);	
		} else {
			boardBtnBar.getChildren().get(2).setDisable(true);	
		}
		
		if (this.currentPhase == Phases.ACTIONSTEP && this.selectedCard != null && this.selectedCard.canDiscard) {
			boardBtnBar.getChildren().get(3).setDisable(false);;			
		} else {
			boardBtnBar.getChildren().get(3).setDisable(true);;			
		}
		if (!ideal.isEmpty()) {
			((Zone) brdSuper.getChildren().get(5)).setGraphic(ideal.get(0).getGraphic());
			((Zone) brdSuper.getChildren().get(5)).setStyle(ideal.get(0).getStyle());
		}
	}
	
	public void selectIdeal() {
		if (ideal.isEmpty()) {
			open(fate, false);			
		}
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

	public ArrayList<AbstractCard> getIdeal() {
		return ideal;
	}

	public void setIdeal(ArrayList<AbstractCard> ideal) {
		this.ideal = ideal;
	}

	public Player getOpponent() {
		return opponent;
	}

	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	
}
