package BigBoss;

import java.util.ArrayList;

import javafx.animation.Transition;
import javafx.scene.Node;

public abstract class AbstractAbilityAnimation extends Transition{

	private ArrayList<Node> particals = new ArrayList<Node>();
	private Node subject;
	private boolean boss;
	
	public ArrayList<Node> getParticals() {
		return particals;
	}

	public void setParticals(ArrayList<Node> particals) {
		this.particals = particals;
	}
	
	public void addParticals(Node... particals ) {
		for (Node n : particals) {
			this.particals.add(n);
		}
	}

	public Node getSubject() {
		return subject;
	}

	public void setSubject(Node subject) {
		this.subject = subject;
	}

	public boolean isBoss() {
		return boss;
	}

	public void setBoss(boolean boss) {
		this.boss = boss;
	}
	


}
