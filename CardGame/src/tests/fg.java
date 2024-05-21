package tests;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

public class fg extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		TreeItem<Button> root = new TreeItem<Button>(new Button("Start"));
		
		TreeView<Button> treeView = new TreeView<Button>(root);
		
		TreeItem<Button> path1 = new TreeItem<Button>(new Button("path1"));
		TreeItem<Button> path2 = new TreeItem<Button>(new Button("path2"));
		TreeItem<Button> path3 = new TreeItem<Button>(new Button("path3"));
		
		TreeItem<Button> path1op1 = new TreeItem<Button>(new Button("path1op1"));
		TreeItem<Button> path1op2 = new TreeItem<Button>(new Button("path1op2"));
		TreeItem<Button> path1op3 = new TreeItem<Button>(new Button("path1op3"));
		path1.getChildren().addAll(path1op1, path1op2, path1op3);

		TreeItem<Button> path2op1 = new TreeItem<Button>(new Button("path2op1"));
		TreeItem<Button> path2op2 = new TreeItem<Button>(new Button("path2op2"));
		TreeItem<Button> path2op3 = new TreeItem<Button>(new Button("path2op3"));
		path2.getChildren().addAll(path2op1, path2op2, path2op3);
		
		TreeItem<Button> path3op1 = new TreeItem<Button>(new Button("path3op1"));
		TreeItem<Button> path3op2 = new TreeItem<Button>(new Button("path3op2"));
		TreeItem<Button> path3op3 = new TreeItem<Button>(new Button("path3op3"));
		path3.getChildren().addAll(path3op1, path3op2, path3op3);

		root.getChildren().addAll(path1, path2, path3);

		Scene scene = new Scene(treeView);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
