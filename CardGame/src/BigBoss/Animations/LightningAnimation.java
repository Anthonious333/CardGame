package BigBoss.Animations;

import BigBoss.AbstractAbilityAnimation;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import lichCharecter.Lich;

public class LightningAnimation extends AbstractAbilityAnimation{

	ImageView lightning = new ImageView(getClass().getResource("/images/Lightning.png").toString());

	
	public LightningAnimation() {
		this.setCycleDuration(Duration.seconds(1.5));
		this.addParticals(lightning);
	}
	
	@Override
	public void play() {
		super.play();
		lightning.setLayoutX(this.getSubject().getChildren().get(0).getLayoutX() + Lich.MINION_WIDTH - 50);
		lightning.setLayoutY(this.getSubject().getChildren().get(0).getLayoutY() - Lich.MINION_HEIGHT / 2);
	}
	
	@Override
	protected void interpolate(double frac) {
	}

}
