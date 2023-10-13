package gitsAndShiggels;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class CardGame extends Application {
	
	static final int GAP = 15;

	@Override
	public void start(Stage myStage) throws Exception {
		// TODO Auto-generated method stub
		GridPane root = new GridPane();
		root.setHgap(GAP);
		root.setVgap(GAP);
		root.setPadding(new Insets(GAP, GAP, GAP, GAP));
		
		Zone zone1 = new Zone();
		root.add(zone1, 0, 0);
		Rectangle topBlank = new Rectangle(200, 200, Color.WHITE);
		root.add(topBlank, 1, 0);
		Zone zone2 = new Zone();
		root.add(zone2, 2, 0);
		Zone zone3 = new Zone(200, 250);
		root.add(zone3, 0, 1);
		Rectangle botBlank = new Rectangle(200, 150, Color.WHITE);
		root.add(botBlank, 1, 1);
		Zone zone4 = new Zone();
		root.add(zone4, 2, 1);
		
		Scene scene = new Scene(root);
		
		myStage.setTitle("Card Game");
		myStage.setScene(scene);
		myStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
