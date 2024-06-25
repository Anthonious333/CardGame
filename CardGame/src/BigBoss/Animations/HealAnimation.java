package BigBoss.Animations;

import BigBoss.AbstractAbilityAnimation;
import BigBoss.BigBossGame1;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class HealAnimation extends AbstractAbilityAnimation{

	ImageView greenPlus = new ImageView(getClass().getResource("/images/GreenPlus.png").toString());
	FadeTransition fade = new FadeTransition(Duration.seconds(.25), greenPlus);
	TranslateTransition move = new TranslateTransition(Duration.seconds(.5), greenPlus);
	
	public HealAnimation() {
		this.setCycleDuration(Duration.seconds(.5));
		this.addParticals(greenPlus);
		fade.setAutoReverse(true);
		fade.setFromValue(0.0);
		fade.setToValue(1.0);
	}
	
	@Override 
	public void play() {
		super.play();
		greenPlus.setLayoutX((this.getSubject().getLayoutX() + (BigBossGame1.HOLDER_WIDTH / 2) - 75));
		move.setFromY(this.getSubject().getLayoutY() + (BigBossGame1.HOLDER_HEIGHT / 2) - 100);
		move.setToY(this.getSubject().getLayoutY());
		fade.play();
		move.play();
	}
	
	@Override
	protected void interpolate(double frac) {
		
		
	}

}
