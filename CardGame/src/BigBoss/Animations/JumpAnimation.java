package BigBoss.Animations;

import BigBoss.AbstractAbilityAnimation;
import javafx.util.Duration;

public class JumpAnimation extends AbstractAbilityAnimation{
	
	private double height;
	public JumpAnimation (double height, double duration) {
		this.height = height;
		this.setCycleDuration(Duration.seconds(duration));
		
	}
	@Override
	protected void interpolate(double frac) {
		double amount = -height;
		
		if (this.getCurrentTime().lessThanOrEqualTo(this.getTotalDuration().divide(2))) {
			this.getSubject().setLayoutY(this.getSubject().getLayoutY() + amount);
		}
		if (this.getCurrentTime().greaterThanOrEqualTo(this.getTotalDuration().divide(2))) {
			this.getSubject().setLayoutY(this.getSubject().getLayoutY() - amount);
		}
		
	}

}
