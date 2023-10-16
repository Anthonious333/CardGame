package gitsAndShiggels;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Menu extends GridPane{
	
	Button back = new Button("Back");
	
	public Menu (Button[] options, Scene oldScene) {
		for (int i = 0; i < options.length; i++) {
			this.add(options[i], i, 0);
		}
		this.add(back, options.length, 0);
		back.setOnAction(event -> back(oldScene));
	}
	
	public void back (Scene oldScene) {
		CardGame.newStage.setScene(oldScene);
	}
}
