package BigBoss;


import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import simpleIO.FXDialog;

public class BigBossGame extends Application {


	/*
	 * TODO selection screen
	 * 
	 * start
	 * asks what save you want to use
	 * if new chose char
	 * starts game
	 */
	
	Label title;
	Button btnSave1;
	Button btnSave2;
	Button btnSave3;
	VBox selectScreen;
	Label lblVolumeSlider;
	Label lblShowCharDescription;
	StackPane titleScreen;
	Slider volumeSlider;
	Save save1 = new Save(), save2 = new Save(), save3 = new Save(), selectedSave;
	TextField txtSaveName;
	Button btnCharSelectScreenSelect;
	HBox charSelectScreenAndDescription;
	GridPane preFightScreen;
	Label lblDisplayStats;
	
	//visual finals
	final int TITLE_GAP = 50;
	final int TITLE_POS = 160;
	final int IMAGE_WIDTH = 1126;
	final int IMAGE_HEIGHT = 634;
	final int TITLE_SIZE = 100;
	final String GAME_NAME = "Big Boss";
	final String FONT = "Comic Sans MS";
	final int BTN_FONT_SIZE = 50;
	final int BTN_WIDTH = 250;
	final int BTN_HEIGHT = 50;
	final int MENU_WIDTH = 400;
	final int MENU_HEIGHT = 500;
	final int MENU_FONT_SIZE = 30;
	final int CHECK_BOX_SIZE = 50;
	final int MENU_GAP = 10;
	final int SELECT_BTN_WIDTH = 400;
	final int SELECT_BTN_HEIGHT = 150;
	final int SAVE_NAME_TXT_SIZE = 200;
	final int TEXT_FONT_SIZE = 20;


	//inner finals
	final double SLOW_ANIMATION_SPEED = 1;
	final double FAST_ANIMATION_SPEED = 0.25;
	
	
	//inner variables
	int timer = 0;
	AbstractCharecter selectedCharecter;
	double animationSpeedMultiplyer = SLOW_ANIMATION_SPEED;
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		StackPane root = new StackPane();
		root.setMaxSize(IMAGE_WIDTH, IMAGE_HEIGHT);
		
		//background images
		ImageView background = new ImageView(new Image(getClass().getResource("/images/Background8Bit.png").toString()));
		ImageView background2 = new ImageView(new Image(getClass().getResource("/images/Background8Bit.png").toString()));
		//background animation
		TranslateTransition trans1 = new TranslateTransition(Duration.seconds(10), background);
	    trans1.setFromX(0);
	    trans1.setToX(IMAGE_WIDTH);
	    trans1.setInterpolator(Interpolator.LINEAR);
	    trans1.setCycleCount(Animation.INDEFINITE);
	    TranslateTransition trans2 = new TranslateTransition(Duration.seconds(10), background2);
	    trans2.setFromX(-IMAGE_WIDTH);
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
	    pathTransition.setDuration(Duration.seconds(1 * animationSpeedMultiplyer));
	    pathTransition.setNode(title);
	    pathTransition.setPath(path);
	    pathTransition.setOrientation(OrientationType.NONE);
	    pathTransition.setCycleCount(Animation.INDEFINITE);
	    pathTransition.setAutoReverse(true);
	    pathTransition.play();
	    
	    
	    //charecter selection screen
	    VBox charSelectScreen = new VBox();
	    charSelectScreen.setMaxSize(MENU_WIDTH, MENU_HEIGHT);
	    
	    //back button and select button
	    HBox selectAndBackBtns = new HBox();
	    Label lblName = new Label("Save Name:");
	    lblName.setFont(Font.font(FONT, MENU_FONT_SIZE));
	    Button btnCharSelectScreenBack = new Button("Back");
	    btnCharSelectScreenBack.setFont(Font.font(FONT, MENU_FONT_SIZE));
	    btnCharSelectScreenBack.setOnAction(event -> backMenu(charSelectScreenAndDescription));
	    selectAndBackBtns.getChildren().addAll(btnCharSelectScreenBack, lblName);

	    HBox saveNamingLine = new HBox();
	    btnCharSelectScreenSelect = new Button("Select");
	    btnCharSelectScreenSelect.setDisable(true);
	    btnCharSelectScreenSelect.setFont(Font.font(FONT, MENU_FONT_SIZE));
	    txtSaveName = new TextField();
	    txtSaveName.setPrefWidth(SAVE_NAME_TXT_SIZE);
	    txtSaveName.setFont(Font.font(FONT, MENU_FONT_SIZE));
	    txtSaveName.setOnKeyTyped(event -> updateSelectButton());
	    saveNamingLine.getChildren().addAll(txtSaveName, btnCharSelectScreenSelect);

	    
	    Button selectMrBasic = new Button("Mr. Basic");
	    selectMrBasic.setOnAction(event -> setSelectedCharecter(new MrBasic()));
	    selectMrBasic.setFont(Font.font(FONT, MENU_FONT_SIZE));

	    charSelectScreen.getChildren().addAll(selectAndBackBtns, saveNamingLine, selectMrBasic);

	    charSelectScreenAndDescription = new HBox();
	    StackPane.setMargin(charSelectScreenAndDescription, new Insets(MENU_GAP, MENU_GAP, MENU_GAP, MENU_GAP));
	    charSelectScreenAndDescription.setVisible(false);
	    charSelectScreenAndDescription.setMaxSize(MENU_WIDTH * 2, MENU_HEIGHT * 2);
	    lblShowCharDescription = new Label("");
	    charSelectScreenAndDescription.getChildren().addAll(charSelectScreen, lblShowCharDescription);
	    
	    
	    //Save selection screen
	    selectScreen = new VBox();
	    selectScreen.setVisible(false);
	    selectScreen.setMaxSize(MENU_WIDTH, MENU_HEIGHT);
	    
	    //back button
	    Button btnSelectScreenBack = new Button("Back");
	    btnSelectScreenBack.setFont(Font.font(FONT, MENU_FONT_SIZE));
	    btnSelectScreenBack.setOnAction(event -> backMenu(selectScreen));
	    
	    btnSave1 = new Button(save1.getName());
	    btnSave1.setFont(Font.font(FONT, MENU_FONT_SIZE));
	    btnSave1.setPrefSize(SELECT_BTN_WIDTH, SELECT_BTN_HEIGHT);
	    btnSave1.setOnAction(event -> selectSave(save1));
	    VBox.setMargin(btnSave1, new Insets(MENU_GAP, MENU_GAP, MENU_GAP, MENU_GAP));
	    
	    btnSave2 = new Button(save2.getName());
	    btnSave2.setFont(Font.font(FONT, MENU_FONT_SIZE));
	    btnSave2.setPrefSize(SELECT_BTN_WIDTH, SELECT_BTN_HEIGHT);
	    btnSave2.setOnAction(event -> selectSave(save2));
	    VBox.setMargin(btnSave2, new Insets(MENU_GAP, MENU_GAP, MENU_GAP, MENU_GAP));
	    
	    btnSave3 = new Button(save3.getName());
	    btnSave3.setFont(Font.font(FONT, MENU_FONT_SIZE));
	    btnSave3.setPrefSize(SELECT_BTN_WIDTH, SELECT_BTN_HEIGHT);
	    btnSave3.setOnAction(event -> selectSave(save3));
	    VBox.setMargin(btnSave3, new Insets(MENU_GAP, MENU_GAP, MENU_GAP, MENU_GAP));

	    btnCharSelectScreenSelect.setOnAction(event -> wrightSave());
	    
	    selectScreen.getChildren().addAll(btnSelectScreenBack, btnSave1, btnSave2, btnSave3);
	    
	    //preFight screen
	    preFightScreen = new GridPane();
	    preFightScreen.setVgap(MENU_GAP);
	    preFightScreen.setHgap(MENU_GAP);
	    preFightScreen.setPadding(new Insets(MENU_GAP, MENU_GAP, MENU_GAP, MENU_GAP));
	    preFightScreen.setVisible(false);
	    preFightScreen.setMaxSize(IMAGE_WIDTH, IMAGE_HEIGHT);
	    preFightScreen.setMinSize(IMAGE_WIDTH, IMAGE_HEIGHT);

	    VBox fightSection = new VBox();

	    Button btnFight = new Button("FIGHT!");
	    btnFight.setPrefSize(BTN_WIDTH, BTN_HEIGHT);
	    btnFight.setFont(Font.font(FONT, BTN_FONT_SIZE));
	    btnFight.setOnAction(event -> nextMenu(titleScreen, selectScreen)); //TODO set this to go to the fight screen once its done
	    
	    //back button
	    Button btnPreFightBack = new Button("Back");
	    btnPreFightBack.setFont(Font.font(FONT, MENU_FONT_SIZE));
	    btnPreFightBack.setOnAction(event -> backMenu(preFightScreen));
	    
	    VBox statsSection = new VBox();
	    
	    Button btnEditStats = new Button("Stats");
	    btnEditStats.setFont(Font.font(FONT, BTN_FONT_SIZE));
	    btnEditStats.setOnAction(event -> nextMenu(titleScreen, selectScreen)); //TODO set this once its done
	    
	    lblDisplayStats = new Label();
	    lblDisplayStats.setFont(Font.font(FONT, TEXT_FONT_SIZE));
	    
	    fightSection.getChildren().addAll(btnFight, btnPreFightBack);
	    statsSection.getChildren().addAll(btnEditStats, lblDisplayStats);
	    preFightScreen.add(fightSection, 0, 0);
	    preFightScreen.add(statsSection, 1, 0);
	    
	    
	    //options screen
	    VBox optionsScreen = new VBox();
	    optionsScreen.setVisible(false);
	    optionsScreen.setMaxSize(MENU_WIDTH, MENU_HEIGHT);
	    
	    //back button
	    Button btnOptionsScreenBack = new Button("Back");
	    btnOptionsScreenBack.setFont(Font.font(FONT, MENU_FONT_SIZE));
	    btnOptionsScreenBack.setOnAction(event -> backMenu(optionsScreen));
	    
	    //fast animations option
	    HBox fastAnimationsOption = new HBox();
	    Label lblSpeedyAnimations = new Label("Speedy Animations");
	    lblSpeedyAnimations.setFont(Font.font(FONT, MENU_FONT_SIZE));
	    HBox.setMargin(lblSpeedyAnimations, new Insets(MENU_GAP, MENU_GAP, MENU_GAP, MENU_GAP));
	    CheckBox cbFastAnimations = new CheckBox();
	    cbFastAnimations.setPrefSize(CHECK_BOX_SIZE, CHECK_BOX_SIZE);
	    cbFastAnimations.setOnAction(event -> changeAnimationSpeed());
	    HBox.setMargin(cbFastAnimations, new Insets(MENU_GAP, MENU_GAP, MENU_GAP, MENU_GAP));
	    fastAnimationsOption.getChildren().addAll(lblSpeedyAnimations, cbFastAnimations);
	    
	    //volume slider
	    HBox volumeOption = new HBox();
	    lblVolumeSlider = new Label("Volume (100%)");
	    lblVolumeSlider.setMaxWidth(225);
	    lblVolumeSlider.setMinWidth(225);
	    lblVolumeSlider.setFont(Font.font(FONT, MENU_FONT_SIZE));
	    HBox.setMargin(lblVolumeSlider, new Insets(MENU_GAP, MENU_GAP, MENU_GAP, MENU_GAP));
	    volumeSlider = new Slider(0, 200, 100);
	    volumeSlider.setOnMouseDragged(event -> changeVolume());
	    HBox.setMargin(volumeSlider, new Insets(MENU_GAP * 2.5, MENU_GAP, MENU_GAP, MENU_GAP));
	    volumeOption.getChildren().addAll(lblVolumeSlider, volumeSlider);
	    
	    
	    //adding all to the options screen
	    optionsScreen.getChildren().addAll(btnOptionsScreenBack, fastAnimationsOption, volumeOption);
	    
	    
	    
	    //titleScreen
	    titleScreen = new StackPane();
	    
	    Button btnPlay = new Button("Play");
	    btnPlay.setPrefSize(BTN_WIDTH, BTN_HEIGHT);
	    btnPlay.setFont(Font.font(FONT, BTN_FONT_SIZE));
	    btnPlay.setOnAction(event -> nextMenu(titleScreen, selectScreen));
	    titleScreen.getChildren().addAll(btnPlay);
	    
	    Button btnOptions = new Button("Options");
	    btnOptions.setPrefSize(BTN_WIDTH, BTN_HEIGHT);
	    StackPane.setMargin(btnOptions, new Insets(158, 158, 158, 158));
	    StackPane.setAlignment(btnOptions, Pos.BOTTOM_CENTER);
	    btnOptions.setFont(Font.font(FONT, BTN_FONT_SIZE));
	    btnOptions.setOnAction(event -> nextMenu(titleScreen, optionsScreen));
	    titleScreen.getChildren().addAll(btnOptions);
	    
	    Button btnExit = new Button("Exit");
	    btnExit.setPrefSize(BTN_WIDTH, BTN_HEIGHT);
	    StackPane.setMargin(btnExit, new Insets(BTN_HEIGHT, BTN_HEIGHT, BTN_HEIGHT, BTN_HEIGHT));
	    StackPane.setAlignment(btnExit, Pos.BOTTOM_CENTER);
	    btnExit.setFont(Font.font(FONT, BTN_FONT_SIZE));
	    btnExit.setOnAction(event -> Platform.exit());
	    titleScreen.getChildren().addAll(btnExit);
	    
	    titleScreen.getChildren().add(title);
	    
	    //adding all nodes to pane
	    root.getChildren().addAll(background, background2, titleScreen, selectScreen, optionsScreen, charSelectScreenAndDescription, preFightScreen);
	    
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.setResizable(false);
	    stage.show();
	}
	
	public void nextMenu(Node screen, Node newScreen) {
		newScreen.setVisible(true);
		TranslateTransition buttonsTrans2 = new TranslateTransition(Duration.seconds(1.25 * animationSpeedMultiplyer), screen);
		buttonsTrans2.setFromY(-100);
		buttonsTrans2.setToY(1000);
		buttonsTrans2.setCycleCount(1);
		buttonsTrans2.setOnFinished(event -> {
			screen.setLayoutY(1000);
		});
		TranslateTransition buttonsTrans1 = new TranslateTransition(Duration.seconds(.75 * animationSpeedMultiplyer), screen);
		buttonsTrans1.setFromY(0);
		buttonsTrans1.setToY(-100);
		buttonsTrans1.setCycleCount(1);
		buttonsTrans1.setOnFinished(event -> {
			buttonsTrans2.play();
		});
		
		TranslateTransition newSceneTrans = new TranslateTransition(Duration.seconds(2 * animationSpeedMultiplyer), newScreen);
		newSceneTrans.setFromY(-1000);
		newSceneTrans.setToY(0);
		newSceneTrans.setCycleCount(1);
		newSceneTrans.setOnFinished(event -> {
			newScreen.setLayoutY(0);
		});
		
		ParallelTransition parTrans = new ParallelTransition(newSceneTrans, buttonsTrans1);
		parTrans.play();
	}
	
	public void backMenu (Node n) {
		TranslateTransition buttonsTrans = new TranslateTransition(Duration.seconds(2 * animationSpeedMultiplyer), titleScreen);
		buttonsTrans.setFromY(1000);
		buttonsTrans.setToY(0);
		buttonsTrans.setCycleCount(1);
		buttonsTrans.setOnFinished(event -> {
			titleScreen.setLayoutY(0);
		});
		
		TranslateTransition newSceneTrans = new TranslateTransition(Duration.seconds(2 * animationSpeedMultiplyer), n);
		newSceneTrans.setFromY(titleScreen.getLayoutY());
		newSceneTrans.setToY(-1000);
		newSceneTrans.setCycleCount(1);
		newSceneTrans.setOnFinished(event -> {
			n.setLayoutY(-1000);
		});
		
		ParallelTransition parTrans = new ParallelTransition(newSceneTrans, buttonsTrans);
		parTrans.play();
	}
	
	public void changeAnimationSpeed () {
		if (animationSpeedMultiplyer == SLOW_ANIMATION_SPEED) {
			animationSpeedMultiplyer = FAST_ANIMATION_SPEED;
		} else {
			animationSpeedMultiplyer = SLOW_ANIMATION_SPEED;

		}
	}
	
	public void changeVolume() {
		lblVolumeSlider.setText("Volume (" + ((int)volumeSlider.getValue()) + "%)" );
	}
	
	public void setSelectedCharecter(AbstractCharecter charecter) {
		selectedCharecter = charecter;
		updateSelectButton();
		lblShowCharDescription.setText("");
		FileReader description;
		BufferedReader descriptionReader;
		String line;
		
		try {
			description = new FileReader("data/" + charecter.getName() + "Description.txt");
			descriptionReader = new BufferedReader(description);

			//Continues until file is empty
			while ((line = descriptionReader.readLine()) != null) {
				lblShowCharDescription.setText(lblShowCharDescription.getText() + line + "\n");
			}

		} catch (FileNotFoundException e) {
			System.out.print("No file was found: " + e.getMessage());
		} catch (IOException e) {
			System.out.print("Error reading file: " + e.getMessage());
		}
	}
	
	public void selectSave (Save save) {
		if (save.getIsEmpty()) {
    		lblShowCharDescription.setText("");
    		selectedSave = save;
    		
    		nextMenu(selectScreen, charSelectScreenAndDescription);
    	} else {
    		switch(FXDialog.chooseOption("What would you like to do?", "Play", "Delete")) {
    		case"Play" :
        		selectedSave = save;
        		updatePreFightScreen();
    			nextMenu(selectScreen, preFightScreen);
    			break;
    		case"Delete" :
    			save.clear();
    			updateButtonNames();
    			break;
    		}
    	}
	}
	
	public void updatePreFightScreen () {
		lblDisplayStats.setText(selectedSave.getCharecter().getStatsAsString() + "dlkgjskdbgkjsdhgkjsdglkjdhslgkjsdlkgjhldkfjhglk");
	}
	
	public void wrightSave () {
		nextMenu(charSelectScreenAndDescription, selectScreen);
		selectedSave.setIsEmpty(false);
		selectedSave.setCharecter(selectedCharecter);
		selectedSave.setName(txtSaveName.getText() + "\n" + selectedCharecter.getName());
		txtSaveName.setText("");
		btnCharSelectScreenSelect.setDisable(true);
		selectedCharecter = null;
		updateButtonNames();
	}
	
	public void updateSelectButton () {
		if (!txtSaveName.getText().equals("") && selectedCharecter != null) {
    	    btnCharSelectScreenSelect.setDisable(false);
    	} else {
    	    btnCharSelectScreenSelect.setDisable(true);
    	}
	}
	
	public void updateButtonNames() {
		btnSave1.setText(save1.getName());
		btnSave2.setText(save2.getName());
		btnSave3.setText(save3.getName());
	}
	
	@Override
	public void stop() throws Exception {
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
