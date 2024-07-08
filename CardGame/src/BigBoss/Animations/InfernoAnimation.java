package BigBoss.Animations;

import BigBoss.AbstractAbilityAnimation;
import BigBoss.BigBossGame1;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class InfernoAnimation extends AbstractAbilityAnimation{
	
	ImageView inferno = new ImageView(getClass().getResource("/images/Fire Tornado.png").toString());
	TranslateTransition move = new TranslateTransition(Duration.seconds(.5), inferno);


	public InfernoAnimation () {
		this.setCycleDuration(Duration.seconds(3));
		this.addParticals(inferno);
		move.setAutoReverse(true);
		move.setCycleCount(6);
	}
	
	@Override
	public void play() {
		super.play();
		inferno.setLayoutY(-200);
		move.setFromX(BigBossGame1.IMAGE_WIDTH - 350);
		move.setToX(BigBossGame1.IMAGE_WIDTH - 250);
		move.play();
	}
	
	@Override
	protected void interpolate(double frac) {
		
	}
}