package BigBoss.Animations;

import BigBoss.AbstractAbilityAnimation;
import javafx.scene.Node;
import javafx.util.Duration;


public class AttackAnimation extends AbstractAbilityAnimation{
	public AttackAnimation(boolean isBoss, double duration) {
		this.setBoss(isBoss);
		this.setCycleDuration(Duration.seconds(duration));
	}

	@Override
	protected void interpolate(double frac) {
		int amount = 5;
		if (this.isBoss()) {
			amount = -5;
		}
		
		if (this.getCurrentTime().lessThanOrEqualTo(this.getTotalDuration().divide(2))) {
			this.getSubject().setLayoutX(this.getSubject().getLayoutX() + amount);
		}
		if (this.getCurrentTime().greaterThanOrEqualTo(this.getTotalDuration().divide(2))) {
			this.getSubject().setLayoutX(this.getSubject().getLayoutX() - amount);
		}
		
	}
	
}
