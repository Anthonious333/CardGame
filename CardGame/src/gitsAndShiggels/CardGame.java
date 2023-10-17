package gitsAndShiggels;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class CardGame extends Application {
	
	static final int GAP = 15;
	Scene scene;
	static Stage newStage;

	@Override
	public void start(Stage myStage) throws Exception {
		newStage = myStage;
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
		Zone zone3 = new Zone();
		root.add(zone3, 0, 1);
		Rectangle botBlank = new Rectangle(200, 200, Color.WHITE);
		root.add(botBlank, 1, 1);
		Zone zone4 = new Zone();
		zone4.setText("Zone 4");
		zone4.setOnAction(event -> changeScene());
		root.add(zone4, 2, 1);
		
		scene = new Scene(root);
		
		myStage.setTitle("Card Game");
		myStage.setScene(scene);
		myStage.show();
	}
	

	public void changeScene () {
		Button[] btnArray = {new Button(),new Button(), new Button()};
		Image buddyPicture = new Image(getClass().getResource("/images/buddy.png").toString());
		ImageView imgBuddy = new ImageView(buddyPicture);
		btnArray[0].setGraphic(imgBuddy);
		Menu root = new Menu(btnArray, newStage.getScene());
		
		Scene newScene = new Scene(root);
		setScene(newScene);
		
	}
	
	public void setScene (Scene _scene) {
		newStage.setScene(_scene);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
