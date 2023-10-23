package gitsAndShiggels;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Menu extends GridPane{
	
	Button btnBack = new Button("Back");
	Button btnNext = new Button("Next");
	Button[] options;
	Scene oldScene;
	int startPoint, pointOffset = 10;
	boolean next = false, back = true;
	
	public Menu (Button[] options, Scene oldScene) {
		this.options = options;
		this.oldScene = oldScene;
		this.startPoint = 0;
		generateMenu();
	}
	
	public Menu (Button[] options, Scene oldScene, int startPoint, int pointOffset, boolean back) {
		this.options = options;
		this.oldScene = oldScene;
		this.startPoint = startPoint;
		this.pointOffset = pointOffset;
		this.back = back;
		generateMenu();
	}
	
	public Menu (Button[] options, Scene oldScene, int startPoint) {
		this.options = options;
		this.oldScene = oldScene;
		this.startPoint = startPoint;
		generateMenu();
	}
	
	public void generateMenu () {
		for (int i = startPoint; i < options.length && i < pointOffset + startPoint; i++) {
			this.add(options[i], i, 0);
			if (i == pointOffset + startPoint - 1) {
				next = true;
			}
		}
		if (back) {
			this.add(btnBack, options.length, 0);
			btnBack.setOnAction(event -> back(oldScene));			
		}
		if (next) { 			
			this.add(btnNext, options.length + 1, 0);
			btnNext.setOnAction(event -> next());
		}
		
	}
	public void back (Scene oldScene) {
		CardGame.newStage.setScene(oldScene);
	}
	
	public void next () {
		Menu root = new Menu(options, CardGame.newStage.getScene(), startPoint + pointOffset);
		Scene scene = new Scene(root);
		CardGame.newStage.setScene(scene);
	}
}
