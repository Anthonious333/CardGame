package gitsAndShiggels;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import simpleIO.Console;


public class Zone extends Button{

	private final int WIDTH = 150;
	private final int HEIGHT = 200;
	private final String color = "-fx-background-color: #ADD8E6; ";

	
	public Zone () {
		setStyle(color);
		this.setPrefWidth(WIDTH);
		this.setPrefHeight(HEIGHT);
		this.setAccessibleText("yes");
		this.setOnAction(event -> Console.print("worked"));
		this.setText("Text");
	}
}
