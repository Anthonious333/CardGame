package BigBoss;

import java.awt.Insets;
import java.awt.Toolkit;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BigBossGame extends Application {


	/*
	 * TODO selection screen
	 * background
	 * with animations - scrolling 
	 * 
	 * title
	 * add animations to it 
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
	
	ImageView background = new ImageView(new Image(getClass().getResource("/images/Background8Bit.jpg").toString(), 1126, 634, false, false));
	ImageView background2 = new ImageView(new Image(getClass().getResource("/images/Background8Bit.jpg").toString(), 1126, 634, false, false));
	

	int imageGap = 1126;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		StackPane root = new StackPane();
		root.setMaxSize(Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		
		TranslateTransition trans1 = new TranslateTransition(Duration.seconds(10), background);
	    trans1.setFromX(0);
	    trans1.setToX(imageGap);
	    trans1.setInterpolator(Interpolator.LINEAR);
	    trans1.setCycleCount(Animation.INDEFINITE);
	    TranslateTransition trans2 = new TranslateTransition(Duration.seconds(10), background2);
	    trans2.setFromX(-imageGap);
	    trans2.setToX(0);
	    trans2.setCycleCount(Animation.INDEFINITE);
	    trans2.setInterpolator(Interpolator.LINEAR);
	    ParallelTransition parTrans = new ParallelTransition(trans1, trans2);
	    parTrans.play();
		
	    Label title = new Label("Title");
	    title.setFont(Font.font(100));
	    StackPane.setAlignment(title, Pos.TOP_CENTER);
	    root.getChildren().addAll(background, background2, title);
	    
	    
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.setResizable(false);
	    stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
