package BigBoss;


import java.awt.Toolkit;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BigBossGame extends Application {


	/*
	 * TODO selection screen
	 * 
	 * start
	 * asks what save you want to use
	 * if new chose char
	 * starts game
	 * 
	 * options
	 * volume 
	 * speedy animations
	 * ...
	 * 
	 * exit
	 */
	
	Label title;
	
	//visual variables
	final int TITLE_GAP = 50;
	final int TITLE_POS = 160;
	final int IMAGE_GAP = 1126;
	final int TITLE_SIZE = 100;
	final String GAME_NAME = "Big Boss";
	final String FONT = "Comic Sans MS";
	final int BTN_FONT_SIZE = 50;
	final int BTN_SIZE = 50;
	
	//inner variables
	int timer = 0;
	final int TITLE_MOVE_TIME = 100;
	boolean titleMoveUp = false;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		StackPane root = new StackPane();
		root.setMaxSize(Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		
		//background images
		ImageView background = new ImageView(new Image(getClass().getResource("/images/Background8Bit.jpg").toString(), 1126, 634, false, false));
		ImageView background2 = new ImageView(new Image(getClass().getResource("/images/Background8Bit.jpg").toString(), 1126, 634, false, false));
		//background animation
		TranslateTransition trans1 = new TranslateTransition(Duration.seconds(10), background);
	    trans1.setFromX(0);
	    trans1.setToX(IMAGE_GAP);
	    trans1.setInterpolator(Interpolator.LINEAR);
	    trans1.setCycleCount(Animation.INDEFINITE);
	    TranslateTransition trans2 = new TranslateTransition(Duration.seconds(10), background2);
	    trans2.setFromX(-IMAGE_GAP);
	    trans2.setToX(0);
	    trans2.setCycleCount(Animation.INDEFINITE);
	    trans2.setInterpolator(Interpolator.LINEAR);
	    ParallelTransition parTrans = new ParallelTransition(trans1, trans2);
	    parTrans.play();
		
	    //title
	    title = new Label(GAME_NAME);
	    title.setFont(Font.font(FONT, TITLE_SIZE));
	    StackPane.setAlignment(title, Pos.TOP_CENTER);
	    StackPane.setMargin(title, new Insets(TITLE_GAP, TITLE_GAP, TITLE_GAP, TITLE_GAP));
	    //title animation 
	    Path path = new Path();
	    path.getElements().add (new MoveTo (TITLE_POS, 70));
	    path.getElements().add (new LineTo (TITLE_POS + 100, 30));
	    PathTransition pathTransition = new PathTransition();
	    pathTransition.setDuration(Duration.millis(1000));
	    pathTransition.setNode(title);
	    pathTransition.setPath(path);
	    pathTransition.setOrientation(OrientationType.NONE);
	    pathTransition.setCycleCount(Animation.INDEFINITE);
	    pathTransition.setAutoReverse(true);
	    pathTransition.play();

	    
	    StackPane buttons = new StackPane();
	    
	    Button btnPlay = new Button("Play");
	    btnPlay.setPrefSize(BTN_SIZE * 5, BTN_SIZE);
	    btnPlay.setFont(Font.font(FONT, BTN_FONT_SIZE));
	    buttons.getChildren().addAll(btnPlay);
	    
	    Button btnOptions = new Button("Options");
	    btnOptions.setPrefSize(BTN_SIZE * 5, BTN_SIZE);
	    StackPane.setMargin(btnOptions, new Insets(158, 158, 158, 158));
	    StackPane.setAlignment(btnOptions, Pos.BOTTOM_CENTER);
	    btnOptions.setFont(Font.font(FONT, BTN_FONT_SIZE));
	    buttons.getChildren().addAll(btnOptions);
	    
	    Button btnExit = new Button("Exit");
	    btnExit.setPrefSize(BTN_SIZE * 5, BTN_SIZE);
	    StackPane.setMargin(btnExit, new Insets(BTN_SIZE, BTN_SIZE, BTN_SIZE, BTN_SIZE));
	    StackPane.setAlignment(btnExit, Pos.BOTTOM_CENTER);
	    btnExit.setFont(Font.font(FONT, BTN_FONT_SIZE));
	    btnExit.setOnAction(event -> Platform.exit());
	    buttons.getChildren().addAll(btnExit);
	    
	    //adding all nodes to pane
	    root.getChildren().addAll(background, background2, title, buttons);
	    
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.setResizable(false);
	    stage.show();
	}
	
	@Override
	public void stop() throws Exception {
		
	}
	

	public static void main(String[] args) {
		launch(args);
	}

}
