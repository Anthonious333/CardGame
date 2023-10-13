package gitsAndShiggels;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Zone extends Rectangle{
	
	/**TODO make this extend image view and set the default image to the shape that it is, 
	 * then you can use onMouseClick to open menus. 
	 * P.S. make constructor ask for image path dont hardcode them. */

	private final int WIDTH = 150;
	private final int HEIGHT = 200;
	private final Color color = Color.LIGHTBLUE;

	
	public Zone () {
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);
		this.setFill(color);
		this.setAccessibleText("yes");
	}
	public Zone (int h, int w) {
		this.setWidth(w);
		this.setHeight(h);
		this.setFill(color);
	}
	public Zone (int h, int w, Color color) {
		this.setWidth(w);
		this.setHeight(h);
		this.setFill(color);
	}
}
