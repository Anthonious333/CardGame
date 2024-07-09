package BigBoss.Animations;

import BigBoss.AbstractAbilityAnimation;
import BigBoss.BigBossGame1;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import lichCharecter.Lich;

public class GustAnimation extends AbstractAbilityAnimation{

	ImageView wind = new ImageView(getClass().getResource("/images/Gust.png").toString());
	TranslateTransition move = new TranslateTransition(Duration.seconds(.25), wind);
	
	public GustAnimation() {
		this.setCycleDuration(Duration.seconds(1));
		this.addParticals(wind);
		move.setAutoReverse(true);
		move.setCycleCount(4);
	}
	
	@Override
	public void play() {
		super.play();
		wind.setLayoutY(-Lich.MINION_HEIGHT / 2);
		move.setFromX(Lich.MINION_WIDTH / 2);
		move.setToX(Lich.MINION_WIDTH);
		move.play();
	}
	
	@Override
	protected void interpolate(double frac) {
		
	}

}
