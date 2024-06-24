package BigBoss;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import BigBoss.Characters.BossEnemy;
import BigBoss.Characters.MrBasic;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import simpleIO.FXDialog;

public class BigBossGame1 extends Application {


	/*
	 * TODO fix slot machine not selecting the right ability
	 * 
	 * TODO finish Mr Basic
	 * 
	 * TODO add sounds - hit / block / effect
	 *  
	 * TODO add the thing that whrights to a save
	 * 
	 * add highlights to buttons when you have shit to spend
	 * 
	 * add a button on top of the lever on the slot machine to pull slots
	 *  
	 * add attack animations // maybe
	 * 
	 * fix all menus look nicer - the player fight options need to be on a scroll pane / in a line again
	 * 
	 * make buttons look mroe 8bit
	 * 
	 * make diologe better // add punctuation and names to things // change font ot look more rustic/8bit
	 * 
	 * add totorial
	 * 
	 * add ability to see enemy and your mods and skills and attacks 
	 */
	
	//Global objects
	StackPane root;
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
	AnchorPane preFightScreen;
	Label lblDisplayStats;
	Label lblDisplayAbilities;
	Label lblDisplayMods;
	ImageView mainBackgroundV;
	ImageView mainBackgroundV2; 
	ParallelTransition backgroundParallelTrans;
	Image mainBackgroundI = new Image(getClass().getResource("/images/Background8Bit.png").toString());
	Image mainBackgroundI2 = new Image(getClass().getResource("/images/Background8Bit.png").toString());
	Image fightBackgroundI = new Image(getClass().getResource("/images/fight room.png").toString());
	Pane fightDisplayPane = new Pane();
	MediaPlayer buttonClickSound = new MediaPlayer(new Media(getClass().getResource("/sounds/KeyBoardSFX1.mp3").toString()));
	MediaPlayer bossTheme = new MediaPlayer(new Media(getClass().getResource("/sounds/BossTheme.mp3").toString()));
	MediaPlayer mainTheme = new MediaPlayer(new Media(getClass().getResource("/sounds/MainTheme.mp3").toString()));

	
	//Visual finals
	final int TITLE_GAP = 50;
	final int TITLE_POS = 160;
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
	final int MOD_BUTTON_SIZE = 100;
	final int MOD_GAP = 100;
	final int PREFIGHT_TEXT_SIZE = 50;


	//Inner finals
	final double SLOW_ANIMATION_SPEED = 1;
	final double FAST_ANIMATION_SPEED = 0.25;
	
	//Inner variables
	int timer = 0;
	AbstractCharecter selectedCharecter;
	double animationSpeedMultiplyer = FAST_ANIMATION_SPEED; 
	
	
	//Global variabls
	public final static String unlockID = "UNLOCKED";
	public static final int IMAGE_WIDTH = 1126;
	public static final int IMAGE_HEIGHT = 634;

	
	@Override
	public void start(Stage stage) throws Exception {		
		
		//TODO add charecters here
		final AbstractCharecter[] ALL_CHARECTERS = {new MrBasic(), new MrBasic()};
		
		
		root = new StackPane();
		root.setMaxSize(IMAGE_WIDTH, IMAGE_HEIGHT);
		
		buttonClickSound.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				buttonClickSound.seek(Duration.ZERO);
				buttonClickSound.stop();
			}
		});
		
		bossTheme.setStopTime(Duration.millis(19500));
		bossTheme.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				bossTheme.seek(Duration.ZERO);
			}
		});
		mainTheme.setStopTime(Duration.millis(11000));
		mainTheme.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				mainTheme.seek(Duration.ZERO);
			}
		});
		mainTheme.play();
		
		//Background Images
		mainBackgroundV = new ImageView(mainBackgroundI);
		mainBackgroundV2 = new ImageView(mainBackgroundI);
		//background animation
		TranslateTransition backgroundTrans = new TranslateTransition(Duration.seconds(10), mainBackgroundV);
	    backgroundTrans.setFromX(0);
	    backgroundTrans.setToX(IMAGE_WIDTH);
	    backgroundTrans.setInterpolator(Interpolator.LINEAR);
	    backgroundTrans.setCycleCount(Animation.INDEFINITE);
	    TranslateTransition backgroundTrans2 = new TranslateTransition(Duration.seconds(10), mainBackgroundV2);
	    backgroundTrans2.setFromX(-IMAGE_WIDTH);
	    backgroundTrans2.setToX(0);
	    backgroundTrans2.setCycleCount(Animation.INDEFINITE);
	    backgroundTrans2.setInterpolator(Interpolator.LINEAR);
	    backgroundParallelTrans = new ParallelTransition(backgroundTrans, backgroundTrans2);
	    backgroundParallelTrans.play();
		
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
	    pathTransition.setDuration(Duration.seconds(1));
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
	    Label lblSelectionDescription= new Label("Name your save and select a charecter to play, then click the select button.");
	    lblSelectionDescription.setFont(Font.font(FONT, MENU_FONT_SIZE));
	    lblSelectionDescription.setWrapText(true);
	    Button btnCharSelectScreenBack = new Button("Back");
	    btnCharSelectScreenBack.setFont(Font.font(FONT, MENU_FONT_SIZE));
	    btnCharSelectScreenBack.setOnAction(event -> nextMenu(charSelectScreenAndDescription, selectScreen));
	    selectAndBackBtns.getChildren().addAll(btnCharSelectScreenBack, lblName);

	    //The character select screen
	    HBox saveNamingLine = new HBox();
	    btnCharSelectScreenSelect = new Button("Select");
	    btnCharSelectScreenSelect.setDisable(true);
	    btnCharSelectScreenSelect.setFont(Font.font(FONT, MENU_FONT_SIZE));
	    txtSaveName = new TextField();
	    txtSaveName.setPrefWidth(SAVE_NAME_TXT_SIZE);
	    txtSaveName.setFont(Font.font(FONT, MENU_FONT_SIZE));
	    txtSaveName.setOnKeyTyped(event -> updateSelectButton());
	    saveNamingLine.getChildren().addAll(txtSaveName, btnCharSelectScreenSelect);

	    //the holder for buttons that select the charecters
	    VBox vbChrecterButtons = new VBox();
	    ScrollPane fpCharecterButtons = new ScrollPane(vbChrecterButtons);
	    fpCharecterButtons.setStyle("-fx-background:transparent;-fx-background-color:transparent;");
	    fpCharecterButtons.setPannable(true);
	    	    
	    //for each charecter in the array make a new button that makes a copy of it
	    for (AbstractCharecter a : ALL_CHARECTERS) {
	    	Button newChecterButton = new Button(a.getName());
		    newChecterButton.setOnAction(event -> setSelectedCharecter((AbstractCharecter) a.clone()));
		    newChecterButton.setFont(Font.font(FONT, MENU_FONT_SIZE));
		    VBox.setMargin(newChecterButton, new Insets(10, 10, 10, 10));
		    vbChrecterButtons.getChildren().add(newChecterButton); 
	    }
	    
	    charSelectScreen.getChildren().addAll(selectAndBackBtns, lblSelectionDescription, saveNamingLine, fpCharecterButtons);
	    
	    //the contents of the charecter select screen
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
	    
	    //each button selects what save to wright to 
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
	    preFightScreen = new AnchorPane();
	    preFightScreen.setPadding(new Insets(MENU_GAP, MENU_GAP, MENU_GAP, MENU_GAP));
	    preFightScreen.setVisible(false);
	    preFightScreen.setMaxSize(IMAGE_WIDTH, IMAGE_HEIGHT);
	    preFightScreen.setMinSize(IMAGE_WIDTH, IMAGE_HEIGHT);

	    //fight(top left) corner of the prefight menu
	    VBox fightSection = new VBox();
	    Button btnFight = new Button("FIGHT!");
	    btnFight.setPrefSize(BTN_WIDTH, BTN_HEIGHT);
	    btnFight.setFont(Font.font(FONT, PREFIGHT_TEXT_SIZE));
	    btnFight.setOnAction(event -> startNewCombat(preFightScreen, selectedSave.getCharecter())); 
	    
	    //back button
	    Button btnPreFightBack = new Button("Back");
	    btnPreFightBack.setFont(Font.font(FONT, BTN_FONT_SIZE));
	    btnPreFightBack.setOnAction(event -> nextMenu(preFightScreen, selectScreen));
	    
	    //stat(top right) corner of the prefight menu
	    VBox statsSection = new VBox();
	    Button btnEditStats = new Button("Stats");
	    btnEditStats.setFont(Font.font(FONT, PREFIGHT_TEXT_SIZE));
	    btnEditStats.setOnAction(event -> editStats(preFightScreen, selectedSave.getCharecter())); 
	    
	    //the scrollPane that displays the stats under the button
	    ScrollPane spDisplayStats = new ScrollPane(lblDisplayStats);
	    spDisplayStats.setStyle("-fx-background:transparent;-fx-background-color:transparent;");
	    spDisplayStats.setPannable(true);
	    lblDisplayStats = new Label();
	    lblDisplayStats.setFont(Font.font(FONT, PREFIGHT_TEXT_SIZE));
	    
	    //ability(bottom left) corner of the prefight menu
	    VBox abilitySection = new VBox();
	    Button btnEditAbility = new Button("Ability"); // just able to view and move them, and see their description
	    btnEditAbility.setFont(Font.font(FONT, BTN_FONT_SIZE));
	    btnEditAbility.setOnAction(event -> editAbilities(preFightScreen, selectedSave.getCharecter())); 
	    //displays the current abilities of the selected charecter
	    lblDisplayAbilities = new Label();
	    lblDisplayAbilities.setFont(Font.font(FONT, PREFIGHT_TEXT_SIZE));
	    
	    //mod(bottom right) corner of the prefight menu
	    VBox modSection = new VBox();
	    Button btnEditMod = new Button("Mods"); // just able to view and move them, and see their description
	    btnEditMod.setFont(Font.font(FONT, BTN_FONT_SIZE));
	    btnEditMod.setOnAction(event -> editMods(preFightScreen, selectedSave.getCharecter()));
	    
	    //displays the last mod unlocked of the selected charecter
	    lblDisplayMods = new Label();
	    lblDisplayMods.setFont(Font.font(FONT, PREFIGHT_TEXT_SIZE));
	    
	    //adds all the pecies of the menu to each "section"
	    fightSection.getChildren().addAll(btnFight, btnPreFightBack);
	    statsSection.getChildren().addAll(btnEditStats, lblDisplayStats);
	    abilitySection.getChildren().addAll(btnEditAbility, lblDisplayAbilities);
	    modSection.getChildren().addAll(btnEditMod, lblDisplayMods);
	    
	    //sets every section to the right (or left) side of the screen 
	    AnchorPane.setTopAnchor(fightSection, MENU_GAP + .0);
	    AnchorPane.setLeftAnchor(fightSection, MENU_GAP * 3 + .0);

	    AnchorPane.setTopAnchor(statsSection, MENU_GAP + .0);
	    AnchorPane.setRightAnchor(statsSection, MENU_GAP * 3 + .0);

	    AnchorPane.setBottomAnchor(abilitySection, MENU_GAP * 6 + .0);
	    AnchorPane.setLeftAnchor(abilitySection, MENU_GAP * 3 + .0);
	    
	    AnchorPane.setBottomAnchor(modSection, MENU_GAP * 6+ .0);
	    AnchorPane.setRightAnchor(modSection, MENU_GAP * 15 + .0);
	    
	    //places each section into the AnchorPane
	    preFightScreen.getChildren().addAll(fightSection, statsSection, abilitySection, modSection);

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
	    volumeSlider = new Slider(0, 100, 100);
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
	    root.getChildren().addAll(mainBackgroundV, mainBackgroundV2, titleScreen, selectScreen, optionsScreen, charSelectScreenAndDescription, preFightScreen);
	    
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
//	    stage.setResizable(false);
	    stage.show();
	}
	
	
	//moves the first node from on the screen to off the screen, and moves the second from off the screen to on the screen
	public void nextMenu(Node screen, Node newScreen) {
		buttonClickSound.play();
		
		//so the user can't click anything while in Transition
		Rectangle rect = new Rectangle(IMAGE_WIDTH, IMAGE_HEIGHT);
		rect.setOpacity(0);
		root.getChildren().add(rect);
		
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
		parTrans.setOnFinished(event -> {
			root.getChildren().remove(rect);
		});
		parTrans.play();
	}
	
	//moves the first node from on the screen to off the screen, and moves the title screen from off the screen to on the screen
	public void backMenu (Node n) {
		buttonClickSound.play();
		//so the user can't click anything while in transition
		Rectangle rect = new Rectangle(IMAGE_WIDTH, IMAGE_HEIGHT);
		rect.setOpacity(0);
		root.getChildren().add(rect);
		
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
		parTrans.setOnFinished(event -> {
			root.getChildren().remove(rect);
		});
		parTrans.play();
	}
	
	//toggles the animation speed multiplier
	public void changeAnimationSpeed () {
		if (animationSpeedMultiplyer == SLOW_ANIMATION_SPEED) {
			animationSpeedMultiplyer = FAST_ANIMATION_SPEED;
		} else {
			animationSpeedMultiplyer = SLOW_ANIMATION_SPEED;
		}
	}
	
	//updates the volume meater visual
	public void changeVolume() {
		lblVolumeSlider.setText("Volume (" + ((int)volumeSlider.getValue()) + "%)" );
		buttonClickSound.setVolume(volumeSlider.getValue() / 100);
		bossTheme.setVolume(volumeSlider.getValue() / 100);
		mainTheme.setVolume(volumeSlider.getValue() / 100);
		
		
	}
	
	//sets selected charecter to the charecter represented in the button calling it or passed
	public void setSelectedCharecter(AbstractCharecter charecter) {
		buttonClickSound.play();
		selectedCharecter = charecter;
		updateSelectButton();
		lblShowCharDescription.setText("");
		
		//reads the file with the same name as the charecter plus description and prints it to the screen
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
	
	//either selects the epty save that the user clicks on and takes them to the charecter selection screen
	//or takes them to the pre fight screen with the selected charecters information
	public void selectSave (Save save) {
		//select new charecter
		buttonClickSound.play();
		if (save.getIsEmpty()) {
    		lblShowCharDescription.setText("");
    		selectedSave = save;
    		nextMenu(selectScreen, charSelectScreenAndDescription);
    		
    	//play: takes you to prefight screen
    	//Delete: removes the informaiton from the save
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
	
	//updates the prefight screen to show the information for the selected charecter
	public void updatePreFightScreen () {
		lblDisplayStats.setText(selectedSave.getCharecter().getStatsAsString());
		lblDisplayAbilities.setText(selectedSave.getCharecter().getAbilitiesAsString());
		lblDisplayMods.setText(selectedSave.getCharecter().LastUnlockedMod());

	}
	
	//places all the information aquired into the selected save
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
	
	//checks if the user has a selected charecter and has typed a name for the save or not and sets it accordingly
	public void updateSelectButton () {
		if (!txtSaveName.getText().equals("") && selectedCharecter != null) {
    	    btnCharSelectScreenSelect.setDisable(false);
    	} else {
    	    btnCharSelectScreenSelect.setDisable(true);
    	}
	}
	
	//sets the names of the save buttons to refect the information in the save
	public void updateButtonNames() {
		btnSave1.setText(save1.getName());
		btnSave2.setText(save2.getName());
		btnSave3.setText(save3.getName());
	}
	
	//brings you to the edit mod screen(made here) 
	public void editMods(Node thisScene, AbstractCharecter charecter) {
		//the pane all of the scene will rest on 
		StackPane stack = new StackPane();
		stack.setPrefSize(IMAGE_WIDTH, IMAGE_HEIGHT);
		
		//the group that the mod buttons will rest
		Group group = new Group();
		group.getChildren().addAll(findModLayout(charecter.getMods().get(0), (IMAGE_WIDTH / 2), 0));
		
		//the button that returns you to the last screen
		Button back = new Button("Back");
		StackPane.setAlignment(back, Pos.TOP_LEFT);
		back.setLayoutX(IMAGE_WIDTH / 2 - (MOD_BUTTON_SIZE / 2));
		back.setFont(Font.font(FONT, MENU_FONT_SIZE));
		back.setOnAction(event -> leaveTempScene(stack, thisScene)); // make animations finish before removing group - on finish aciton for transition 
		
		//the backing to group used to center the tree
		Rectangle block = new Rectangle();
		block.setOpacity(100);
		group.getChildren().add(block);
		
		//the scrollpane used to let the user to get to all the mods even form off screen
		ScrollPane scrollPane = new ScrollPane(group);
		scrollPane.setPannable(true);
		scrollPane.setStyle("-fx-background:transparent;-fx-background-color:transparent;");

		//adding all the loose bits to the stack(new screen) then to the root and changin to that screen
		stack.getChildren().addAll(scrollPane, back);
		root.getChildren().add(stack);
		nextMenu(thisScene, stack);
	}
	
	//makes then takes the user to the edit stats screen
	public void editStats (Node thisScene, AbstractCharecter charecter) {
		
		//the pane most of everything will rest on 
		GridPane gpStats = new GridPane();
		gpStats.setVgap(TITLE_GAP);
		gpStats.setHgap(TITLE_GAP);
		gpStats.setHgap(MENU_GAP);
		
		//the scroll pane that the grid pane will rest on to allow scrolling
		ScrollPane sp = new ScrollPane(gpStats);
		sp.setStyle("-fx-background:transparent;-fx-background-color:transparent;");
		
		//the button that takes you back to the last screen
		Button back = new Button("Back");
		back.setFont(Font.font(FONT, MENU_FONT_SIZE));
		
		//commits all the stats for the charecter
		Button commmitAll = new Button("Commit All");
		commmitAll.setFont(Font.font(FONT, MENU_FONT_SIZE));
		commmitAll.setOnAction(event -> {
			for (int i = 0; i < charecter.getStats().size(); i++) {
				Stat s = charecter.getStats().get(i);
				s.commitTempStat();
				//locates the change label in the grid pane to change it to the new amount
				((Label) ((GridPane) gpStats.getChildren().get(i + 3)).getChildren().get(2)).setText(s.getTempValue() + "");
			}
		});
		
		//displays the total points the character has to spend
		Label lblTotalPoints = new Label();
		lblTotalPoints.setTextFill(Color.BLACK);
		lblTotalPoints.setFont(Font.font(FONT, MENU_FONT_SIZE));
		
		//adds all the loose bits to the grid pane
		gpStats.add(back, 0, 0);
		gpStats.add(lblTotalPoints, 1, 0);
		gpStats.add(commmitAll, 2, 0);
		
		//makes a section for each stat the charcter has and adds it to the grid pane
		for (Stat s : charecter.getStats()) {
			Button subTen = new Button("-10");
			Button sub = new Button("-");
			Label change = new Label();
			Button add = new Button("+");
			Button addTen = new Button("+10");
			Label stat = new Label();
			GridPane gp = new GridPane();
			Button commit = new Button("Commit");
			
			subTen.setFont(Font.font(FONT, MENU_FONT_SIZE));
			sub.setFont(Font.font(FONT, MENU_FONT_SIZE));
			change.setFont(Font.font(FONT, MENU_FONT_SIZE));
			add.setFont(Font.font(FONT, MENU_FONT_SIZE));
			addTen.setFont(Font.font(FONT, MENU_FONT_SIZE));
			stat.setFont(Font.font(FONT, MENU_FONT_SIZE));
			commit.setFont(Font.font(FONT, MENU_FONT_SIZE));
			change.setTextFill(Color.BLACK);
			stat.setTextFill(Color.BLACK);
			gp.setHgap(MENU_GAP);
			
			add.setOnAction(event -> changeTempStats(s, charecter, change, stat, lblTotalPoints, true, 1));
			sub.setOnAction(event -> changeTempStats(s, charecter, change, stat, lblTotalPoints, false, 1));
			addTen.setOnAction(event -> changeTempStats(s, charecter, change, stat, lblTotalPoints, true, 10));
			subTen.setOnAction(event -> changeTempStats(s, charecter, change, stat, lblTotalPoints, false, 10));
			
			commit.setOnAction(event -> {
				s.commitTempStat();
				changeTempStats(s, charecter, change, stat, lblTotalPoints, false, 1);
			});

			changeTempStats(s, charecter, change, stat, lblTotalPoints, false, 1);
			gp.add(subTen, 0, 0);
			gp.add(sub, 1, 0);
			gp.add(change, 2, 0);
			gp.add(add, 3, 0);
			gp.add(addTen, 4, 0);
			gp.add(commit, 5, 0);
			gp.add(stat, 6, 0);
			gpStats.add(gp, 0, gpStats.getChildren().size() + 1, 2, 1);
		}
		
		back.setOnAction(event -> {
			for (Stat s : charecter.getStats()) {
				charecter.addStatPoints(s.getTempValue());
				s.setTempValue(0);
			}
			leaveTempScene(sp, thisScene);
		});
		
		
		root.getChildren().add(sp);
		nextMenu(thisScene, sp);
	}
	
	//makes then takes the user to the abilities select screen
	public void editAbilities(Node thisScene, AbstractCharecter charecter) {
		
		//the vbox most things will rest on 
		VBox abilityScreen = new VBox();
		abilityScreen.setAlignment(Pos.CENTER);
		
		//the button that returns you to the previous screen
		Button back = new Button("Back");
		back.setFont(Font.font(FONT, MENU_FONT_SIZE));
		
		//the button that takes you to the slot machine screen
		Button useRoll = new Button("Unlock New Ability : " + charecter.getRollTokens() + " Tokens.");
		useRoll.setFont(Font.font(FONT, MENU_FONT_SIZE));
		//can only be used if the charecter has a rolltoken 
		if (charecter.getRollTokens() < 1) {
			useRoll.setDisable(true);
		}
		
		//the labels used to represent the three equipped abilities (dose not mean they are currently equipped, jest represented)
		Label ability1 = new Label(charecter.getAbility(0).getName());
		Label ability2 = new Label(charecter.getAbility(1).getName());
		Label ability3 = new Label(charecter.getAbility(2).getName());
		ability1.setFont(Font.font(FONT, MENU_FONT_SIZE));
		ability2.setFont(Font.font(FONT, MENU_FONT_SIZE));
		ability3.setFont(Font.font(FONT, MENU_FONT_SIZE));
		setUpToolTip(ability1, charecter.getAbility(0));
		setUpToolTip(ability2, charecter.getAbility(1));
		setUpToolTip(ability3, charecter.getAbility(2));
		FlowPane.setMargin(ability1, new Insets(MENU_GAP, MENU_GAP, MENU_GAP, MENU_GAP));
		FlowPane.setMargin(ability2, new Insets(MENU_GAP, MENU_GAP, MENU_GAP, MENU_GAP));
		FlowPane.setMargin(ability3, new Insets(MENU_GAP, MENU_GAP, MENU_GAP, MENU_GAP));

		//adds the drag and drop functionality to the labels
		setUpLabel(ability1);
		setUpLabel(ability2);
		setUpLabel(ability3);

		//makes sure each ability is representing the right thing in the charecters data
		back.setOnAction(event -> {
			fixAbilities(charecter, ability1, ability2, ability3);
			updatePreFightScreen();
			leaveTempScene(abilityScreen, preFightScreen);
		});
		
		//if you can unlock another ability it takes one token and if you cant it turns all tokens into skill points
		useRoll.setOnAction(event -> {
			buttonClickSound.play();
			if (charecter.getRollTokens() > 0) {
				if (charecter.numberOfLockedAbilities() > 0 ) {
					fixAbilities(charecter, ability1, ability2, ability3);
					abilitySlotMachine(abilityScreen, charecter);				
				} else {
					FXDialog.print("You have unlocked all abilities! Your Roll Tokens have been conferted into " + charecter.getRollTokens() * 5 + " Skill Points!");
					charecter.addStatPoints(charecter.getRollTokens() * 5);
					charecter.addRollTokens(-charecter.getRollTokens());
					useRoll.setText("Unlock New Ability : " + charecter.getRollTokens() + " Tokens.");
				}
			}
		});
		
		//the flow pane that contains the buttons and labels that dont change (back / abilities / roll button)
		FlowPane activeAbilities = new FlowPane();
		activeAbilities.setMaxWidth(IMAGE_WIDTH / 2); 
		activeAbilities.getChildren().addAll(back, ability1, ability2, ability3, useRoll);
		
		//the flow pane to hold all the avalable abilities 
		FlowPane unlockedAbilities = new FlowPane();
	
		//placing everything on a scroll pane to be able to pane around
		ScrollPane spAbilities = new ScrollPane(unlockedAbilities);
		spAbilities.setMaxSize(IMAGE_WIDTH / 2, IMAGE_HEIGHT);
		spAbilities.setPannable(true);
		spAbilities.setStyle("-fx-background:transparent;-fx-background-color:transparent;");
		
		//for every ability a charecter has, if it is unlocked and not one of the first three(equiped) ones, make a label with its name and add it to the flow pane
		for (AbstractAbility a : charecter.getPosibleAbilities()) {
			if (a.isUnlocked() && !a.isEquiped()) {
				Label ability = new Label(a.getName());
				FlowPane.setMargin(ability, new Insets(MENU_GAP, MENU_GAP, MENU_GAP, MENU_GAP));
				ability.setFont(Font.font(FONT, MENU_FONT_SIZE));
				setUpLabel(ability);
				setUpToolTip(ability, a);
				unlockedAbilities.getChildren().add(ability);
			}
		}
		
		//for every ability, if it is locked, and therfore not equiped, make a label with ??? on it and add it to the list
		for (AbstractAbility a : charecter.getPosibleAbilities()) {
			if (!a.isUnlocked()) {
				Label ability = new Label("   ???   ");
				FlowPane.setMargin(ability, new Insets(MENU_GAP, MENU_GAP, MENU_GAP, MENU_GAP));
				ability.setFont(Font.font(FONT, MENU_FONT_SIZE));
				unlockedAbilities.getChildren().add(ability);
			}
		}
		
		//color correcting all the text to black
		for (Node l : unlockedAbilities.getChildren()) {
			((Label) l).setTextFill(Color.BLACK);
		}
		
		//adding everything to the screen
		abilityScreen.getChildren().add(activeAbilities);
		abilityScreen.getChildren().add(new Line(0, 0, IMAGE_WIDTH, 0));
		abilityScreen.getChildren().add(spAbilities);
		root.getChildren().add(abilityScreen);
		nextMenu(thisScene, abilityScreen);
	}
	
	//adds the tool tip from the ability that apears instantly
	public void setUpToolTip (Control node, AbstractAbility a) {
			node.setTooltip(new Tooltip(a.getToolTip()));
			node.getTooltip().setShowDelay(Duration.ZERO);
			node.getTooltip().setFont(Font.font(FONT, TEXT_FONT_SIZE));
	}
	
	//creates a screen with a slot machine and three abilitys to unlock
	public void abilitySlotMachine(Node thisScene, AbstractCharecter charecter) {
		//makes sure the user wants to continue
		if (!FXDialog.askYesNoQuestion("Would you like to use a role to unlock an ability?")) {
			return;
		}
		//the picture of the slot machine with holes in it to allow for the buttons to show
		ImageView imgSlotMachine = new ImageView(getClass().getResource("/images/SlotMachineTest3.png").toString());

		//the stackpane everything else will sit on
		StackPane stackPane = new StackPane();

		//picks 3 abilities that are locked and have not already been chosen
		//if there are less than three it picks the remaining ones
		AbstractAbility a = getRandomLockedAbility(charecter);

		//creates the animations and buttons for each of the selected abilities
		//images for the spinging animation
		ImageView img1 = new ImageView(getClass().getResource("/images/BigSlotFull.png").toString());
		ImageView img2 = new ImageView(getClass().getResource("/images/BigSlotFull.png").toString());

		//the spinging animations
		TranslateTransition SlotTrans = new TranslateTransition(Duration.seconds(.1), img1);
		SlotTrans.setFromY(-284);
		SlotTrans.setToY(0);
		SlotTrans.setFromX(-59);
		SlotTrans.setToX(-59);
		SlotTrans.setInterpolator(Interpolator.LINEAR);
		SlotTrans.setCycleCount(1);
		TranslateTransition SlotTrans2 = new TranslateTransition(Duration.seconds(.1), img2);
		SlotTrans2.setFromY(0);
		SlotTrans2.setToY(284);
		SlotTrans2.setFromX(-59);
		SlotTrans2.setToX(-59);
		SlotTrans2.setCycleCount(1);
		SlotTrans2.setInterpolator(Interpolator.LINEAR);
		ParallelTransition slotParallelTrans = new ParallelTransition(SlotTrans, SlotTrans2);
		slotParallelTrans.setDelay(Duration.seconds(2 * this.animationSpeedMultiplyer));
		slotParallelTrans.setCycleCount(Animation.INDEFINITE);
		slotParallelTrans.play();

		//the "Button" that unlocks the ability being looked at 
		StackPane btn = new StackPane();
		ImageView iv = new ImageView(getClass().getResource("/images/BigSlot.png").toString());
		Label lbl = new Label(a.getName());
		System.out.print(a.getName());

		lbl.setFont(Font.font(FONT, MENU_FONT_SIZE));
		btn.setOnMouseClicked(event -> selectUnlockAbility(a, charecter, stackPane));
		btn.setOnMouseEntered(event -> {
			System.out.print(lbl.getText());
		});

		//the animation that plays so the button falls into place
		TranslateTransition btnTrans = new TranslateTransition(Duration.seconds(.1), btn);
		btnTrans.setFromY(-318);
		btnTrans.setToY(-34);
		btnTrans.setFromX(-59);
		btnTrans.setToX(-59);
		btnTrans.setInterpolator(Interpolator.LINEAR);
		btnTrans.setCycleCount(1);

		btn.setVisible(false);

		//adds everything to the screen
		btn.getChildren().addAll(iv, lbl);
		stackPane.getChildren().addAll(img1, img2);
		stackPane.getChildren().addAll(btn);



		//plays the slot animation
		imgSlotMachine.setOnMouseClicked(event -> {

			imgSlotMachine.setOnMouseClicked(null);
			//used to make the image visable at the start of the animation 
			TranslateTransition timer = new TranslateTransition(Duration.ZERO);
			timer.setOnFinished(event1 -> stackPane.getChildren().get(2).setVisible(true));

			//plays the timer and the animation at the same time, basically just makes the image visible at the start of the animation
			ParallelTransition tAndTimer = new ParallelTransition(btnTrans, timer);
			tAndTimer.setDelay(Duration.seconds(0));

			//removes the images from the screen once the animation is finished playing over it 
			btnTrans.setOnFinished(event2 -> {
				slotParallelTrans.stop();
				stackPane.getChildren().remove(img1);
				stackPane.getChildren().remove(img2);
			});
			tAndTimer.play();


		});

		stackPane.getChildren().add(imgSlotMachine);

		root.getChildren().add(stackPane);
		leaveTempScene(thisScene, stackPane);
	}

	public AbstractAbility getRandomLockedAbility(AbstractCharecter charecter) {
		AbstractAbility a;
		do {
			a = charecter.getPosibleAbilities().get(randomNumber(0, charecter.getPosibleAbilities().size() - 1));
		} while (a.isUnlocked());
		return a;
	}
	
	public void selectUnlockAbility (AbstractAbility a, AbstractCharecter charecter, Node thisScreen) {
		FXDialog.print("You have unlocked " + a.getName() + ".");
		System.out.print(a);
		a.setUnlocked(true);
		charecter.addRollTokens(-1);
		editAbilities(thisScreen, charecter);
	}
	
	//unequips all the charecters abilities, then equipes all the abilities represented by each label. NOTE it is important that no label be named the same as another
	public void fixAbilities(AbstractCharecter charecter, Label ability1, Label ability2, Label ability3) {
		for (AbstractAbility a : charecter.getPosibleAbilities()) {
			if (a.isUnlocked()) {
				charecter.unequipAbility(a);	
			}
		}
		charecter.equipAbility(ability1.getText(), 0);
		charecter.equipAbility(ability2.getText(), 1);
		charecter.equipAbility(ability3.getText(), 2);
	}
	
	//adds the ability for the label to be draged and droped aswell as resive other drag and droped labels
	public void setUpLabel(Label lbl) {
		
		//makes a border around the label when hovered
		lbl.setOnMouseEntered(event -> {
			lbl.setStyle("-fx-border-color: black;");
		});

		//removes the border around the label when unhovered
		lbl.setOnMouseExited(event -> {
			lbl.setStyle("-fx-border-color: transparent;");
		});

		//adds the string on the label and its tool tip to the clipBoard once drag starts
		lbl.setOnDragDetected(new EventHandler <MouseEvent>() {
			public void handle(MouseEvent event) {

				Dragboard db = lbl.startDragAndDrop(TransferMode.ANY);

				ClipboardContent content = new ClipboardContent();
				content.putString(lbl.getText() + "*;" +lbl.getTooltip().getText());
				db.setContent(content);
				event.consume();
			}
		});

		//acceptance mode set i think 
		lbl.setOnDragOver(new EventHandler <DragEvent>() {
			public void handle(DragEvent event) {
				if (event.getGestureSource() != lbl) {
					event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				}
				event.consume();
			}
		});

		//makes the label green when hovered by a drag event
		lbl.setOnDragEntered(new EventHandler <DragEvent>() {
			public void handle(DragEvent event) {
				if (event.getGestureSource() != lbl) {
					lbl.setTextFill(Color.GREEN);
				}
				event.consume();
			}
		});

		//changes the label back to black once exited
		lbl.setOnDragExited(new EventHandler <DragEvent>() {
			public void handle(DragEvent event) {
				lbl.setTextFill(Color.BLACK);
				event.consume();
			}
		});

		//Label text 1 "*;" Tooltip 1 ":" Label text 2 ";*" Tooltip 2
		//adds label text 1 to the label, then sets its tool tip's text to tooltip 1
		lbl.setOnDragDropped(new EventHandler <DragEvent>() {
			public void handle(DragEvent event) {

				Dragboard db = event.getDragboard();
				ClipboardContent content = new ClipboardContent();
				content.putString(db.getString() + ":" + lbl.getText() + ";*" + lbl.getTooltip().getText());
				db.setContent(content);

				boolean success = false;
				if (db.hasString() && db.getString().contains(":")) {
					//label
					lbl.setText(db.getString().substring(0, db.getString().indexOf("*;")));
					//tooltip
					lbl.getTooltip().setText(db.getString().substring(db.getString().indexOf("*;") + 2, db.getString().indexOf(":")));
					success = true;
				}
				event.setDropCompleted(success);

				event.consume();
			}
		});

		//Label text 1 "*;" Tooltip 1 ":" Label text 2 ";*" Tooltip 2
		//adds label text 2 to the label, then sets its tool tip's text to tooltip 2
		lbl.setOnDragDone(new EventHandler <DragEvent>() {
			public void handle(DragEvent event) {
				Dragboard db = event.getDragboard();
				if (event.getTransferMode() == TransferMode.MOVE) {
					//label
					lbl.setText(db.getString().substring(db.getString().indexOf(":") + 1, (db.getString().indexOf(";*"))));
					//tooltip
					lbl.getTooltip().setText(db.getString().substring(db.getString().indexOf(";*") + 2));

				}
				event.consume();
			}
		});
	}

	//adjusts the stat (s) by amount and updates the visuals to represent that information
	public void changeTempStats (Stat s, AbstractCharecter charecter, Label change, Label stat, Label lblTotalPoints, boolean adding, int amount) {
		buttonClickSound.play();
		if (adding) {
			if (!(charecter.getStatPoints() < amount)) {
				charecter.addStatPoints(-amount);
				s.addTempValue(amount);
			} else {
				s.addTempValue(charecter.getStatPoints());
				charecter.setStatPoints(0);
			}
		} else {
			if (!(s.getTempValue() <= 0)) {
				charecter.addStatPoints(amount);
				s.addTempValue(-amount);
			} else {
				charecter.addStatPoints(s.getTempValue());
				s.setTempValue(0);
			}
		}
		change.setText(s.getTempValue() + "");
		stat.setText("New Total: " + charecter.getStatAsString(s.getName()) + "\n" + s.getToolTip());
		lblTotalPoints.setText("Stat Points Avalable: " + charecter.getStatPoints() + "");
	}
	
	//transitions from screen to new Screen and removes screen from root
	public void leaveTempScene(Node screen, Node newScreen) {
		buttonClickSound.play();
		//so the user can't click anything while in Transition
		Rectangle rect = new Rectangle(IMAGE_WIDTH, IMAGE_HEIGHT);
		rect.setOpacity(0);
		root.getChildren().add(rect);
		
		newScreen.setVisible(true);
		TranslateTransition buttonsTrans2 = new TranslateTransition(Duration.seconds(1.25 * animationSpeedMultiplyer), screen);
		buttonsTrans2.setFromY(-100);
		buttonsTrans2.setToY(1000);
		buttonsTrans2.setCycleCount(1);
		buttonsTrans2.setOnFinished(event -> {
			screen.setLayoutY(1000);
			root.getChildren().remove(screen);
			root.getChildren().remove(rect);
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
		updatePreFightScreen();
	}

	//returns and arraylist of buttons with their layouts set to form a tree pattern. NOTE only works for trees with no more than two branches from any one note.
	public ArrayList<Node> findModLayout (AbstractModification mod, double xPos, double yPos) {
		//the button(s) currently being returned
		ArrayList<Node> ret = new ArrayList<Node>();
		
		//makes a new button that tries to unlock the corresponding ability when clicked
		Button btn = new Button(mod.getName() + (mod.isUnlocked()? "\nUNLOCKED" : "" ));
		btn.setOnAction(event -> {
			buttonClickSound.play();
			if (mod.unlock()) {
				btn.setText(mod.getName() + (mod.isUnlocked()? "\nUNLOCKED" : "" ));
			}
		});
		btn.setLayoutX(xPos - (MOD_BUTTON_SIZE / 2));
		btn.setLayoutY(yPos);
		btn.setPrefSize(MOD_BUTTON_SIZE, MOD_BUTTON_SIZE);
		ret.add(btn);
		
		//if there is at least one other mod in the data structure...
		if (!mod.getNext().isEmpty()) {
			//if the amount is 1
			if (mod.getNext().size() == 1) {
				//add a line starting just under and in the middle of the button
				ret.add(new Line(xPos, yPos + MOD_BUTTON_SIZE, xPos, yPos + MOD_GAP + MOD_BUTTON_SIZE));
				//then call the method again on the next mod to have it placed in the array with its layout set
				ret.addAll(findModLayout(mod.getNext().get(0), xPos, yPos + MOD_GAP + MOD_BUTTON_SIZE));
			//if the amount is 2...
			} else if (mod.getNext().size() == 2) {
				//make 2 new lines, one to go to the left and the other go to the right
				//this monstrosity of a line of code uses the image width and the number of "end points" the data structure or tree will have, and how 
				//far along it is to determing the x coorinate of the next two buttons
				ret.add(new Line(xPos - (MOD_BUTTON_SIZE / 2), yPos + MOD_BUTTON_SIZE, xPos - (IMAGE_WIDTH / 8 * ((int)((mod.endPoints() + 1) / 2))), yPos + MOD_GAP + MOD_BUTTON_SIZE));
				ret.add(new Line(xPos + (MOD_BUTTON_SIZE / 2), yPos + MOD_BUTTON_SIZE, xPos + (IMAGE_WIDTH / 8 * ((int)((mod.endPoints() + 1) / 2))), yPos + MOD_GAP + MOD_BUTTON_SIZE));
				//then call the method again once for each next in the data structure
				ret.addAll(findModLayout(mod.getNext().get(0), xPos - (IMAGE_WIDTH / 8 * ((int)((mod.endPoints() + 1) / 2))), yPos + MOD_GAP + MOD_BUTTON_SIZE));
				ret.addAll(findModLayout(mod.getNext().get(1), xPos + (IMAGE_WIDTH / 8 * ((int)((mod.endPoints() + 1) / 2))), yPos + MOD_GAP + MOD_BUTTON_SIZE));
			} else {
				//nothing yet...
			}
		}
		
		return ret;
		
	}


	public void fadeToNext(Node thisScene, Node nextScene, FadeTransitionResult next, AbstractCharecter charecter, BossEnemy boss) {
		//the black screen to fade in and out
		Rectangle rect = new Rectangle (0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
		
		switch(next) {
		//fades out the main music when going to fight screen
		case FIGHT:
			final Animation MainThemeFadeOut = new Transition() {
				{
					setCycleDuration(Duration.seconds(2));
					setOnFinished(event -> mainTheme.stop());
				}
				protected void interpolate(double frac) {
					mainTheme.setVolume((volumeSlider.getValue() / 100) - frac);
				}
			};
			MainThemeFadeOut.play();	
			break;
			//fades out the boss music when going to black screen
		case BLACK: 
			final Animation bossThemeFadeOut = new Transition() {
				{
					setCycleDuration(Duration.seconds(2));
					setOnFinished(event -> bossTheme.stop());
				}
				protected void interpolate(double frac) {
					bossTheme.setVolume((volumeSlider.getValue() / 100) - frac);
				}
			};
			bossThemeFadeOut.play();
			break;
		case MENU:
			//fades in the main theme when returning to menu
			final Animation mainThemeFadeIn = new Transition() {
				{
					setCycleDuration(Duration.seconds(2));
					mainTheme.setVolume(0);
					mainTheme.play();
				}
				protected void interpolate(double frac) {
					mainTheme.setVolume(frac);
				}
			};
			mainThemeFadeIn.play();
			break;
		
		}
		
		

		//the fade out animation
		FadeTransition ft2 = new FadeTransition(Duration.seconds(1.5), rect);
		ft2.setFromValue(1.0);
		ft2.setToValue(0.0);
		ft2.setCycleCount(1);
		ft2.setDelay(Duration.seconds(2));
		ft2.setOnFinished(event -> {
			//remove the rectangle so user can click on the screen again
			root.getChildren().remove(rect);
			
			//depending on the desired result of the fade...
			switch(next) {
			//Begin the fight round loop
			case FIGHT:
				speak(last -> playerFightRound(thisScene, charecter, boss), charecter.getFightIntro());				
				break;
			//remove the fight pane, then add the display pane and speak the post combate results. followed by fading again to menu
			case BLACK: 
				root.getChildren().remove(root.getChildren().size() - 2);
				root.getChildren().add(fightDisplayPane);
				speak(last -> fadeToNext(nextScene, preFightScreen, FadeTransitionResult.MENU, charecter, boss), postCombatResult(charecter, boss));
				updatePreFightScreen();
				break;
			//clears the display pane's contents
			case MENU:
				fightDisplayPane.getChildren().clear();
				break;
			
			}
		});
		
		//the fade in animation
		FadeTransition ft = new FadeTransition(Duration.seconds(1), rect);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.setCycleCount(1);
		ft.setOnFinished(event -> {
			//litterally just moves the menu off the screen because it didnt work when i tired to code it again
			nextMenu(thisScene, nextScene);
			
			//if going to fight set the background to the fight one, otherwise make it the scrolling one
			switch(next) {
			case FIGHT:
				
				//fades in the boss theme when entering
				final Animation bossThemeFadeIn = new Transition() {
					{
						setCycleDuration(Duration.seconds(2));
						bossTheme.setVolume(0);
						bossTheme.play();
					}
					protected void interpolate(double frac) {
						bossTheme.setVolume(frac);
					}
				};
				bossThemeFadeIn.play();
				
				backgroundParallelTrans.jumpTo(Duration.seconds(-1));
				backgroundParallelTrans.stop();
				mainBackgroundV.setImage(fightBackgroundI);
			break;
			default:
				mainBackgroundV.setImage(mainBackgroundI);
				backgroundParallelTrans.play();
			}
			
			ft2.play();
		});
		//remove the display pane (this happens after the speak in the BLACK case has happened)
		if (root.getChildren().contains(fightDisplayPane)) {
			root.getChildren().remove(fightDisplayPane); 			
		}
		ft.play();
	    root.getChildren().add(rect);
	}
	
	//creates the screen for a new combat, with a new boss and changes to that screen
	public void startNewCombat (Node thisScene, AbstractCharecter charecter) {
		buttonClickSound.play();
		Pane pane = new Pane();
		BossEnemy boss = new BossEnemy(charecter.getWins());
		ImageView enemyHolder = new ImageView(boss.getImageLocation());
		ImageView playerHolder = new ImageView(charecter.getImageLocation());
		
		enemyHolder.setLayoutX(IMAGE_WIDTH - 300);
		
		fightDisplayPane.setLayoutY(500);
		
		pane.getChildren().addAll(enemyHolder, playerHolder, fightDisplayPane);
		pane.setVisible(false);
		
		root.getChildren().add(pane);
		
		fadeToNext(thisScene, pane, FadeTransitionResult.FIGHT, charecter, boss);
		
	}
	
	//calculates the results of the combat
	//then returns an array of strings describing the results of the combat.
	public String[] postCombatResult(AbstractCharecter charecter, BossEnemy boss) {
		// this number is the amount of point the player will earn by default and follows the formula:
		//0-20(based on the percent missing health of the boss) + 1-5 (random)
		int skillPoints = randomNumber( (int) (20.0 - (boss.getStat("HP") / boss.findStat("HP").getMax() * 20.0) + 1), (int) (20.0 - (boss.getStat("HP") / boss.findStat("HP").getMax() * 20.0) + 5.0));

		//what will be returned
		ArrayList<String> toSay = new ArrayList<String>();
		
		//if the player lost give them their points then give them a one in five chance to get an ability token 
		if (charecter.isDead()) {
			toSay.add("You lost...");
			toSay.add("But don't be discouraged!");
			toSay.add("You Earnt " + skillPoints + " to upgrade your charecter next time.");
			if (randomNumber(1, 5) == 1) {
				charecter.addRollTokens(1);
				toSay.add("And a Ability Token to use in the prep menu.");
			}
			
		}
		
		//if the player won double the points they would have earnt and give then an ability token
		if (boss.isDead()) {
			skillPoints *= 2;
			charecter.addRollTokens(1);
			charecter.addWin();
			toSay.add("Congradulations, you won!");
			toSay.add("You have recived double points, bringin you to " + skillPoints + ", and a guarentied Ability Token to use in the prep menu.");
			toSay.add("The Boss has aslow DOUBLED its stats for next fight!");
		}
		//give player points
		charecter.addStatPoints(skillPoints);
		
		//changes the arraylist to a String[] to be returned
		String[] ret = new String[toSay.size()];
		for (int i = 0; i < toSay.size(); i++) {
			ret[i] = toSay.get(i);
		}
		
		charecter.reset();
		return ret; 
	}
	
	//adds to the fight screen, the player and the boss's stats as well as lists the players options 
	public void playerFightRound (Node thisScene, AbstractCharecter charecter, BossEnemy boss) {
		//if the player has lost continue to the next screen
		if (charecter.isDead()) {
			//adds the black screen displayed during the post combat rewards screen
			Rectangle rect = new Rectangle (0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
			rect.setVisible(false);
		    root.getChildren().add(rect);
		    fadeToNext(thisScene, rect, FadeTransitionResult.BLACK, charecter, boss);
		    return;
		}
		
		//removes anything from the display pane
		fightDisplayPane.getChildren().clear();
		
		//the image to hold the players stats, boss stats and players actions
		ImageView imgTextDisplayWithStats = new ImageView(getClass().getResource("/images/TextDisplayWithStats.jpg").toString());
		
		//holds the buttons containing the players options 
		BorderPane playerOptionsPane = new BorderPane();
		playerOptionsPane.setPrefSize(505, 134);
		playerOptionsPane.setLayoutX(310);
		
		//the players first ability
		Button ability1 = new Button(charecter.getAbility(0).getName());
		if (charecter.getAbility(0).isOnCooldown()) {
			ability1.setText(ability1.getText() + (charecter.getAbility(0).getCooldown() == -1?"\nCantrip" : "\nOn Cooldown" + charecter.getAbility(0).getCooldown()));
			ability1.setDisable(true);
		}
		ability1.setFont(Font.font(FONT, MENU_FONT_SIZE));
		setUpToolTip(ability1, charecter.getAbility(0));
		ability1.setOnAction(event -> useAbility(thisScene, charecter.getAbility(0), boss));

		//the players second ability
		Button ability2 = new Button(charecter.getAbility(1).getName());
		if (charecter.getAbility(1).isOnCooldown()) {
			ability2.setText(ability2.getText() + (charecter.getAbility(1).getCooldown() == -1?"\nCantrip" : "\nOn Cooldown: " + charecter.getAbility(1).getCooldown()));
			ability2.setDisable(true);
		}
		ability2.setFont(Font.font(FONT, MENU_FONT_SIZE));
		setUpToolTip(ability2, charecter.getAbility(1));
		ability2.setOnAction(event -> useAbility(thisScene, charecter.getAbility(1), boss));
		
		//the players third ability (placed on another pane to fix position)
		Button ability3 = new Button(charecter.getAbility(2).getName());
		if (charecter.getAbility(2).isOnCooldown()) {
			ability3.setText(ability3.getText() + (charecter.getAbility(2).getCooldown() == -1?"\nCantrip" : "\nOn Cooldown" + charecter.getAbility(2).getCooldown()));
			ability3.setDisable(true);
		}
		ability3.setFont(Font.font(FONT, MENU_FONT_SIZE));
		setUpToolTip(ability3, charecter.getAbility(2));
		ability3.setOnAction(event -> useAbility(thisScene, charecter.getAbility(2), boss));
		
		//TODO make these in a straight line and on a scrollpane
		playerOptionsPane.setLeft(ability1);
		playerOptionsPane.setCenter(ability2);
		playerOptionsPane.setRight(ability3);
		
		//holds the labels of the players stats
		VBox vbPlayerStats = new VBox();
		for(Stat s : charecter.getStats()) {
			Label lbl = new Label(charecter.getStatAsString(s.getName()));
			lbl.setFont(Font.font(FONT, MENU_FONT_SIZE));
			lbl.setTextFill(Color.BLACK);
			vbPlayerStats.getChildren().add(lbl);
		}
		
		//adds the VBox to a scroll pane so the user can see all of them
		ScrollPane playerStats = new ScrollPane(vbPlayerStats);
		playerStats.setPannable(true);
		playerStats.setStyle("-fx-background:transparent;-fx-background-color:transparent;");
		vbPlayerStats.setPrefSize(295, 134);
		playerStats.setLayoutX(10);

		//holds the labels of the boss stats and its intent
		VBox vbBossStats = new VBox();
		
		//intent label 
		Label lblIntent = new Label("Intent: " + boss.getIntent().name());
		//intent label and the image beside it 
		HBox intentPlusImg = new HBox(lblIntent, getIntentImage(boss.getIntent()));
		lblIntent.setFont(Font.font(FONT, MENU_FONT_SIZE));
		lblIntent.setTextFill(Color.BLACK);
		vbBossStats.getChildren().add(intentPlusImg);
		
		//adds the boss stats to labels and into the pane
		for(Stat s : boss.getStats()) {
			Label lbl = new Label(boss.getStatAsString(s.getName()));
			lbl.setFont(Font.font(FONT, MENU_FONT_SIZE));
			lbl.setTextFill(Color.BLACK);
			vbBossStats.getChildren().add(lbl);
		}
		
		//adds the VBox to a scroll pane so the user can see all of them
		ScrollPane bossStats = new ScrollPane(vbBossStats);
		bossStats.setPannable(true);
		bossStats.setStyle("-fx-background:transparent;-fx-background-color:transparent;");
		vbBossStats.setPrefSize(295, 134);
		bossStats.setLayoutX(825);
		
		if (charecter.allAbilitiesOnCooldown()) {
			final Animation animation = new Transition() {
				{
					setCycleDuration(Duration.seconds(3));
					setOnFinished(finish -> speak(event -> bossFightRound(thisScene, charecter, boss), charecter.getName() + " is on cooldown."));
				}
				@Override
				protected void interpolate(double frac) {}
			};
			animation.play();
		}
		//reduces any colldowns the player may have at the start of their turn (allows the buttons to be dissabled // allAbilitiesOnCooldown to happen first)
		if (charecter.hasLastAbility() && charecter.getLastAbility().getCooldown() >= 0) {
			charecter.reduceCooldown();			
		}
		
		fightDisplayPane.getChildren().addAll(imgTextDisplayWithStats, playerOptionsPane, playerStats, bossStats);

	}
	
	//if the boss is dead it continues, other wise it plays the boss's move and starts a new player turn
	public void bossFightRound(Node thisScene, AbstractCharecter charecter, BossEnemy boss) {
		if (boss.isDead()) {
			//adds the black screen displayed during the post combat rewards screen
			Rectangle rect = new Rectangle (0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
			rect.setVisible(false);
			root.getChildren().add(rect);
			fadeToNext(thisScene, rect, FadeTransitionResult.BLACK, charecter, boss);
			return;
		}
		//plays the boss move and then starts a new player turn
		speak(event -> playerFightRound(thisScene, charecter, boss), boss.play(charecter));
	}
	
	//uses and ability then speaks the result
	public void useAbility(Node thisScene, AbstractAbility ability, BossEnemy boss) {
		buttonClickSound.play();
		ability.getOwner().setLastAbility(ability);
		speak(event -> bossFightRound(thisScene, ability.getOwner(), boss), ability.use(boss));
	}
	
	//makes a game style text box that prints a string one at a time for every string in toSay
	public void speak(EventHandler<ActionEvent> next, String... toSay) {
		fightDisplayPane.getChildren().clear();
		
		//label the string will print to
		Label lbl = new Label();
		lbl.setWrapText(true);
		lbl.setMaxWidth(1000);
		lbl.setLayoutX(10);
		lbl.setLayoutY(10);
		lbl.setFont(Font.font(FONT, MENU_FONT_SIZE));
		
		//the image of the text box
		ImageView display = new ImageView(getClass().getResource("/images/TextDisplay.jpg").toString());
		
		//the arrow at the bottom right corner indicating the ability to continue or skip printing of the text
		ImageView displayArrow = new ImageView(getClass().getResource("/images/DisplayArrow.jpg").toString());
		displayArrow.setLayoutX(-100);
		displayArrow.setLayoutY(99);
		
		//the transitions used to move the arrow
		TranslateTransition arrowRightTransition = new TranslateTransition(Duration.seconds(1), displayArrow);
		TranslateTransition arrowLeftTransition = new TranslateTransition(Duration.seconds(1), displayArrow);
	    arrowRightTransition.setFromX(1192);
	    arrowRightTransition.setToX(1182);
	    arrowRightTransition.setCycleCount(1);
	    arrowRightTransition.setInterpolator(Interpolator.LINEAR);
	    arrowRightTransition.setOnFinished(event -> arrowLeftTransition.play());
	    arrowLeftTransition.setFromX(1182);
	    arrowLeftTransition.setToX(1192);
	    arrowLeftTransition.setCycleCount(1);
	    arrowLeftTransition.setInterpolator(Interpolator.LINEAR);
	    arrowLeftTransition.setDelay(Duration.seconds(1));
	    arrowLeftTransition.setOnFinished(event -> arrowRightTransition.play());
	    arrowRightTransition.play();
	    arrowRightTransition.setDelay(Duration.seconds(1));
	    
	    //and invisable button over the while display pane to skip/continue the text (just setting the image to be clicked on wasnt working)
		Button btn = new Button();
		btn.setOpacity(0);
		btn.setPrefSize(IMAGE_WIDTH, 134);
		fightDisplayPane.getChildren().addAll(display, lbl, displayArrow, btn);
		//java docs code to print the message : https://javadoc.io/static/org.openjfx/javafx-media/17-ea+3/javafx.graphics/javafx/animation/Transition.html
		final Animation animation = new Transition() {
			{
				setCycleDuration(Duration.seconds(1));
			}
			protected void interpolate(double frac) {
				String preText = lbl.getText();
				
				final int length = toSay[0].length();
				final int n = Math.round(length * (float) frac);
				//only prints the first string in the array
				lbl.setText(toSay[0].substring(0, n));
			}
		};
		
		
		
		//if there are more strings to print...
		if (toSay.length > 1) {
			//make the button call a new speak without the first string(index 0)
			animation.setOnFinished(event -> btn.setOnAction(event2 -> speak(next, Arrays.copyOfRange(toSay, 1, toSay.length))));		
		} else {
			//make the button play the action to be performed after the speak
			animation.setOnFinished(event -> btn.setOnAction(next));
		}
		
		//makes the button force finish the animation
		btn.setOnMouseClicked(event -> animation.jumpTo(Duration.INDEFINITE));
		
		//TODO make this one better (dose work tho)
		MediaPlayer clickSound = new MediaPlayer(new Media(getClass().getResource("/sounds/KeyBoardTypingSFX.mp3").toString()));
		clickSound.setStopTime(Duration.seconds(1));
		clickSound.play();
		animation.play();
		
	}
	
	//returns an image corresponding to the intent type
	public HBox getIntentImage(AbilityType a) {
		String type = a.name();
		HBox images = new HBox();
		if (type.contains("ATTACK_PHYSICAL")) {
			images.getChildren().add(new ImageView(getClass().getResource("/images/RedFistSm.png").toString()));
		} else if (type.contains("ATTACK_NON_PHYSICAL")) {
			images.getChildren().add(new ImageView(getClass().getResource("/images/MagicStarSm.png").toString()));
		} else if (type.contains("DEFEND")) {
			images.getChildren().add(new ImageView(getClass().getResource("/images/BlueShieldSm.png").toString()));
		} else if (type.contains("BUFF")) {
			images.getChildren().add(new ImageView(getClass().getResource("/images/GreenArrowSm.png").toString()));
		} else if (type.contains("DEBUFF")) {
			images.getChildren().add(new ImageView(getClass().getResource("/images/PurpleArrowSm.png").toString()));
		} else if (type.contains("UNKNOWN")) {
			//TODO make acc images for this
			images.getChildren().add(new ImageView(getClass().getResource("/images/RedFistSm.png").toString()));
		} else {
			images.getChildren().add(new ImageView(getClass().getResource("/images/RedFistSm.png").toString()));
		}
		return images;
	}
	
	// From Karen Spindler's Grade 11 U computer science course
		public static int randomNumber(int a, int b) {
			int highNum = Math.max(a, b);
			int lowNum = Math.min(a, b);
			int range = highNum - lowNum + 1;
			return (int) (Math.random() * range) + lowNum;
		}
	
	@Override
	public void stop() throws Exception {
		
		//TODO add charecter save data and shi
	}

	public static void main(String[] args) {
		launch(args);
	}

}
