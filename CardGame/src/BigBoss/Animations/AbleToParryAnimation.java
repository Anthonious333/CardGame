package BigBoss.Animations;

import BigBoss.AbstractAbilityAnimation;
import javafx.animation.PathTransition;
import javafx.scene.layout.Pane;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class AbleToParryAnimation extends AbstractAbilityAnimation{

	
	public AbleToParryAnimation(Pane subject) {
		this.setCycleDuration(Duration.seconds(.25));
		this.setCycleCount(INDEFINITE);
		this.setSubject(subject);
	}
	
	@Override
	public void play() {
		this.setCycleCount(INDEFINITE);
		super.play();
	}
	
	@Override
	public void stop() {
		Duration curTime = this.getCurrentTime();
		super.stop();
		this.setCycleCount(1);
		super.play();
		this.jumpTo(curTime);
	}
	
	@Override
	protected void interpolate(double frac) {
		int amount = 2;
		if (this.getCurrentTime().lessThanOrEqualTo(Duration.seconds(.125))) {
			this.getSubject().setLayoutX(this.getSubject().getLayoutX() + amount);
		}
		if (this.getCurrentTime().greaterThanOrEqualTo(Duration.seconds(.125))) {
			this.getSubject().setLayoutX(this.getSubject().getLayoutX() - amount);
		}
		
	}
}
