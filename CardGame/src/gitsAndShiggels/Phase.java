package gitsAndShiggels;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Phase extends StackPane{
	public Phase(String text) {
		Rectangle r = new Rectangle(75, 75, Color.WHITE);
		Label l = new Label(text);
		this.getChildren().add(r);
		this.getChildren().add(l);
	}
	
	public void setOff() {
		((Rectangle) this.getChildren().get(0)).setFill(Color.WHITE);
	}
	
	public void setOn() {
		((Rectangle) this.getChildren().get(0)).setFill(Color.GREY);
	}
}
