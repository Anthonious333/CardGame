package reactionTimeGame;

import java.util.Timer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TimingGame extends Application {
	
	int width = 20;
	int length = 10;

	int font = 50;
	
	int boxSize = 100;
	
	long start = System.currentTimeMillis();
		
	Button btnReation = new Button("CLICK! ME!");
	GridPane root = new GridPane();
	Button btnStart = new Button("Start");
	Label lblTime = new Label("gfdbkjhdfbdufgb ksduku uybku ybgaszfdhHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");

	@Override
	public void start(Stage stage) throws Exception {
		
		btnReation.setOnAction(event -> newReact());
		btnReation.setPrefSize(boxSize, boxSize);
		btnStart.setOnAction(event -> start());
		btnStart.setPrefSize(boxSize * width, boxSize * length);
		btnStart.setFont(Font.font(font));
		root.add(btnStart, 0, 0);
		
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Timing Game");
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("GoodLuck!");
		stage.show();
	}
	
	public void start () {
		root.getChildren().remove(btnStart);
		root.add(lblTime, 0, length, width, 1);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < length; y++) {
				Button btn = new Button();
				btn.setPrefSize(boxSize, boxSize);
				root.add(btn, x, y);
			}
		}
		newReact();
	}
	
	public void newReact() {
		if(root.getChildren().remove(btnReation)) {
			lblTime.setText("you timed " + (System.currentTimeMillis() - start) / 1000.0 + " Seconds!");
		}
		start =  System.currentTimeMillis();
		root.add(btnReation, randomNumber(0, width - 1), randomNumber(0, length - 1));
	}
	
	private static int randomNumber(int a, int b) {
		int highNum = Math.max(a, b);
		int lowNum = Math.min(a, b);
		int range = highNum - lowNum + 1;
		return (int) (Math.random() * range) + lowNum;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
