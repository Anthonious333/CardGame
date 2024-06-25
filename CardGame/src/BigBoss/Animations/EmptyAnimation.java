package BigBoss.Animations;

import BigBoss.AbstractAbilityAnimation;
import javafx.util.Duration;

public class EmptyAnimation extends AbstractAbilityAnimation{
	public EmptyAnimation () {
		this.setCycleDuration(Duration.ZERO);
		this.setCycleCount(0);
	}

	@Override
	protected void interpolate(double frac) {
		
	}
}
