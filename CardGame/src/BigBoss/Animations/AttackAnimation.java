package BigBoss.Animations;

import BigBoss.AbstractAbilityAnimation;
import javafx.scene.Node;
import javafx.util.Duration;


public class AttackAnimation extends AbstractAbilityAnimation{
	public AttackAnimation(boolean isBoss) {
		this.setBoss(isBoss);
		this.setCycleDuration(Duration.seconds(.5));
	}

	@Override
	protected void interpolate(double frac) {
		int amount = 5;
		if (this.isBoss()) {
			amount = -5;
		}
		
		if (this.getCurrentTime().lessThanOrEqualTo(Duration.seconds(.25))) {
			this.getSubject().setLayoutX(this.getSubject().getLayoutX() + amount);
		}
		if (this.getCurrentTime().greaterThanOrEqualTo(Duration.seconds(.25))) {
			this.getSubject().setLayoutX(this.getSubject().getLayoutX() - amount);
		}
		
	}
}
