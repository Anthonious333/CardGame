package tests;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class fg extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
//		TreeItem<Button> root = new TreeItem<Button>(new Button("Start"));
//		
//		TreeView<Button> treeView = new TreeView<Button>(root);
//		
//		TreeItem<Button> path1 = new TreeItem<Button>(new Button("path1"));
//		TreeItem<Button> path2 = new TreeItem<Button>(new Button("path2"));
//		TreeItem<Button> path3 = new TreeItem<Button>(new Button("path3"));
//		
//		TreeItem<Button> path1op1 = new TreeItem<Button>(new Button("path1op1"));
//		TreeItem<Button> path1op2 = new TreeItem<Button>(new Button("path1op2"));
//		TreeItem<Button> path1op3 = new TreeItem<Button>(new Button("path1op3"));
//		path1.getChildren().addAll(path1op1, path1op2, path1op3);
//
//		TreeItem<Button> path2op1 = new TreeItem<Button>(new Button("path2op1"));
//		TreeItem<Button> path2op2 = new TreeItem<Button>(new Button("path2op2"));
//		TreeItem<Button> path2op3 = new TreeItem<Button>(new Button("path2op3"));
//		path2.getChildren().addAll(path2op1, path2op2, path2op3);
//		
//		TreeItem<Button> path3op1 = new TreeItem<Button>(new Button("path3op1"));
//		TreeItem<Button> path3op2 = new TreeItem<Button>(new Button("path3op2"));
//		TreeItem<Button> path3op3 = new TreeItem<Button>(new Button("path3op3"));
//		path3.getChildren().addAll(path3op1, path3op2, path3op3);
//
//		root.getChildren().addAll(path1, path2, path3);

		
		Group group = new Group();
		
		Button btn1 = new Button("Button");
		Button btn2 = new Button("Button");
		Button btn3 = new Button("Button");
		Button btn4 = new Button("Button");

		Line line1 = new Line(0, 0, 0, 100);
		Line line2 = new Line(0, 0, 0, 100);
		Line line3 = new Line(0, 0, 0, 100);

		line1.setLayoutX(100);
		line1.setLayoutY(100);
		line2.setLayoutX(100);
		line2.setLayoutY(300);
		line3.setLayoutX(100);
		line3.setLayoutY(500);

		btn1.setPrefSize(100, 100);
		btn2.setPrefSize(100, 100);
		btn3.setPrefSize(100, 100);
		btn4.setPrefSize(100, 100);
		
		btn1.setLayoutX(50);
		btn1.setLayoutY(0);
		btn2.setLayoutX(50);
		btn2.setLayoutY(200);
		btn3.setLayoutX(50);
		btn3.setLayoutY(400);
		btn4.setLayoutX(50);
		btn4.setLayoutY(600);
		
		group.getChildren().addAll(btn1, btn2, btn3, btn4, line1, line2, line3);
		
		Scene scene = new Scene(group, 200, 700);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
