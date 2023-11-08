package gitsAndShiggels;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Menu extends GridPane{
	
	Button btnBack = new Button("Back");
	Button btnNext = new Button("Next");
	
	//this is both the options provided when playing a card and the options of cards to select when you are looking in a pile
	ArrayList<AbstractCard> options;
	
	Scene oldScene;
	int startPoint, pointOffset = 10;
	boolean next = false, back = true;
	
	public Menu (ArrayList<AbstractCard> options, Scene oldScene, int startPoint) {
		this.options = options;
		this.oldScene = oldScene;
		this.startPoint = startPoint;
		generateMenu();
	}
	
	public Menu (ArrayList<AbstractCard> options, Scene oldScene) {
		this.options = options;
		this.oldScene = oldScene;
		this.startPoint = 0;
		generateMenu();
	}
	
	public void generateMenu () {
		for (int i = startPoint; i < options.size() && i < pointOffset + startPoint; i++) {
			this.add(options.get(i), i, 0);
			if (i == pointOffset + startPoint - 1) {
				next = true;
			}
		}
		if (back) {
			this.add(btnBack, options.size(), 0);
			btnBack.setOnAction(event -> back(oldScene));			
		}
		if (next) { 			
			this.add(btnNext, options.size() + 1, 0);
			btnNext.setOnAction(event -> next());
		}
		
	}
	public void back (Scene oldScene) {
		CardGame.newStage.setScene(oldScene);
	}
	
	public void play (Button card) {
		((AbstractCard)card).move(CardGame.discardPile, this.options);
	}
	
	public void next () {
		Menu root = new Menu(options, CardGame.newStage.getScene(), startPoint + pointOffset);
		Scene scene = new Scene(root);
		CardGame.newStage.setScene(scene);
	}
}
