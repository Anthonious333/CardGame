package gitsAndShiggels;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import simpleIO.Console;


public class Zone extends Button{

	private final int WIDTH = 150;
	private final int HEIGHT = 200;

	
	public Zone (String txtOnButton) {
		setStyle(CardGame.lightBlue);
		this.setPrefWidth(WIDTH);
		this.setPrefHeight(HEIGHT);
		this.setAccessibleText("yes");
		this.setOnAction(event -> Console.print("worked"));
		this.setText(txtOnButton);
	}
}