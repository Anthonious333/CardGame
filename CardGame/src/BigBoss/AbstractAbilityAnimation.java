package BigBoss;

import java.util.ArrayList;

import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class AbstractAbilityAnimation extends Transition{

	private ArrayList<Node> particals = new ArrayList<Node>();
	private Pane subject;
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

	@Override
	public void play() {
		super.play();
		for (Node n : particals) {
			this.getSubject().getChildren().add(n);

		}
	}
	
	@Override
	public void stop() {
		super.stop();
		for (Node n : particals) {
			this.getSubject().getChildren().remove(n);
		}
	}
	
	public Pane getSubject() {
		return subject;
	}

	public void setSubject(Pane subject) {
		this.subject = subject;
	}

	public boolean isBoss() {
		return boss;
	}

	public void setBoss(boolean boss) {
		this.boss = boss;
	}
	


}
