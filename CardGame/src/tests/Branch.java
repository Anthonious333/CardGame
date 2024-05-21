package tests;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Line;

public class Branch extends Group{

	ArrayList<Node> list = new ArrayList<Node>();
	
	public Branch (Node...nodes) {
		for (Node n : nodes) {
			list.add(n);
		}
		assemble();
	}
	
	public void assemble() {
		if (list.size() == 2) {
			
		} else if (list.size() == 3) {
			
		} else if (list.size() == 4) {
			
		} else {
			
		}
	}
}
